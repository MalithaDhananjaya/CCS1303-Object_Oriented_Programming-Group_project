package com.smartcare.hospital.model;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {

    private String fullName;
    private String contactNumber;

    public Person() {}

    public Person(String fullName, String contactNumber) {
        this.fullName = fullName;
        this.contactNumber = contactNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}