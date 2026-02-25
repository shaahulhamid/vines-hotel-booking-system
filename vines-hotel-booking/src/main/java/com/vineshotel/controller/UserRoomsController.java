package com.vineshotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vineshotel.service.RoomService;

@Controller
public class UserRoomsController {

    private final RoomService roomService;

    public UserRoomsController(RoomService roomService) {
        this.roomService = roomService;
    }

    // ✅ User View Only
    @GetMapping("/rooms")
    public String roomsPage(Model model) {
        model.addAttribute("rooms", roomService.getAllRooms());
        return "rooms";
    }
    
 // Show booking page for selected room
    @GetMapping("/book/{roomId}")
    public String showBookingPage(@PathVariable Long roomId) {
        return "booking";   // templates/booking.html
    }
}
