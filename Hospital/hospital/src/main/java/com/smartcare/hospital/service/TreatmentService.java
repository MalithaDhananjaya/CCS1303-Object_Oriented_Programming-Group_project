package com.smartcare.hospital.service;

import com.smartcare.hospital.model.Treatment;
import com.smartcare.hospital.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TreatmentService {
    @Autowired
    private TreatmentRepository treatmentRepository;

    public List<Treatment> getAllTreatments() { return treatmentRepository.findAll(); }
    public Treatment addTreatment(Treatment treatment) { return treatmentRepository.save(treatment); }
}