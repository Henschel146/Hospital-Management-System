package org.group3.hospitalmanagementsystem.controller;

import org.group3.hospitalmanagementsystem.entities.Patient;
import org.group3.hospitalmanagementsystem.entities.User;
import org.group3.hospitalmanagementsystem.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.group3.hospitalmanagementsystem.Utils.DateUtil.calculateAge;

@Controller
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService){this.patientService = patientService;}

    @GetMapping("/patients")
    public String getPatients(Model model) {

        List<Patient> patients = new ArrayList<>();
        patients = patientService.findAll();

        patients.forEach( patient -> patient.setAge(calculateAge(patient.getDateOfBirth())));

        model.addAttribute("patients",patients );
        return "patients";
    }
    @GetMapping("/patient/add")
    public String add(Model model) {
        model.addAttribute("patient", new Patient());
        return "patientAdd";
    }

    @GetMapping("/patient/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Patient patient = patientService.findById(id).orElseThrow( () -> new NoSuchElementException("Patient with ID " + id + " not found"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = patient.getDateOfBirth().format(formatter);
        patient.setDateOfBirthString(formattedDate);

        model.addAttribute("patient",patient);
        return "patientUpdate";
    }

    @GetMapping("/patient/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {
        Patient patient = patientService.findById(id).orElseThrow( () -> new NoSuchElementException("Patient with ID " + id + " not found"));
        patientService.delete(id);
        return "redirect:/patients";
    }

    @PostMapping("/patient/add")
    public String addNewUser(@ModelAttribute("patient") Patient patient){
        patient.setCreatedDate(LocalDate.now());
        patient.setModifiedDate(LocalDate.now());
        Patient createdPatient =  patientService.create(patient);
        return "redirect:/patients";
    }

    @PostMapping("/patient/update")
    public String updateUser(@ModelAttribute("patient") Patient patient){
        patient.setModifiedDate(LocalDate.now());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfBirth = LocalDate.parse(patient.getDateOfBirthString(), formatter);
        patient.setDateOfBirth(dateOfBirth);

        Patient updatedPatient =  patientService.update(patient);
        return "redirect:/patients";
    }

}
