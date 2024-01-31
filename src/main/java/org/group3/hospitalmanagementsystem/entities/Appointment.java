package org.group3.hospitalmanagementsystem.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

//28.01.2024 @karimberdiDekhkonov
//APPOINTMENT ENTITY CLASS
@Entity
public class Appointment {
    //AUTO ID GENERATING WITH INTEGER
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "appointment_id")
    private Integer appointmentId;

    //START DATE AND TIME OF APPOINTMENT
    private LocalDateTime startTime;

    //END DATE AND TIME OF APPOINTMENT
    private LocalDateTime endTime;

    //ASSIGNED ROOM NUMBER FOR THE APPOINTMENT
    private int roomNumber;

    //EXTRA NOTES FOR THE APPOINTMENT
    private String notes;

    //CREATED DAY OF THE APPOINTMENT
    private LocalDate createdDate;

    //MODIFIED DAY OF THE APPOINTMENT
    private LocalDate modifiedDate;

    //PATIENT ID FOR THE APPOINTMENT
    //ONE PATIENT CAN CREATE MULTIPLE APPOINTMENT AND EACH APPOINTMENT SIGNED TO ONE PATIENT ONLY.
    @ManyToOne
    @JoinColumn(name = "app_patient_id", referencedColumnName = "patient_id")
    private Patient patient;

    //DOCTOR ID FOR THE APPOINTMENT
    //ONE DOCTOR CAN CREATE MULTIPLE APPOINTMENT AND EACH APPOINTMENT SIGNED TO ONE DOCTOR ONLY.
    @ManyToOne
    @JoinColumn(name = "app_doctor_id", referencedColumnName = "doctor_id")
    private Doctor doctor;

    //ENCAPSULATION

    public Appointment() {
    }

    public Appointment(Integer appointmentId, LocalDateTime startTime, LocalDateTime endTime, int roomNumber, String notes, LocalDate createdDate, LocalDate modifiedDate, Patient patient, Doctor doctor) {
        this.appointmentId = appointmentId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.roomNumber = roomNumber;
        this.notes = notes;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.patient = patient;
        this.doctor = doctor;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }
}
