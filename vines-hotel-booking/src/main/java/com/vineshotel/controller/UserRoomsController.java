package com.vineshotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vineshotel.service.RoomService;

@Controller
public class UserRoomsController {
	
	@Autowired
	private RoomService roomService;
	
	@GetMapping("/rooms")
	public String roomsPage(Model model){
		model.addAttribute("rooms", roomService.getAllRooms());
		return "rooms";
	}
}
