package com.miguel.paymentservice.service.impl;

import com.miguel.paymentservice.model.Payment;
import com.miguel.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Log4j2
@Service
@RequiredArgsConstructor
public class PaymenteServiceImpl implements PaymentService {

    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    @SneakyThrows
    @Override
    public void sendPayment(Payment payment) {
        log.info("Received payment {}", payment);
        Thread.sleep(1000);

        log.info("Send payment...");
        kafkaTemplate.send("payment-topic", payment);

    }
}
