package com.vineshotel.service;

import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.vineshotel.entity.Booking;

@Service
public class PdfService {
	
	public byte[] generateBookingReceipt(Booking booking) {
		try {
			Document document = new Document();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			
			PdfWriter.getInstance(document, out);
			
			document.open();
			
			document.add(new Paragraph("🌿 The Vines Hotel"));
            document.add(new Paragraph("Booking Receipt"));
            document.add(new Paragraph("--------------------------------------------------"));

            document.add(new Paragraph("Booking ID: " + booking.getId()));
            document.add(new Paragraph("Customer Name: " + booking.getFullName()));
            document.add(new Paragraph("Email: " + booking.getEmail()));
            document.add(new Paragraph("Room Type: " + booking.getRoomType()));

            document.add(new Paragraph("Check-in Date: " + booking.getCheckInDate()));
            document.add(new Paragraph("Check-out Date: " + booking.getCheckOutDate()));

            document.add(new Paragraph("Adults: " + booking.getAdults()));
            document.add(new Paragraph("Children: " + booking.getChildren()));

            document.add(new Paragraph("Special Requests: " + booking.getSpecialRequests()));

            document.add(new Paragraph("--------------------------------------------------"));
            document.add(new Paragraph("Thank you for choosing The Vines Hotel!"));

            document.close();
            
            return out.toByteArray();
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
