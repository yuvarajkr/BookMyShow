package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.StandardException;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private int rowNum;
    private int colNum;
    private String number;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;
}
