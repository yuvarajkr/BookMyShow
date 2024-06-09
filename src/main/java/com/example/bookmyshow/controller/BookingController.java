package com.example.bookmyshow.controller;

import com.example.bookmyshow.dtos.RequestCreateBookingDto;
import com.example.bookmyshow.dtos.ResponseCreateBookingDto;
import com.example.bookmyshow.dtos.ResponseStatus;
import com.example.bookmyshow.models.Booking;
import com.example.bookmyshow.services.BookingService;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public ResponseCreateBookingDto createBooking(RequestCreateBookingDto requestCreateBookingDto) {
        ResponseCreateBookingDto responseCreateBookingDto = new ResponseCreateBookingDto();
        try{
            Booking booking = bookingService.createBooking(requestCreateBookingDto.getUserId(),
                    requestCreateBookingDto.getShowSeatIds(),
                    requestCreateBookingDto.getShowId()
                    );
            responseCreateBookingDto.setBookingId(booking.getId());
            responseCreateBookingDto.setStatus(ResponseStatus.SUCCESS);
        }
        catch(Exception e){
            responseCreateBookingDto.setStatus(ResponseStatus.FAILED);
        }

        return responseCreateBookingDto;
    }
}
