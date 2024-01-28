package org.group3.hospitalmanagementsystem.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctorId;


    private String firstname;

    private String lastname;

    private String address;

    private LocalDate dateOfBirth;

    private Integer phoneNumber;

    private String email;

    private boolean availabityStatus;

    private Integer days_available;

    private String gender;

    private LocalDate createdDate;

    private LocalDate modifiedDate;

    @OneToMany(mappedBy = "appointmentId")
    private List<Appointment> appointmentList;


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public boolean isAvailabityStatus() {
        return availabityStatus;
    }

    public void setAvailabityStatus(boolean availabityStatus) {
        this.availabityStatus = availabityStatus;
    }

    public Integer getDays_available() {
        return days_available;
    }

    public void setDays_available(Integer days_available) {
        this.days_available = days_available;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public void setDoctorId(Integer id) {
        this.doctorId = id;
    }

    public Integer getDoctorId() {
        return doctorId;
    }
}
