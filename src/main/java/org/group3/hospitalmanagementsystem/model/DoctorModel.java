package org.group3.hospitalmanagementsystem.model;

import org.group3.hospitalmanagementsystem.entities.User;

import java.time.LocalDate;

public class DoctorModel {
    private Integer doctorId;

    private String address;

    private boolean availabilityStatus;

    private Integer days_available;

    private String gender;

    private LocalDate createdDate;

    private LocalDate modifiedDate;

    private Integer userId;


    public DoctorModel() {
    }

    public DoctorModel(Integer doctorId, String address, boolean availabilityStatus, Integer days_available, String gender, LocalDate createdDate, LocalDate modifiedDate, Integer userId) {
        this.doctorId = doctorId;
        this.address = address;
        this.availabilityStatus = availabilityStatus;
        this.days_available = days_available;
        this.gender = gender;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.userId = userId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
