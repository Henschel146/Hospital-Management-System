package org.group3.hospitalmanagementsystem.repository;

import org.group3.hospitalmanagementsystem.entities.Appointment;
import org.group3.hospitalmanagementsystem.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//28.01.2024 @karimberdiDekhkonov
//APPOINTMENT REPOSITORY INTERFACE
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    Optional<Appointment> findByAppointmentId(Integer id);

    void deleteByAppointmentId(Integer id);
}
