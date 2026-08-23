package com.smartcare.hospital.controller;

import com.smartcare.hospital.model.Laboratory;
import com.smartcare.hospital.service.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/lab-tests")
@CrossOrigin
public class LaboratoryController {
    @Autowired
    private LaboratoryService laboratoryService;

    @GetMapping
    public List<Laboratory> getAllLabTests() { return laboratoryService.getAllLabTests(); }

    @PostMapping
    public Laboratory addLabTest(@RequestBody Laboratory test) { return laboratoryService.addLabTest(test); }
}