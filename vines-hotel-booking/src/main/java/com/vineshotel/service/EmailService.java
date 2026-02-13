package com.vineshotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.vineshotel.entity.Booking;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendBookingConfirmation( Booking booking ) {
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setTo(booking.getEmail());
		message.setSubject("Booking confirmation : The Vines Hotel");
		
		message.setText(
				 "Hello " + booking.getFullName() + ",\n\n"
			              + "Thank you for choosing The Vines Hotel 🌿\n\n"
			              + "Your booking request has been received successfully.\n\n"
			              + "Booking ID: " + booking.getId() + "\n"
			              + "Room Type: " + booking.getRoomType() + "\n"
			              + "Check-in: " + booking.getCheckInDate() + "\n"
			              + "Check-out: " + booking.getCheckOutDate() + "\n\n"
			              + "We will contact you soon for confirmation.\n\n"
			              + "Regards,\n"
			              + "The Vines Hotel Team"
					);
		
		mailSender.send(message);
	}
}
