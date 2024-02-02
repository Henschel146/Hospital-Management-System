package org.group3.hospitalmanagementsystem.service;

import org.group3.hospitalmanagementsystem.entities.Appointment;
import org.group3.hospitalmanagementsystem.entities.User;
import org.group3.hospitalmanagementsystem.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("appointmentService")
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }
    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public User create(Appointment appointment) {
        return null;
    }

    @Override
    public Appointment getSpeaker(int id) {
        return null;
    }

    @Override
    public Appointment update(Appointment appointment) {
        return null;
    }

    @Override
    public void batch() {

    }

    @Override
    public void delete(int id) {

    }
}
