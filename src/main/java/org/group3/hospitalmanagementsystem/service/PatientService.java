package org.group3.hospitalmanagementsystem.service;

import org.group3.hospitalmanagementsystem.entities.Patient;
import org.group3.hospitalmanagementsystem.entities.User;

import java.util.List;
import java.util.Optional;

public interface PatientService {


    List<Patient> findAll();

    Patient create(Patient patient);

    Patient getPatient(int id);

    Patient update(Patient patient);

    void batch();

    void delete(int id);



    Optional<Patient> findById(Integer id);
}
