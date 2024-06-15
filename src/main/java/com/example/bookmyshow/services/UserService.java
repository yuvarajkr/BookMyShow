package com.example.bookmyshow.services;

import com.example.bookmyshow.exceptions.UserNotFoundException;
import com.example.bookmyshow.models.User;
import com.example.bookmyshow.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signup(String name, String email, String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(encoder.encode(password));

        return userRepository.save(user);
    }

    public User login(String email, String password) throws UserNotFoundException {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        Optional<User> email_user = userRepository.findByEmail(email);

        if(email_user.isEmpty()){
            throw new UserNotFoundException("User not found, Sign Up!!");
        }

        User user = email_user.get();
        try{
            encoder.matches(password,email_user.get().getPassword());
        }catch (Exception e){
            throw new RuntimeException("Password incorrect");
        }

        return user;
    }
}
