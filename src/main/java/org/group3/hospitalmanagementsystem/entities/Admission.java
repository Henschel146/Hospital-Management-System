package org.group3.hospitalmanagementsystem.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Admission {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer admission_id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

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

    public void setAdmission_id(Integer admissionId) {
        this.admission_id = admissionId;
    }

    public Integer getAdmission_id() {
        return admission_id;
    }
}
