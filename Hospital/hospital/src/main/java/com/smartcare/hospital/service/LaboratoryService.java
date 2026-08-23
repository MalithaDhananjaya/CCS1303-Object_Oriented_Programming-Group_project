package com.smartcare.hospital.service;

import com.smartcare.hospital.model.Laboratory;
import com.smartcare.hospital.repository.LaboratoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LaboratoryService {
    @Autowired
    private LaboratoryRepository laboratoryRepository;

    public List<Laboratory> getAllLabTests() { return laboratoryRepository.findAll(); }
    public Laboratory addLabTest(Laboratory test) { return laboratoryRepository.save(test); }
}