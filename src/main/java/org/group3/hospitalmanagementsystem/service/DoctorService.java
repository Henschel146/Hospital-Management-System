package org.group3.hospitalmanagementsystem.service;

import org.group3.hospitalmanagementsystem.entities.Doctor;
import org.group3.hospitalmanagementsystem.entities.User;

import java.util.List;

public interface DoctorService {

    List<Doctor> findAll();

    User create(Doctor doctor);

    Doctor getDoctor(int id);

    Doctor update(Doctor doctor);

    void batch();

    void delete(int id);



}
