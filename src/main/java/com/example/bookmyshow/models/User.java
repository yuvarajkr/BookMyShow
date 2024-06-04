package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity(name="Users")
public class User extends BaseModel{
    private String name;
    private String email;
    private String password;
    private String phone;
    private List<Booking> bookings;
}
