package com.example.bookmyshow.repositories;

import com.example.bookmyshow.models.ShowSeat;
import com.example.bookmyshow.models.ShowSeatStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {
    List<ShowSeat> findAllById(Iterator<Long> showSeatIds);

    ShowSeat save(ShowSeat showSeat);
}
