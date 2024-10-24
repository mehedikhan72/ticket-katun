package com.hy.ticketkatun.notification.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.hy.ticketkatun.otp.event.BookingCompletedEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {
    @KafkaListener(topics = "booking-completed-notification")
    public void listen(BookingCompletedEvent bookingCompletedEvent) {
        log.info("Notification sent for booking completed event: {}", bookingCompletedEvent);

        // Mocking notification.....
    }
}
