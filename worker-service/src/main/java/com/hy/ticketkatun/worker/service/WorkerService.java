package com.hy.ticketkatun.worker.service;

import com.hy.ticketkatun.otp.event.BookingCompletedEvent;
import com.hy.ticketkatun.worker.model.Seat;
import com.hy.ticketkatun.worker.model.Train;
import com.hy.ticketkatun.worker.repository.SeatRepository;
import com.hy.ticketkatun.worker.repository.TrainRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class WorkerService {
    @KafkaListener(topics = "booking-completed-worker")
    public void listen(BookingCompletedEvent bookingCompletedEvent) {
        log.info("Saving confirmed Booking to db {}", bookingCompletedEvent);
        updateDatabase(bookingCompletedEvent);
    }

    private final SeatRepository seatRepository;
    private final TrainRepository trainRepository;

    public void updateDatabase(BookingCompletedEvent bookingCompletedEvent) {
        // Update database
        log.info("Updating database");

        String trainName = bookingCompletedEvent.getTrainName().toString();
        String seatNumber = bookingCompletedEvent.getSeatNumber().toString();

        // increasing one available ticket for the train
        log.info("looking for {}" , trainName);
        Optional<Train> train = trainRepository.findByName(trainName);
        if (train.isPresent()) {
            train.get().setTicketsRemaining(train.get().getTicketsRemaining() - 1);
            trainRepository.save(train.get());
        } else {
            throw new RuntimeException("Train not found");
        }

        // make seatNumber booked
        Optional<Seat> seat = seatRepository.findBySeatNumber(seatNumber);
        if (seat.isPresent()) {
            seat.get().setIsBooked(true);
            seatRepository.save(seat.get());
        } else {
            throw new RuntimeException("Seat not found");
        }
    }
}
