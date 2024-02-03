package org.group3.hospitalmanagementsystem.service;

import org.group3.hospitalmanagementsystem.entities.Admission;
import org.group3.hospitalmanagementsystem.repository.AdmissionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service("admissionService")
@Transactional
public class AdmissionServiceImpl implements AdmissionService {

    private AdmissionRepository admissionRepository;

    public AdmissionServiceImpl(AdmissionRepository admissionRepository){
        this.admissionRepository = admissionRepository;
    }
    @Override
    public List<Admission> findAll() {
        return admissionRepository.findAll();
    }

//    @Override
//    public Admission create(AdmissionModel admissionModel) {
//        Optional<Doctor> optionalDoctor = doctorRepository.findById(admissionModel.getDoctorId());
//        if (optionalDoctor.isEmpty()) return new Admission();
//        Optional<Patient> optionalPatient = patientRepository.findById(admissionModel.getPatientId());
//        if (optionalPatient.isEmpty()) return new Admission();
//
//        Admission admission = new Admission();
//        admission.setAdmissionDate(admissionModel.getAdmissionDate());
//        admission.setAdmissionReason(admissionModel.getAdmissionReason());
//        admission.setAdmissionStatus(admissionModel.getAdmissionStatus());
//        admission.setDischargeDate(admissionModel.getDischargeDate());
//        admission.setRoomNumber(admissionModel.getRoomNumber());
//        admission.setCreatedDate(LocalDate.now());
//        admission.setModifiedDate(LocalDate.now());
//        admission.setDoctor(optionalDoctor.get());
//        admission.setPatient(optionalPatient.get());
//        admissionRepository.save(admission);
//
//        return admission;
//    }

    @Override
    public Admission create(Admission admission){
        admission.setAdmissionStatus(1);
        return admissionRepository.save(admission);
    }
    @Override
    public Admission getAdmission(int id) {
        return null;
    }

    @Override
    public Admission update(Admission admission) {
        Admission existingAdmission = admissionRepository.findByAdmissionId(admission.getAdmissionId()).orElseThrow( () -> new NoSuchElementException("Admission with ID " + admission.getAdmissionId() + " not found"));
        existingAdmission.setModifiedDate(LocalDate.now());
        existingAdmission.setAdmission_doctor_id(admission.getAdmission_doctor_id());
        existingAdmission.setAdmissionDate(admission.getAdmissionDate());
        existingAdmission.setAdmissionReason(admission.getAdmissionReason());
        existingAdmission.setDischargeDate(admission.getDischargeDate());
        existingAdmission.setRoomNumber(admission.getRoomNumber());
        return admissionRepository.save(existingAdmission);


    }

    @Override
    public void batch() {

    }

    @Override
    public void delete(int id) {
        admissionRepository.deleteByAdmissionId(id);
    }

    @Override
    public Optional<Admission> findByAdmissionId(Integer id) {
        return admissionRepository.findByAdmissionId(id);
    }

}
