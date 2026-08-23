package com.smartcare.hospital.model;

import jakarta.persistence.*;

@Entity
@Table(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer billId;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private Double consultationFee;
    private Double roomCharges;
    private Double labCharges;
    private Double totalAmount;
    private String paymentMode; // CASH or CARD

    public Bill() {}

    public Integer getBillId() { return billId; }
    public void setBillId(Integer billId) { this.billId = billId; }
    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }
    public Double getConsultationFee() { return consultationFee; }
    public void setConsultationFee(Double consultationFee) { this.consultationFee = consultationFee; }
    public Double getRoomCharges() { return roomCharges; }
    public void setRoomCharges(Double roomCharges) { this.roomCharges = roomCharges; }
    public Double getLabCharges() { return labCharges; }
    public void setLabCharges(Double labCharges) { this.labCharges = labCharges; }
    public Double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }
    public String getPaymentMode() { return paymentMode; }
    public void setPaymentMode(String paymentMode) { this.paymentMode = paymentMode; }
}