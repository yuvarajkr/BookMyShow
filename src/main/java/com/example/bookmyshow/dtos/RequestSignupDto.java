package com.example.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestSignupDto {
    private String name;
    private String emailId;
    private String password;
}
