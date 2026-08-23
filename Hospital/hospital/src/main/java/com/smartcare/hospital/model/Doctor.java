package com.smartcare.hospital.model;

import jakarta.persistence.*;

@Entity
@Table(name = "doctors")
public class Doctor extends Person { // Inheritance

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctorId;

    private String qualification;
    private String specialization;
    private Double consultationFee;

    public Doctor() {}

    // Getters and Setters for Doctor specific fields
    public Integer getDoctorId() { return doctorId; }
    public void setDoctorId(Integer doctorId) { this.doctorId = doctorId; }

    public String getQualification() { return qualification; }
    public void setQualification(String qualification) { this.qualification = qualification; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public Double getConsultationFee() { return consultationFee; }
    public void setConsultationFee(Double consultationFee) { this.consultationFee = consultationFee; }
}