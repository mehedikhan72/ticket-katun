package com.hy.ticketkatun.worker.repository;

import com.hy.ticketkatun.worker.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrainRepository extends JpaRepository<Train, String> {
    Optional<Train> findByName(String trainName);
}
