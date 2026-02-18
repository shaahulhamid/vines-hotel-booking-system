package com.vineshotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
