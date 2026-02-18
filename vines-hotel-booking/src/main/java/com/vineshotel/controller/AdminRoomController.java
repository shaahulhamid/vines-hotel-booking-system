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

    // ✅ Show All Rooms
    @GetMapping
    public String manageRooms(Model model) {
        model.addAttribute("rooms", roomService.getAllRooms());
        return "admin/manage-rooms";
    }

    // ✅ Add Room Page
    @GetMapping("/add")
    public String addRoomForm(Model model) {
        model.addAttribute("room", new Room());
        return "admin/add-room";
    }

    // ✅ Save Room
    @PostMapping("/save")
    public String saveRoom(@ModelAttribute Room room) {
        roomService.saveRoom(room);
        return "redirect:/admin/rooms";
    }

    // ✅ Delete Room
    @GetMapping("/delete/{id}")
    public String deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return "redirect:/admin/rooms";
    }

    // ✅ Edit Room Page
    @GetMapping("/edit/{id}")
    public String editRoom(@PathVariable Long id, Model model) {

        Room room = roomService.getRoomById(id);
        model.addAttribute("room", room);

        return "admin/edit-room";
    }

    // ✅ Update Room
    @PostMapping("/update")
    public String updateRoom(@ModelAttribute Room room) {

        roomService.saveRoom(room); // same save works for update
        return "redirect:/admin/rooms";
    }
}
