package org.group3.hospitalmanagementsystem.controller;

import org.group3.hospitalmanagementsystem.entities.Doctor;
import org.group3.hospitalmanagementsystem.entities.User;
import org.group3.hospitalmanagementsystem.model.DoctorModel;
import org.group3.hospitalmanagementsystem.service.DoctorService;
import org.group3.hospitalmanagementsystem.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class DoctorController {

    private DoctorService doctorService;
    private UserService userService;

    public DoctorController(DoctorService doctorService, UserService userService){
        this.doctorService = doctorService;
        this.userService = userService;
    }

    @GetMapping("/doctors")
    public String getDoctors(Model model){
        List<Doctor> all = doctorService.findAll();
        model.addAttribute("doctors", all);
        return "doctors";
    }

    @GetMapping("/doctor/add")
    public String add(Model model) {
        model.addAttribute("doctor", new Doctor());
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "doctorAdd";
    }

    @GetMapping("/doctor/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Doctor doctor = doctorService.findById(id).orElseThrow( () -> new NoSuchElementException("User with ID " + id + " not found"));
        model.addAttribute("doctor",doctor);
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "doctorUpdate";
    }

    @GetMapping("/doctor/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {
        Doctor doctor = doctorService.findById(id).orElseThrow( () -> new NoSuchElementException("User with ID " + id + " not found"));
        doctorService.delete(id);
        return "redirect:/doctors";
    }



    @PostMapping("/doctor/add")
    public Object addDoctor(@ModelAttribute("doctor") Doctor doctor){
        doctor.setCreatedDate(LocalDate.now());
        doctor.setModifiedDate(LocalDate.now());
        Doctor createdDoctor = doctorService.create(doctor);
        return "redirect:/doctors";
    }

    @PostMapping("/doctor/update")
    public String updateDoctor(@ModelAttribute("doctor") Doctor doctor){
        doctor.setModifiedDate(LocalDate.now());
        Doctor updatedDoctor =  doctorService.update(doctor);
        System.out.println("User Created");
        return "redirect:/user";
    }
}
