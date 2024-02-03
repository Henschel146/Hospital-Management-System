package org.group3.hospitalmanagementsystem.service;

import org.group3.hospitalmanagementsystem.entities.Appointment;
import org.group3.hospitalmanagementsystem.repository.AppointmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service("appointmentService")
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }
    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment create(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment getAppointment(int id) {
        return null;
    }

    @Override
    public Appointment update(Appointment appointment) {
        Appointment existingAppointment = appointmentRepository.findByAppointmentId(appointment.getAppointmentId()).orElseThrow( () -> new NoSuchElementException("Appointment with ID " + appointment.getAppointmentId() + " not found"));
        existingAppointment.setModifiedDate(LocalDate.now());
        existingAppointment.setAppointment_doctor_id(appointment.getAppointment_doctor_id());
        existingAppointment.setAppointment_patient_id(appointment.getAppointment_patient_id());
        existingAppointment.setEndTime(appointment.getEndTime());
        existingAppointment.setStartTime(appointment.getStartTime());
        existingAppointment.setNotes(appointment.getNotes());
        existingAppointment.setRoomNumber(appointment.getRoomNumber());
        return appointmentRepository.save(existingAppointment);

    }

    @Override
    public void batch() {

    }

    @Override
    public void delete(int id) {
        appointmentRepository.deleteByAppointmentId(id);
    }

    @Override
    public Optional<Appointment> findByAppointmentId(Integer id) {
        return appointmentRepository.findById(id);
    }



}
