package com.vineshotel.service;

import org.springframework.stereotype.Service;
import com.vineshotel.entity.Booking;
import com.vineshotel.repository.BookingRepository;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking saveBooking(Booking booking) {
        booking.setStatus("PENDING"); // default safety
        return bookingRepository.save(booking);
    }
}