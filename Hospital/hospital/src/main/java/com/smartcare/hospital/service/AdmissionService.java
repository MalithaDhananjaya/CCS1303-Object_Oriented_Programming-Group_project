package com.smartcare.hospital.service;

import com.smartcare.hospital.model.Admission;
import com.smartcare.hospital.repository.AdmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class AdmissionService {
    @Autowired
    private AdmissionRepository admissionRepository;

    public List<Admission> getAllAdmissions() { return admissionRepository.findAll(); }
    public Admission admitPatient(Admission admission) {
        if (admission.getAdmissionDate() == null) {
            admission.setAdmissionDate(LocalDate.now());
        }
        return admissionRepository.save(admission);
    }
}