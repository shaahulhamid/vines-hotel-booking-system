package com.vineshotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vineshotel.entity.Room;
import com.vineshotel.service.RoomService;

@Controller
@RequestMapping("/admin/rooms")
public class AdminRoomController {

    @Autowired
    private RoomService roomService;

    // ✅ Show All Rooms (Admin Dashboard)
    @GetMapping
    public String manageRooms(Model model) {
        model.addAttribute("rooms", roomService.getAllRooms());
        return "admin/manage-rooms";
    }

    // ✅ Show Add Room Form
    @GetMapping("/add")
    public String addRoomForm(Model model) {
        model.addAttribute("room", new Room());
        return "admin/add-room";
    }

    // ✅ Save New Room
    @PostMapping("/save")
    public String saveRoom(@ModelAttribute("room") Room room) {
        roomService.saveRoom(room);
        return "redirect:/admin/rooms";
    }

    // ✅ Delete Room
    @GetMapping("/delete/{id}")
    public String deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return "redirect:/admin/rooms";
    }

    // ✅ Show Edit Room Form
    @GetMapping("/edit/{id}")
    public String editRoomForm(@PathVariable Long id, Model model) {
        Room room = roomService.getRoomById(id);
        model.addAttribute("room", room);
        return "admin/edit-room";
    }

    // ✅ Update Room (MOST IMPORTANT)
    @PostMapping("/update/{id}")
    public String updateRoom(@PathVariable Long id,
                             @ModelAttribute("room") Room room) {

        // Ensure correct ID is set
        room.setId(id);

        roomService.saveRoom(room);

        return "redirect:/admin/rooms";
    }
}
