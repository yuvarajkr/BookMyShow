package com.example.bookmyshow.services;

import com.example.bookmyshow.models.Show;
import com.example.bookmyshow.models.ShowSeat;
import com.example.bookmyshow.models.ShowSeatType;
import com.example.bookmyshow.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculateService {
    public final ShowSeatTypeRepository showSeatTypeRepository;

    public PriceCalculateService(ShowSeatTypeRepository showSeatTypeRepository){
        this.showSeatTypeRepository=showSeatTypeRepository;
    }


    public int calculatePrice(Show show, List<ShowSeat> showSeats){
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);

        int amount = 0;
        for(ShowSeat showSeat: showSeats){
            for(ShowSeatType showSeatType: showSeatTypes){
                if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())){
                    amount+=showSeatType.getPrice();
                    break;
                }
            }
        }
        return amount;
    }
}
