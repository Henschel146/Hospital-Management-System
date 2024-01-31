package org.group3.hospitalmanagementsystem.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

//28.01.2024 @karimberdiDekhkonov
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    private String firstname;

    private String lastName;

    private Integer phoneNumber;

    private String email;

    private String password;

    private LocalDate dateOfBirth;

    private LocalDate createdDate;

    private LocalDate modifiedDate;

    public User() {
    }

    public User(Integer userId, String firstname, String lastName, Integer phoneNumber, String email, String password, LocalDate dateOfBirth, LocalDate createdDate, LocalDate modifiedDate) {
        this.userId = userId;
        this.firstname = firstname;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }
}
