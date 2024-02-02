package org.group3.hospitalmanagementsystem.service;

import org.group3.hospitalmanagementsystem.entities.Doctor;
import org.group3.hospitalmanagementsystem.entities.User;
import org.group3.hospitalmanagementsystem.model.DoctorModel;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    List<Doctor> findAll();

    Doctor create(Doctor doctor);

    Doctor getDoctor(int id);

    Doctor update(Doctor doctor);

    void batch();

    void delete(int id);

    Optional<Doctor> findById(Integer id);



}
