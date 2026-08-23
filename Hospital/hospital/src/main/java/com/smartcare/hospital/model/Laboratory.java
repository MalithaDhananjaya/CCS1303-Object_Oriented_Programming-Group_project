package com.smartcare.hospital.model;

import jakarta.persistence.*;

@Entity
@Table(name = "laboratory_tests")
public class Laboratory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer testId;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private String testName;
    private String testResult;
    private Double testCost;

    public Laboratory() {}

    public Integer getTestId() { return testId; }
    public void setTestId(Integer testId) { this.testId = testId; }
    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }
    public String getTestName() { return testName; }
    public void setTestName(String testName) { this.testName = testName; }
    public String getTestResult() { return testResult; }
    public void setTestResult(String testResult) { this.testResult = testResult; }
    public Double getTestCost() { return testCost; }
    public void setTestCost(Double testCost) { this.testCost = testCost; }
}