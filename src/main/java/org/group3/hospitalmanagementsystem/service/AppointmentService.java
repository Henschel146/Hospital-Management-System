package org.group3.hospitalmanagementsystem.service;

import org.group3.hospitalmanagementsystem.entities.Appointment;
import org.group3.hospitalmanagementsystem.entities.Doctor;
import org.group3.hospitalmanagementsystem.entities.User;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {

    List<Appointment> findAll();

    Appointment create(Appointment appointment);

    Appointment getAppointment(int id);

    Appointment update(Appointment appointment);

    void batch();

    void delete(int id);

    Optional<Appointment> findByAppointmentId(Integer id);


}
