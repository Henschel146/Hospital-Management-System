package org.group3.hospitalmanagementsystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;

    private String firstname;

    private String lastName;

    private String address;

    private LocalDate dateOfBirth;

    private Integer phoneNumber;

    private String email;

    private String diagnosis;

    private String createdDate;

    private String modifiedDate;

    public Patient() {
    }

    public Patient(Integer patientId, String firstname, String lastName, String address, LocalDate dateOfBirth, Integer phoneNumber, String email, String diagnosis, String createdDate, String modifiedDate) {
        this.patientId = patientId;
        this.firstname = firstname;
        this.lastName = lastName;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.diagnosis = diagnosis;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getPatientId() {
        return patientId;
    }
}
