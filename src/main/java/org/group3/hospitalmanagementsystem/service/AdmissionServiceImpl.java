package org.group3.hospitalmanagementsystem.service;

import org.group3.hospitalmanagementsystem.entities.Admission;
import org.group3.hospitalmanagementsystem.entities.User;
import org.group3.hospitalmanagementsystem.repository.AdmissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("admissionService")
public class AdmissionServiceImpl implements AdmissionService {

    private AdmissionRepository admissionRepository;

    public AdmissionServiceImpl(AdmissionRepository admissionRepository){
        this.admissionRepository = admissionRepository;
    }
    @Override
    public List<Admission> findAll() {
        return admissionRepository.findAll();
    }

    @Override
    public User create(Admission admission) {
        return null;
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
