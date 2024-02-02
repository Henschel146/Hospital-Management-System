package org.group3.hospitalmanagementsystem.model;

import jakarta.persistence.*;
import org.group3.hospitalmanagementsystem.entities.Doctor;
import org.group3.hospitalmanagementsystem.entities.Patient;

import java.time.LocalDate;

public class AdmissionModel {

    private Integer admissionId;

    private Integer patientId;

    private Integer doctorId;

    private LocalDate admissionDate;

    private  Integer roomNumber;

    private Integer admissionStatus;

    private LocalDate dischargeDate;

    private String AdmissionReason;

    private LocalDate createdDate;

    private LocalDate modifiedDate;

    public AdmissionModel() {
    }

    public AdmissionModel(Integer admissionId, Integer patientId, Integer doctorId, LocalDate admissionDate, Integer roomNumber, Integer admissionStatus, LocalDate dischargeDate, String admissionReason, LocalDate createdDate, LocalDate modifiedDate) {
        this.admissionId = admissionId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.admissionDate = admissionDate;
        this.roomNumber = roomNumber;
        this.admissionStatus = admissionStatus;
        this.dischargeDate = dischargeDate;
        AdmissionReason = admissionReason;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public Integer getAdmissionId() {
        return admissionId;
    }

    public void setAdmissionId(Integer admissionId) {
        this.admissionId = admissionId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
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
}
