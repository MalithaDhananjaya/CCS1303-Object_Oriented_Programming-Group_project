package com.smartcare.hospital.controller;

import com.smartcare.hospital.model.Bill;
import com.smartcare.hospital.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bills")
@CrossOrigin
public class BillController {
    @Autowired
    private BillService billService;

    @GetMapping
    public List<Bill> getAllBills() { return billService.getAllBills(); }

    @PostMapping
    public Bill generateBill(@RequestBody Bill bill) { return billService.generateBill(bill); }
}