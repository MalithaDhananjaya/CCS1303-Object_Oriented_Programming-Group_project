package com.smartcare.hospital.controller;

import com.smartcare.hospital.model.Admission;
import com.smartcare.hospital.service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admissions")
@CrossOrigin
public class AdmissionController {
    @Autowired
    private AdmissionService admissionService;

    @GetMapping
    public List<Admission> getAllAdmissions() { return admissionService.getAllAdmissions(); }

    @PostMapping
    public Admission admitPatient(@RequestBody Admission admission) { return admissionService.admitPatient(admission); }
}