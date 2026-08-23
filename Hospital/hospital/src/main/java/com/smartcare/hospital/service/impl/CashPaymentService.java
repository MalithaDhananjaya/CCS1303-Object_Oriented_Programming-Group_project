package com.smartcare.hospital.service.impl;

import com.smartcare.hospital.service.PaymentService;
import org.springframework.stereotype.Service;

@Service("cashPaymentService")
public class CashPaymentService implements PaymentService {
    @Override
    public double calculateFinalBill(double amount) {
        // Cash
        return amount;
    }
}