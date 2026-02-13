package com.vineshotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.vineshotel.entity.Booking;
import com.vineshotel.entity.Room;
import com.vineshotel.repository.BookingRepository;
import com.vineshotel.repository.RoomRepository;

@Controller
public class HotelController {
	
		@Autowired
		private BookingRepository bookingRepo;
		
		@Autowired
		private RoomRepository roomRepo;
	
		@GetMapping("/")
		public String homePage() {
			return "home";
		}
		
		//Rooms page
		@GetMapping("/rooms")
		public String roomsPage(Model model) {
			model.addAttribute("rooms", roomRepo.findAll());
			return "rooms";
		}
		
		//Booking
		@GetMapping("/book")
		public String bookingPage(Model model) {
			model.addAttribute("rooms", roomRepo.findAll());
			return "book";
		}
		
		//Submit booking
		@PostMapping("/submitBooking")
		public String submitBooking(@ModelAttribute Booking booking, Model model) {
			Booking savedBooking = bookingRepo.save(booking);
			// send booking details to success page
			model.addAttribute("booking", savedBooking);
			return "booking-success";
		}
		
		//Admin booking
		@GetMapping("/admin/bookings")
		public String viewBookings(Model model) {
			model.addAttribute("bookings", bookingRepo.findAll());
			return "admin-bookings";
		}
		
		// Approve
		@GetMapping("/admin/approve/{id}")
		public String approveBooking(@PathVariable Long id) {
			Booking booking = bookingRepo.findById(id).orElseThrow();
			booking.setStatus("APPROVED");
			bookingRepo.save(booking);
			
			return "redirect:/admin/bookings";
		}
		
		//Reject
		@GetMapping("/admin/reject/{id}")
		public String rejectBooking(@PathVariable Long id) {
			Booking booking = bookingRepo.findById(id).orElseThrow();
			booking.setStatus("REJECTED");
			bookingRepo.save(booking);
			
			return "redirect:/admin/bookings";
		}
		
		// Add room
		@GetMapping("/admin/addRoom")
		public String addRoomPage() {
			return "add-room";
		}
		
		// Save room
		@PostMapping("/admin/saveRoom")
		public String saveRoom(@ModelAttribute Room room) {
			roomRepo.save(room);
			return "redirect:/admin/addRoom";
		}

}
