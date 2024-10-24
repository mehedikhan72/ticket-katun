package com.hy.ticketkatun.train.service;

import com.hy.ticketkatun.train.dto.SeatResponse;
import com.hy.ticketkatun.train.dto.TrainResponse;
import com.hy.ticketkatun.reservation.event.TicketBookedEvent;
import com.hy.ticketkatun.train.model.Seat;
import com.hy.ticketkatun.train.model.Train;
import com.hy.ticketkatun.train.repository.SeatRepository;
import com.hy.ticketkatun.train.repository.TrainRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TrainService {

    private static final Logger log = LoggerFactory.getLogger(TrainService.class);
    private final TrainRepository trainRepository;
    private final SeatRepository seatRepository;
    private final KafkaTemplate<String, TicketBookedEvent> kafkaTemplate;

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

    public String bookASeat(String trainName, String seatNumber) {
        // checking is seat is available in the db.
        Optional<Train> train = trainRepository.findByName(trainName);
        if(train.isEmpty()) {
            throw new RuntimeException("Train not found");
        }

        Optional<Seat> seat = seatRepository.findByTrainIdAndSeatNumber(train.get().getId(), seatNumber);
        if(seat.isEmpty()) {
            throw new RuntimeException("Seat not found");
        }

        if(seat.get().getIsBooked()) {
            throw new RuntimeException("Seat is already booked");
        }

        // todo: check redis cache for seat availability

        // book
        TicketBookedEvent ticketBookedEvent = new TicketBookedEvent(trainName, seatNumber);

        log.info("Start- Sending ticketBookedEvent {} to Kafka Topic", ticketBookedEvent);
        kafkaTemplate.send("ticket-booked", ticketBookedEvent);
        log.info("End- Sending ticketBookedEvent {} to Kafka Topic", ticketBookedEvent);

        // todo: update redis cache for seat availability

        return "Forwarded to reservation service";
    }
}
