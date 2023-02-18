package com.miguel.paymentservice.service;

import com.miguel.paymentservice.model.Payment;

public interface PaymentService {

    void sendPayment(Payment payment);
}
