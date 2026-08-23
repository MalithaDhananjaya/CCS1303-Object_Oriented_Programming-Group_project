package com.smartcare.hospital.controller;

import com.smartcare.hospital.model.Treatment;
import com.smartcare.hospital.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/treatments")
@CrossOrigin
public class TreatmentController {
    @Autowired
    private TreatmentService treatmentService;

    @GetMapping
    public List<Treatment> getAllTreatments() { return treatmentService.getAllTreatments(); }

    @PostMapping
    public Treatment addTreatment(@RequestBody Treatment treatment) { return treatmentService.addTreatment(treatment); }
}