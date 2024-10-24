package com.hy.ticketkatun.worker.repository;

import com.hy.ticketkatun.worker.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat, String> {
    Optional<Seat> findBySeatNumber(String seatNumber);
}
