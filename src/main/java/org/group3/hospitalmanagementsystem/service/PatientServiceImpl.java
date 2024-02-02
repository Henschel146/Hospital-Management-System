package org.group3.hospitalmanagementsystem.service;

import org.group3.hospitalmanagementsystem.entities.Patient;
import org.group3.hospitalmanagementsystem.entities.User;
import org.group3.hospitalmanagementsystem.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service("patientService")
@Transactional
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient create(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient getPatient(int id) {
        return null;
    }

    @Override
    public Patient update(Patient patient) {
        Patient existingPatient = patientRepository.findByPatientId(patient.getPatientId()).orElseThrow( () -> new NoSuchElementException("Patient with ID " + patient.getPatientId() + " not found"));
        existingPatient.setModifiedDate(LocalDate.now());
        existingPatient.setEmail(patient.getEmail());
        existingPatient.setFirstname(patient.getFirstname());
        existingPatient.setDateOfBirth(patient.getDateOfBirth());
        existingPatient.setPhoneNumber(patient.getPhoneNumber());
        existingPatient.setDiagnosis(patient.getDiagnosis());
        existingPatient.setAddress(patient.getAddress());
        existingPatient.setPhoneNumber(patient.getPhoneNumber());
        return patientRepository.save(existingPatient);

    }

    @Override
    public void batch() {

    }

    @Override
    public void delete(int id) {
        patientRepository.deleteByPatientId(id);
    }

    @Override
    public Optional<Patient> findById(Integer id) {
        return patientRepository.findById(id);
    }
}
