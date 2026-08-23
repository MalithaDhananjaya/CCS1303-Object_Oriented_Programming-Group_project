package com.smartcare.hospital.service;

import com.smartcare.hospital.model.Doctor;
import com.smartcare.hospital.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Integer id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor not found with id: " + id));
    }

    public Doctor createDoctor(Doctor doctor) {
        // consultationFee null and 0
        if (doctor.getConsultationFee() == null || doctor.getConsultationFee() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Consultation fee must be greater than zero!");
        }
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(Integer id, Doctor doctorDetails) {
        Doctor doctor = getDoctorById(id);

        if (doctorDetails.getConsultationFee() == null || doctorDetails.getConsultationFee() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Consultation fee must be greater than 0");
        }

        // doctorName  fullName
        doctor.setFullName(doctorDetails.getFullName());
        doctor.setQualification(doctorDetails.getQualification());
        doctor.setSpecialization(doctorDetails.getSpecialization());
        doctor.setContactNumber(doctorDetails.getContactNumber());
        doctor.setConsultationFee(doctorDetails.getConsultationFee());

        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(Integer id) {
        Doctor doctor = getDoctorById(id);
        doctorRepository.delete(doctor);
    }
}