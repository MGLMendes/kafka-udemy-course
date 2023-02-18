package com.miguel.paymentservice.service.impl;

import com.miguel.paymentservice.model.Payment;
import com.miguel.paymentservice.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Log4j2
@Service
public class PaymenteServiceImpl implements PaymentService {
    @Override
    public void sendPayment(Payment payment) {
        log.info("PAYMENT SERVICE IMPL ::: Received payment {}", payment);
    }
}
