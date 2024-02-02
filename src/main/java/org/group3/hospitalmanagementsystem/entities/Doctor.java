package org.group3.hospitalmanagementsystem.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

//28.01.2024 @Henschel Lungu
//Doctor ENTITY CLASS
@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Integer doctorId;

    private String address;

    private boolean availabilityStatus;

    private Integer days_available;

    private String gender;

    private LocalDate createdDate;

    private LocalDate modifiedDate;

    @OneToOne
    @JoinColumn(name = "doc_user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private User user;

    @Column(name = "doc_user_id")
    private Integer user_id;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean getAvailabilityStatus() {
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

    public void setDoctorId(Integer id) {
        this.doctorId = id;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
