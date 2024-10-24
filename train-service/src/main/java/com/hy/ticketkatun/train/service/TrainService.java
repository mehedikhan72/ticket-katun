package com.hy.ticketkatun.train.service;

import com.hy.ticketkatun.train.dto.SeatResponse;
import com.hy.ticketkatun.train.dto.TrainResponse;
import com.hy.ticketkatun.train.model.Train;
import com.hy.ticketkatun.train.repository.SeatRepository;
import com.hy.ticketkatun.train.repository.TrainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TrainService {
    private final TrainRepository trainRepository;
    private final SeatRepository seatRepository;

    public List<TrainResponse> getAllTrains() {
        return trainRepository.findAll()
                .stream()
                .map(train -> new TrainResponse(
                        train.getId(),
                        train.getName(),
                        train.getSource(),
                        train.getDestination(),
                        train.getTicketsRemaining())
                )
                .toList();
    }

    public List<SeatResponse> getSeatsOfATrain(String trainName) {
        Optional<Train> train = trainRepository.findByName(trainName);

        if (train.isEmpty()) {
            throw new RuntimeException("Train not found");
        }

        String trainId = train.get().getId();

        return seatRepository.findByTrainId(trainId)
                .stream()
                .map(seat -> new SeatResponse(
                        seat.getId(),
                        seat.getSeatNumber(),
                        seat.getIsBooked(),
                        trainId
                ))
                .toList();
    }
}
