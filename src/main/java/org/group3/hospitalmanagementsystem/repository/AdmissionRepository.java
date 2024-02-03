package org.group3.hospitalmanagementsystem.repository;

import org.group3.hospitalmanagementsystem.entities.Admission;
import org.group3.hospitalmanagementsystem.entities.Doctor;
import org.group3.hospitalmanagementsystem.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdmissionRepository extends JpaRepository<Admission,Integer> {


    Optional<Admission> findByAdmissionId(Integer id);

    void deleteByAdmissionId(Integer id);


}
