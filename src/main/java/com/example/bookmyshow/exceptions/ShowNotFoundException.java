package com.example.bookmyshow.exceptions;

import com.example.bookmyshow.repositories.Showrepository;

public class ShowNotFoundException extends Exception{
    public ShowNotFoundException(String message){
        super(message);
    }
}
