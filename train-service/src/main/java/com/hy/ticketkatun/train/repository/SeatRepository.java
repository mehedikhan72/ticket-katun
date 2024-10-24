package com.hy.ticketkatun.train.repository;

import com.hy.ticketkatun.train.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, String> {
    List<Seat> findByTrainId(String trainId);
}
