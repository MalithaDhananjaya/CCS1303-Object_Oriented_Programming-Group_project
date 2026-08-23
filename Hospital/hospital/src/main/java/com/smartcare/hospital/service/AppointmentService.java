package com.smartcare.hospital.service;

import com.smartcare.hospital.model.Appointment;
import com.smartcare.hospital.exception.AppointmentConflictException;
import com.smartcare.hospital.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(Integer id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
    }

    public Appointment createAppointment(Appointment appointment) {
        // Null Check
        if (appointment.getAppointmentDate() == null) {
            throw new RuntimeException("Appointment date is required.");
        }

        if (appointment.getAppointmentDate().isBefore(LocalDate.now())) {
            throw new RuntimeException("Appointment date cannot be in the past.");
        }

        boolean isDoctorBusy = appointmentRepository.existsByDoctorDoctorIdAndAppointmentDateAndAppointmentTime(
                appointment.getDoctor().getDoctorId(),
                appointment.getAppointmentDate(),
                appointment.getAppointmentTime()
        );

        if (isDoctorBusy) {
            throw new AppointmentConflictException("Doctor is already booked at this date and time!");
        }

        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointment(Integer id, Appointment appointmentDetails) {
        boolean isDoctorBusy = appointmentRepository.existsByDoctorDoctorIdAndAppointmentDateAndAppointmentTimeAndAppointmentIdNot(
                appointmentDetails.getDoctor().getDoctorId(),
                appointmentDetails.getAppointmentDate(),
                appointmentDetails.getAppointmentTime(),
                id
        );

        if (isDoctorBusy) {
            throw new AppointmentConflictException("Doctor is already booked at this date and time!");
        }

        appointmentDetails.setAppointmentId(id);
        return appointmentRepository.save(appointmentDetails);
    }

    public void cancelAppointment(Integer id) {
        Appointment appointment = getAppointmentById(id);
        appointment.setAppointmentStatus("CANCELLED");
        appointmentRepository.save(appointment);
    }
}