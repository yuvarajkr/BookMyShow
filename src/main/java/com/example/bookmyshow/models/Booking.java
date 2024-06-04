package com.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{
    private String bookingNumber;
    @ManyToOne
    private Show show;
    @ManyToMany
    private List<ShowSeat> showSeats;
    @ManyToOne
    private User user;
    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;
    @OneToMany
    private List<Payment> payments;
    
    private int amount;
}
