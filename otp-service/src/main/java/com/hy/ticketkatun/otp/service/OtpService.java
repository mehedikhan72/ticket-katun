package com.hy.ticketkatun.otp.service;

import com.hy.ticketkatun.otp.event.PaymentMadeEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OtpService {

    @KafkaListener(topics = "payment-made")
    public void listen(PaymentMadeEvent paymentMadeEvent) {
        log.info("Received Payment Made Event  {}", paymentMadeEvent);
        processBookingCompletion(paymentMadeEvent);
    }

    void processBookingCompletion(PaymentMadeEvent paymentMadeEvent) {
        log.info("Processing completion for Payment Made Event {}", paymentMadeEvent);
    }
}
