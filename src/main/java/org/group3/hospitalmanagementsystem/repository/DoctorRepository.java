package org.group3.hospitalmanagementsystem.repository;

import org.group3.hospitalmanagementsystem.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//28.01.2024 @Henschel Lungu
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    Optional<Doctor> findByDoctorId(Integer id);

    void deleteByDoctorId(Integer id);
}
