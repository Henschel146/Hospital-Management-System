package org.group3.hospitalmanagementsystem.controller;

import org.group3.hospitalmanagementsystem.entities.Admission;
import org.group3.hospitalmanagementsystem.entities.Appointment;
import org.group3.hospitalmanagementsystem.entities.Doctor;
import org.group3.hospitalmanagementsystem.entities.Patient;
import org.group3.hospitalmanagementsystem.model.AdmissionModel;
import org.group3.hospitalmanagementsystem.service.AdmissionService;
import org.group3.hospitalmanagementsystem.service.AppointmentService;
import org.group3.hospitalmanagementsystem.service.DoctorService;
import org.group3.hospitalmanagementsystem.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class AdmissionController {
    private AdmissionService admissionService;

    private PatientService patientService;

    private DoctorService doctorService;

    public AdmissionController(AdmissionService admissionService, PatientService patientService, DoctorService doctorService){
        this.admissionService = admissionService;
        this.patientService = patientService;
        this.doctorService = doctorService;
    }


    @GetMapping("/admissions")
    public String getAdmissions(Model model){
        List<Admission> all = admissionService.findAll();

        model.addAttribute("admissions",all );

        return "admission";
    }

    @GetMapping("/admission/add")
    public String add(Model model) {
        List<Doctor> doctors = doctorService.findAll();
        List<Patient> patients = patientService.findAll();

        model.addAttribute("admission", new Admission());
        model.addAttribute("doctors", doctors);
        model.addAttribute("patients", patients);

        return "admissionAdd";
    }

    @GetMapping("/admission/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Admission admission = admissionService.findByAdmissionId(id).orElseThrow( () -> new NoSuchElementException("Admission with ID " + id + " not found"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = admission.getAdmissionDate().format(formatter);
        admission.setAdmissionDateString(formattedDate);

        model.addAttribute("admission",admission);

        List<Doctor> doctors = doctorService.findAll();
        List<Patient> patients = patientService.findAll();

        model.addAttribute("doctors", doctors);
        model.addAttribute("patients", patients);

        return "admissionUpdate";
    }

    @GetMapping("/admission/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {
        Admission admission = admissionService.findByAdmissionId(id).orElseThrow( () -> new NoSuchElementException("Admission with ID " + id + " not found"));
        admissionService.delete(id);
        return "redirect:/admissions";
    }

    @PostMapping("/admission/add")
    public String addAdmission(@ModelAttribute("admission") Admission admission){
        admission.setCreatedDate(LocalDate.now());
        admission.setModifiedDate(LocalDate.now());
        Admission admissionCreated = admissionService.create(admission);
        return "redirect:/admissions";
    }

    @PostMapping("/admission/update")
    public String updateAdmission(@ModelAttribute("admission") Admission admission){
        admission.setModifiedDate(LocalDate.now());
        Admission admissionUpdated =  admissionService.update(admission);
        return "redirect:/admissions";
    }


}
