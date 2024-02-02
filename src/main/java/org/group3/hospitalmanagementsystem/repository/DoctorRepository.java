package org.group3.hospitalmanagementsystem.repository;

import org.group3.hospitalmanagementsystem.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//28.01.2024 @Henschel Lungu
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    List<Doctor> findByDoctorId(Integer id);
}
