package org.group3.hospitalmanagementsystem.service;

import org.group3.hospitalmanagementsystem.entities.Appointment;
import org.group3.hospitalmanagementsystem.entities.User;

import java.util.List;

public interface AppointmentService {

    List<Appointment> findAll();

    User create(Appointment appointment);

    Appointment getSpeaker(int id);

    Appointment update(Appointment appointment);

    void batch();

    void delete(int id);


}
