package com.hy.ticketkatun.reservation.service;

import com.hy.ticketkatun.reservation.event.PaymentInitiatedEvent;
import com.hy.ticketkatun.reservation.event.TicketBookedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReservationService {
    private final KafkaTemplate<String, PaymentInitiatedEvent> kafkaTemplate;

    @KafkaListener(topics = "ticket-booked")
    public void listen(TicketBookedEvent ticketBookedEvent) {
        log.info("Received ticketBookedEvent {}", ticketBookedEvent);
        processPayment(ticketBookedEvent);
    }

    void processPayment(TicketBookedEvent ticketBookedEvent) {
        PaymentInitiatedEvent paymentInitiatedEvent = new PaymentInitiatedEvent(
                ticketBookedEvent.getSeatNumber(),
                ticketBookedEvent.getTrainName()
        );
        log.info("Processing payment for ticketBookedEvent {}", ticketBookedEvent);
        kafkaTemplate.send("payment-initiated", paymentInitiatedEvent);
        log.info("Msg sent for payment init {}", ticketBookedEvent);
    }
}