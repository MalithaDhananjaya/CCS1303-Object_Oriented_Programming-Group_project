package com.smartcare.hospital.service;

import com.smartcare.hospital.model.Room;
import com.smartcare.hospital.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(Integer id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Room not found with id: " + id));
    }

    public Room createRoom(Room room) {
        if (room.getStatus() == null) {
            room.setStatus("AVAILABLE");
        }
        return roomRepository.save(room);
    }
}