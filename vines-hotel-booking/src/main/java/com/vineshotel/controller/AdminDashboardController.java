package com.vineshotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vineshotel.repository.BookingRepository;
import com.vineshotel.repository.RoomRepository;
import com.vineshotel.repository.UserRepository;

@Controller
public class AdminDashboardController {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/admin/dashboard")
    public String dashboard(Model model) {

        // Dashboard Stats
        long totalRooms = roomRepository.count();
        long totalBookings = bookingRepository.count();
        long totalUsers = userRepository.count();

        model.addAttribute("totalRooms", totalRooms);
        model.addAttribute("totalBookings", totalBookings);
        model.addAttribute("totalUsers", totalUsers);

        return "admin/dashboard";
    }
}
