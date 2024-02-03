package org.group3.hospitalmanagementsystem.service;

import org.group3.hospitalmanagementsystem.entities.Admission;
import java.util.List;
import java.util.Optional;

public interface AdmissionService {

    List<Admission> findAll();

    Admission create(Admission admission);

    Admission getAdmission(int id);

    Admission update(Admission admission);

    void batch();

    void delete(int id);

    Optional<Admission> findByAdmissionId(Integer id);


}
