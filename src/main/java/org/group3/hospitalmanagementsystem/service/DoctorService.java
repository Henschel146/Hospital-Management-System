package org.group3.hospitalmanagementsystem.service;

import org.group3.hospitalmanagementsystem.entities.Doctor;
import org.group3.hospitalmanagementsystem.entities.User;
import org.group3.hospitalmanagementsystem.model.DoctorModel;

import java.util.List;

public interface DoctorService {

    List<Doctor> findAll();

    Doctor create(DoctorModel doctor);

    Doctor getDoctor(int id);

    Doctor update(Doctor doctor);

    void batch();

    void delete(int id);



}
