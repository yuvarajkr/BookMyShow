package com.example.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class ResponseCreateBookingDto {
    private int bookingId;
    private ResponseStatus status;
}
