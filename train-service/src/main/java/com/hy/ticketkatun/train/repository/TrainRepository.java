package com.hy.ticketkatun.train.repository;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.hy.ticketkatun.train.model.Train;
import io.micrometer.observation.annotation.Observed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Observed
public interface TrainRepository extends JpaRepository<Train, String> {
    Optional<Train> findByName(String trainName);
}