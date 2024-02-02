package org.group3.hospitalmanagementsystem.service;

import org.group3.hospitalmanagementsystem.entities.Admission;
import org.group3.hospitalmanagementsystem.model.AdmissionModel;

import java.util.List;

public interface AdmissionService {

    List<Admission> findAll();

    Admission create(AdmissionModel admission);

    Admission getAdmission(int id);

    Admission update(Admission admission);

    void batch();

    void delete(int id);


}
