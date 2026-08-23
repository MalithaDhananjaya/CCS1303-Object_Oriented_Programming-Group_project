package com.smartcare.hospital.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "admissions")
public class Admission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer admissionId;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private String roomType; // General, Private, ICU
    private String roomNumber;
    private LocalDate admissionDate;

    public Admission() {}

    public Integer getAdmissionId() { return admissionId; }
    public void setAdmissionId(Integer admissionId) { this.admissionId = admissionId; }
    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }
    public String getRoomType() { return roomType; }
    public void setRoomType(String roomType) { this.roomType = roomType; }
    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }
    public LocalDate getAdmissionDate() { return admissionDate; }
    public void setAdmissionDate(LocalDate admissionDate) { this.admissionDate = admissionDate; }
}