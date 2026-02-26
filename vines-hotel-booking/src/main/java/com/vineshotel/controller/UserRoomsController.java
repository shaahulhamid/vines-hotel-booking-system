package com.vineshotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vineshotel.entity.Booking;
import com.vineshotel.service.BookingService;
import com.vineshotel.service.RoomService;

@Controller
public class UserRoomsController {

    private final RoomService roomService;
    
    private final BookingService bookingService;

    public UserRoomsController(RoomService roomService,
                               BookingService bookingService) {
        this.roomService = roomService;
        this.bookingService = bookingService;
    }

    // ✅ User View Only
    @GetMapping("/rooms")
    public String roomsPage(Model model) {
        model.addAttribute("rooms", roomService.getAllRooms());
        return "rooms";
    }
    
    @GetMapping("/book")
    public String showBookingForm(Model model) {

        model.addAttribute("rooms", roomService.getAllRooms());
        model.addAttribute("booking", new Booking());

        return "book";
    }
    
    @PostMapping("/submitBooking")
    public String submitBooking(@ModelAttribute Booking booking, Model model) {

        // Save booking to DB
        Booking savedBooking = bookingService.saveBooking(booking);

        // Send saved booking to success page
        model.addAttribute("booking", savedBooking);

        return "booking-success";
    }
}