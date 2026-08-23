package com.smartcare.hospital.repository;

import com.smartcare.hospital.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    // Contact number  Patient ?
    Optional<Patient> findByContactNumber(String contactNumber);

}