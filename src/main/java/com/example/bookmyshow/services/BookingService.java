package com.example.bookmyshow.services;

import com.example.bookmyshow.exceptions.ShowNotFoundException;
import com.example.bookmyshow.exceptions.UserNotFoundException;
import com.example.bookmyshow.models.*;
import com.example.bookmyshow.repositories.BookingRepository;
import com.example.bookmyshow.repositories.ShowSeatRepository;
import com.example.bookmyshow.repositories.Showrepository;
import com.example.bookmyshow.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final UserRepository userRepository;
    private final ShowSeatRepository showSeatRepository;
    private final Showrepository showrepository;
    private final BookingRepository bookingRepository;
    private final PriceCalculateService priceCalculateService;

    public BookingService(UserRepository userRepository, ShowSeatRepository showSeatRepository,
                          Showrepository showrepository, BookingRepository bookingRepository,
                          PriceCalculateService priceCalculateService) {
        this.userRepository = userRepository;
        this.showSeatRepository = showSeatRepository;
        this.showrepository = showrepository;
        this.bookingRepository = bookingRepository;
        this.priceCalculateService=priceCalculateService;
    }


    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking createBooking(Long userId, List<Long> showSeatIds, Long showId) throws UserNotFoundException, ShowNotFoundException {
        Optional<User> optionalUser = userRepository.findById(userId);

        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("User with UserId "+ userId +" is not available");
        }
        User user = optionalUser.get();

        Optional<Show> optionShows = showrepository.findById(showId);
        if(optionShows.isEmpty()){
            throw new ShowNotFoundException("ShowId "+ showId +" is invalid");
        }
        Show show = optionShows.get();

        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

        for(ShowSeat showSeat: showSeats){
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new RuntimeException("Show seat with id : "+ showSeat.getId() + " isn't available.");
            }
        }

        for(ShowSeat showSeat: showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);

            showSeatRepository.save(showSeat);
        }

        Booking booking = new Booking();
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setUser(user);
        booking.setShowSeats(showSeats);
        booking.setCreatedAt(LocalDateTime.now());
        booking.setShow(show);
        booking.setPayments(new ArrayList<>());
        booking.setAmount(priceCalculateService.calculatePrice(show, showSeats));

        return bookingRepository.save(booking);
    }
}
