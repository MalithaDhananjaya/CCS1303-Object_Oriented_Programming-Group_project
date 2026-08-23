package com.smartcare.hospital.service.impl;

import com.smartcare.hospital.service.PaymentService;
import org.springframework.stereotype.Service;

@Service("cardPaymentService")
public class CardPaymentService implements PaymentService {
    @Override
    public double calculateFinalBill(double amount) {
        // Card Payment  2% Bank charge
        return amount + (amount * 0.02);
    }
}