package com.vineshotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.vineshotel.entity.Booking;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;


@Service
public class EmailService {
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendBookingConfirmation( Booking booking, byte[] pdfBytes ) throws MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		
		MimeMessageHelper helper = new  MimeMessageHelper(message, true);
		
		helper.setTo(booking.getEmail());
		helper.setSubject("Booking confirmation : The Vines Hotel");
		
		helper.setText(
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
		
		//Attach PDF
		helper.addAttachment(
				"booking-receipt-"+booking.getId()+".pdf",
				new ByteArrayResource(pdfBytes)
				);
		
		mailSender.send(message);
	}
}
