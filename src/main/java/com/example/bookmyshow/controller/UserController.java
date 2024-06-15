package com.example.bookmyshow.controller;

import com.example.bookmyshow.dtos.*;
import com.example.bookmyshow.models.User;
import com.example.bookmyshow.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignupResponseDto signup(RequestSignupDto requestSignupDto) {
        SignupResponseDto signupResponseDto = new SignupResponseDto();
        try{
            User user = userService.signup(requestSignupDto.getName(),requestSignupDto.getEmailId(),
                        requestSignupDto.getPassword());
            signupResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            signupResponseDto.setUserId(user.getId());
        }catch (Exception e) {
            signupResponseDto.setResponseStatus(ResponseStatus.FAILED);
        }
        return signupResponseDto;
    }

    public LoginResponseDto login(RequestLoginDto requestLoginDto){
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        try{
            User user = userService.login(requestLoginDto.getEmail(), requestLoginDto.getPassword());
            loginResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            loginResponseDto.setResponseStatus(ResponseStatus.FAILED);
        }
        return loginResponseDto;
    }
}
