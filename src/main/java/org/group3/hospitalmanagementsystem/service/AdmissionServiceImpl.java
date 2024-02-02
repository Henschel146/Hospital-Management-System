package org.group3.hospitalmanagementsystem.service;

import org.group3.hospitalmanagementsystem.entities.Admission;
import org.group3.hospitalmanagementsystem.entities.Doctor;
import org.group3.hospitalmanagementsystem.entities.Patient;
import org.group3.hospitalmanagementsystem.model.AdmissionModel;
import org.group3.hospitalmanagementsystem.repository.AdmissionRepository;
import org.group3.hospitalmanagementsystem.repository.DoctorRepository;
import org.group3.hospitalmanagementsystem.repository.PatientRepository;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service("admissionService")
public class AdmissionServiceImpl implements AdmissionService {

    private AdmissionRepository admissionRepository;
    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;

    public AdmissionServiceImpl(AdmissionRepository admissionRepository){
        this.admissionRepository = admissionRepository;
    }
    @Override
    public List<Admission> findAll() {
        return admissionRepository.findAll();
    }

    @Override
    public Admission create(AdmissionModel admissionModel) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(admissionModel.getDoctorId());
        if (optionalDoctor.isEmpty()) return new Admission();
        Optional<Patient> optionalPatient = patientRepository.findById(admissionModel.getPatientId());
        if (optionalPatient.isEmpty()) return new Admission();

        Admission admission = new Admission();
        admission.setAdmissionDate(admissionModel.getAdmissionDate());
        admission.setAdmissionReason(admissionModel.getAdmissionReason());
        admission.setAdmissionStatus(admissionModel.getAdmissionStatus());
        admission.setDischargeDate(admissionModel.getDischargeDate());
        admission.setRoomNumber(admissionModel.getRoomNumber());
        admission.setCreatedDate(LocalDate.now());
        admission.setModifiedDate(LocalDate.now());
        admission.setDoctor(optionalDoctor.get());
        admission.setPatient(optionalPatient.get());
        admissionRepository.save(admission);

        return admission;
    }

    @Override
    public Admission getAdmission(int id) {
        return null;
    }

    @Override
    public Admission update(Admission admission) {
        return null;
    }

    @Override
    public void batch() {

    }

    @Override
    public void delete(int id) {

    }
}
