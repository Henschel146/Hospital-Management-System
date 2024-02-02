package org.group3.hospitalmanagementsystem.service;

import org.group3.hospitalmanagementsystem.entities.Admission;
import org.group3.hospitalmanagementsystem.entities.Doctor;
import org.group3.hospitalmanagementsystem.entities.User;

import java.util.List;

public interface AdmissionService {

    List<Admission> findAll();

    User create(Admission admission);

    Admission getAdmission(int id);

    Admission update(Admission admission);

    void batch();

    void delete(int id);


}
