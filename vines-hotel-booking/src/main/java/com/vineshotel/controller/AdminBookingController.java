package com.vineshotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vineshotel.entity.Booking;
import com.vineshotel.repository.BookingRepository;

@Controller
@RequestMapping("/admin")
public class AdminBookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/bookings")
    public String viewBookings(Model model) {

        model.addAttribute("bookings", bookingRepository.findAll());

        return "admin/admin-bookings";
    }
    

    // ✅ Approve Booking
    @GetMapping("/bookings/approve/{id}")
    public String approveBooking(@PathVariable Long id) {

        Booking booking = bookingRepository.findById(id).orElse(null);

        if (booking != null) {
            booking.setStatus("APPROVED");
            bookingRepository.save(booking);
        }

        return "redirect:/admin/bookings";
    }

    // ✅ Reject Booking
    @GetMapping("/bookings/reject/{id}")
    public String rejectBooking(@PathVariable Long id) {

        Booking booking = bookingRepository.findById(id).orElse(null);

        if (booking != null) {
            booking.setStatus("REJECTED");
            bookingRepository.save(booking);
        }

        return "redirect:/admin/bookings";
    }
}
