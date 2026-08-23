package com.smartcare.hospital.service;

import com.smartcare.hospital.model.Bill;
import com.smartcare.hospital.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    @Qualifier("cashPaymentService")
    private PaymentService cashPaymentService;

    @Autowired
    @Qualifier("cardPaymentService")
    private PaymentService cardPaymentService;

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public Bill generateBill(Bill bill) {
        double subtotal = (bill.getConsultationFee() != null ? bill.getConsultationFee() : 0) +
                (bill.getRoomCharges() != null ? bill.getRoomCharges() : 0) +
                (bill.getLabCharges() != null ? bill.getLabCharges() : 0);

        // Polymorphism
        if ("CARD".equalsIgnoreCase(bill.getPaymentMode())) {
            bill.setTotalAmount(cardPaymentService.calculateFinalBill(subtotal));
        } else {
            bill.setTotalAmount(cashPaymentService.calculateFinalBill(subtotal));
        }

        return billRepository.save(bill);
    }
}