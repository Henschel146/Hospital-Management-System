package org.group3.hospitalmanagementsystem.repository;

import org.group3.hospitalmanagementsystem.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//28.01.2024 @karimberdiDekhkonov
//APPOINTMENT REPOSITORY INTERFACE
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    List<Appointment> findAll();
}
