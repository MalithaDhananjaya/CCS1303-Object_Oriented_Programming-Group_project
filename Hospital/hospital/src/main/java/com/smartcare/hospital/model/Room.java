package com.smartcare.hospital.model;

import jakarta.persistence.*;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomId;

    private String roomNumber;
    private String roomCategory;
    private Double dailyRate;
    private String status;

    public Integer getRoomId() { return roomId; }
    public void setRoomId(Integer roomId) { this.roomId = roomId; }

    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }

    public String getRoomCategory() { return roomCategory; }
    public void setRoomCategory(String roomCategory) { this.roomCategory = roomCategory; }

    public Double getDailyRate() { return dailyRate; }
    public void setDailyRate(Double dailyRate) { this.dailyRate = dailyRate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}