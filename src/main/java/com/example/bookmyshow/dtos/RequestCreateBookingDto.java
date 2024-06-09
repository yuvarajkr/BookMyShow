package com.example.bookmyshow.dtos;

import com.example.bookmyshow.models.ShowSeat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter

public class RequestCreateBookingDto {
    private List<Long> showSeatIds;
    private Long userId;
    private Long showId;
}
