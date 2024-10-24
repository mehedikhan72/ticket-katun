package com.hy.ticketkatun.payment.service;

import com.hy.ticketkatun.otp.event.PaymentMadeEvent;
import com.hy.ticketkatun.reservation.event.PaymentInitiatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {
    private final KafkaTemplate<String, PaymentMadeEvent> kafkaTemplate;

    @KafkaListener(topics = "payment-initiated")
    public void listen(PaymentInitiatedEvent paymentInitiatedEvent) {
        log.info("Received Payment Initiated Event for Booking. {}", paymentInitiatedEvent);

        // INFO: Mock api call to payment gateway i.e. SSLCommerz.
        // We assume a successful payment happened at this stage.
        processOtp(paymentInitiatedEvent);

    }

    public void processOtp(PaymentInitiatedEvent paymentInitiatedEvent) {
        PaymentMadeEvent paymentMadeEvent = new PaymentMadeEvent(
                paymentInitiatedEvent.getSeatNumber(),
                paymentInitiatedEvent.getTrainName()
        );
        log.info("Processing Otp Event {}", paymentMadeEvent);
        kafkaTemplate.send("payment-made", paymentMadeEvent);
        log.info("Otp event made {}", paymentMadeEvent);
    }
}
