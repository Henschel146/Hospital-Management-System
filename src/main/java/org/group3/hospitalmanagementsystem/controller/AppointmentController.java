package org.group3.hospitalmanagementsystem.controller;


import org.group3.hospitalmanagementsystem.entities.Appointment;
import org.group3.hospitalmanagementsystem.entities.Doctor;
import org.group3.hospitalmanagementsystem.entities.Patient;
import org.group3.hospitalmanagementsystem.entities.User;
import org.group3.hospitalmanagementsystem.service.AppointmentService;
import org.group3.hospitalmanagementsystem.service.DoctorService;
import org.group3.hospitalmanagementsystem.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class AppointmentController {

    private AppointmentService appointmentService;

    private PatientService patientService;

    private DoctorService doctorService;


    public AppointmentController(AppointmentService appointmentService, PatientService patientService, DoctorService doctorService){
        this.appointmentService = appointmentService;
        this.patientService = patientService;
        this.doctorService = doctorService;
    }


    @GetMapping("/appointments")
    public String showAppointments(Model model) {

        List<Appointment> appointments = appointmentService.findAll();

        model.addAttribute("appointments",appointments );

        System.out.println("Rendering appointment");
        return "appointment";
    }

    @GetMapping("/appointment/add")
    public String add(Model model) {
        List<Doctor> doctors = doctorService.findAll();
        List<Patient> patients = patientService.findAll();

        model.addAttribute("appointment", new Appointment());
        model.addAttribute("doctors", doctors);
        model.addAttribute("patients", patients);

        return "appointmentAdd";
    }

    @GetMapping("/appointment/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Appointment appointment = appointmentService.findByAppointmentId(id).orElseThrow( () -> new NoSuchElementException("Appointment with ID " + id + " not found"));
        model.addAttribute("appointment",appointment);

        List<Doctor> doctors = doctorService.findAll();
        List<Patient> patients = patientService.findAll();

        model.addAttribute("doctors", doctors);
        model.addAttribute("patients", patients);

        return "appointmentUpdate";
    }

    @GetMapping("/appointment/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {
        Appointment appointment = appointmentService.findByAppointmentId(id).orElseThrow( () -> new NoSuchElementException("Appointment with ID " + id + " not found"));
        appointmentService.delete(id);
        return "redirect:/appointments";
    }



    @PostMapping("/appointment/add")
    public Object addDoctor(@ModelAttribute("appointment") Appointment appointment){
        appointment.setCreatedDate(LocalDate.now());
        appointment.setModifiedDate(LocalDate.now());
        Appointment appointmentCreated = appointmentService.create(appointment);
        return "redirect:/appointments";
    }

    @PostMapping("/appointment/update")
    public String updateDoctor(@ModelAttribute("appointment") Appointment appointment){
        appointment.setModifiedDate(LocalDate.now());
        Appointment appointmentUpdated =  appointmentService.update(appointment);
        System.out.println("Appointment Created");
        return "redirect:/appointments";
    }


}
