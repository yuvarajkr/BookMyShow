package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.StandardException;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private String number;
    private SeatType seatType;
    private int row;
    private int column;
}
