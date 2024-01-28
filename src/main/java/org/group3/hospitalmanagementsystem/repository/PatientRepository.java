package org.group3.hospitalmanagementsystem.repository;

import org.group3.hospitalmanagementsystem.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//28.01.2024 @Henschel Lungu
public interface PatientRepository extends JpaRepository <Patient,Integer> {

    List<Patient> findAll();
    List<Patient> findByPatientId(Integer id);

}
