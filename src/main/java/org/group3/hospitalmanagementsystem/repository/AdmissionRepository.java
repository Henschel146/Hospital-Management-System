package org.group3.hospitalmanagementsystem.repository;

import org.group3.hospitalmanagementsystem.entities.Admission;
import org.group3.hospitalmanagementsystem.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdmissionRepository extends JpaRepository<Admission,Integer> {


    List<Admission> findByPatient(Patient patient);


}
