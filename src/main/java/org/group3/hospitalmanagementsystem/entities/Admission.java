package org.group3.hospitalmanagementsystem.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Admission {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "admission_id")
    private Integer admissionId;

    @ManyToOne
    @JoinColumn(name = "adm_patient_id", referencedColumnName = "patient_id", insertable = false, updatable = false)
    private Patient patient;

    @Column(name = "adm_patient_id")
    private Integer admission_patient_id;

    @ManyToOne
    @JoinColumn(name = "adm_doctor_id", referencedColumnName = "doctor_id", insertable = false, updatable = false)
    private Doctor doctor;

    @Column(name = "adm_doctor_id")
    private Integer admission_doctor_id;

    private LocalDate admissionDate;

    private  Integer roomNumber;

    private Integer admissionStatus;

    private LocalDate dischargeDate;

    private String AdmissionReason;

    private LocalDate createdDate;

    private LocalDate modifiedDate;


    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getAdmissionStatus() {
        return admissionStatus;
    }

    public void setAdmissionStatus(Integer admissionStatus) {
        this.admissionStatus = admissionStatus;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getAdmissionReason() {
        return AdmissionReason;
    }

    public void setAdmissionReason(String admissionReason) {
        AdmissionReason = admissionReason;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Integer getAdmissionId() {
        return admissionId;
    }

    public void setAdmissionId(Integer admissionId) {
        this.admissionId = admissionId;
    }

    public Integer getAdmission_patient_id() {
        return admission_patient_id;
    }

    public void setAdmission_patient_id(Integer admission_patient_id) {
        this.admission_patient_id = admission_patient_id;
    }

    public Integer getAdmission_doctor_id() {
        return admission_doctor_id;
    }

    public void setAdmission_doctor_id(Integer admission_doctor_id) {
        this.admission_doctor_id = admission_doctor_id;
    }
}
