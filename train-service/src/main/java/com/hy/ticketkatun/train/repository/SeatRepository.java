package com.hy.ticketkatun.train.repository;

import com.hy.ticketkatun.train.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat, String> {
    List<Seat> findByTrainId(String trainId);
    Optional<Seat> findByTrainIdAndSeatNumber(String trainId, String seatNumber);
}
