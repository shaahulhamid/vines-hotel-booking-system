package com.vineshotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HotelController {
	
		@GetMapping("/")
		public String homePage() {
			return "home";
		}
		
		//Rooms page
		@GetMapping("/rooms")
		public String roomsPage() {
			return "rooms";
		}
		
		//Booking
		@GetMapping("/book")
		public String bookingPage() {
			return "book";
		}
}
