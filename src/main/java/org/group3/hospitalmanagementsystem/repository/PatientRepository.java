package org.group3.hospitalmanagementsystem.repository;

import org.group3.hospitalmanagementsystem.entities.Patient;
import org.group3.hospitalmanagementsystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//28.01.2024 @Henschel Lungu
public interface PatientRepository extends JpaRepository <Patient,Integer> {

    Optional<Patient> findByPatientId(Integer id);

    void deleteByPatientId(Integer id);

}
