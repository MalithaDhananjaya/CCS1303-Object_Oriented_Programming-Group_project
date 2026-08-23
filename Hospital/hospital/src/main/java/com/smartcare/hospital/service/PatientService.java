package com.smartcare.hospital.service;

import com.smartcare.hospital.model.Patient;
import com.smartcare.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Integer id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found with id: " + id));
    }

    public Patient createPatient(Patient patient) {
        // New Patient Contact Number  Duplicate
        Optional<Patient> existingPatient = patientRepository.findByContactNumber(patient.getContactNumber());
        if (existingPatient.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contact number is already in use!");
        }
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Integer id, Patient patientDetails) {
        Patient patient = getPatientById(id);

        // Update Contact Number Patient
        Optional<Patient> existingContact = patientRepository.findByContactNumber(patientDetails.getContactNumber());
        if (existingContact.isPresent() && !existingContact.get().getPatientId().equals(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contact number is already used by another patient!");
        }

        patient.setFullName(patientDetails.getFullName());
        patient.setContactNumber(patientDetails.getContactNumber());
        patient.setDob(patientDetails.getDob());
        patient.setGender(patientDetails.getGender());
        patient.setAddress(patientDetails.getAddress());
        patient.setEmergencyContact(patientDetails.getEmergencyContact());
        patient.setBloodGroup(patientDetails.getBloodGroup());

        return patientRepository.save(patient);
    }

    public void deletePatient(Integer id) {
        Patient patient = getPatientById(id);
        patientRepository.delete(patient);
    }
}