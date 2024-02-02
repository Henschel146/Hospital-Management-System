package org.group3.hospitalmanagementsystem.service;

import org.group3.hospitalmanagementsystem.entities.Doctor;
import org.group3.hospitalmanagementsystem.entities.User;
import org.group3.hospitalmanagementsystem.model.DoctorModel;
import org.group3.hospitalmanagementsystem.repository.DoctorRepository;
import org.group3.hospitalmanagementsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service("doctorService")
public class DoctorServiceImpl implements DoctorService {

    private DoctorRepository doctorRepository;
    private UserRepository userRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }


    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor create(DoctorModel doctorModel) {
        Optional<User> optional = userRepository.findById(doctorModel.getUserId());
        if (optional.isEmpty()) return new Doctor();
        Doctor doctor = new Doctor();
        doctor.setCreatedDate(LocalDate.now());
        doctor.setModifiedDate(LocalDate.now());
        doctor.setAvailabilityStatus(doctorModel.isAvailabilityStatus());
        doctor.setAddress(doctorModel.getAddress());
        doctor.setGender(doctorModel.getGender());
        doctor.setDays_available(doctorModel.getDays_available());
        doctor.setUser(optional.get());
        doctorRepository.save(doctor);
        return doctor;
    }

    @Override
    public Doctor getDoctor(int id) {
        return null;
    }

    @Override
    public Doctor update(Doctor doctor) {
        return null;
    }

    @Override
    public void batch() {

    }

    @Override
    public void delete(int id) {

    }


}
