package com.vineshotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vineshotel.entity.Booking;
import com.vineshotel.repository.BookingRepository;

@Controller
public class HotelController {
	
		@Autowired
		private BookingRepository bookingRepo;
	
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
		
		//Submit booking
		@PostMapping("/submitBooking")
		public String submitBooking(@ModelAttribute Booking booking) {
			bookingRepo.save(booking);
			return "booking-success";
		}
}
