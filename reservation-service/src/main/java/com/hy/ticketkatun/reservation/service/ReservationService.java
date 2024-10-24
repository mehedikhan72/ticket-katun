package com.hy.ticketkatun.reservation.service;

import com.hy.ticketkatun.reservation.event.TicketBookedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReservationService {
    @KafkaListener(topics = "ticket-booked")
    public void listen(TicketBookedEvent ticketBookedEvent) {
        log.info("Received ticketBookedEvent {}", ticketBookedEvent);
    }
}