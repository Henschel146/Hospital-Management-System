package org.group3.hospitalmanagementsystem.controller;

import org.group3.hospitalmanagementsystem.entities.Doctor;
import org.group3.hospitalmanagementsystem.model.DoctorModel;
import org.group3.hospitalmanagementsystem.service.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class DoctorController {

    private DoctorService doctorService;

    @GetMapping("/getDoctors")
    public List<Doctor> getDoctors(){
        List<Doctor> all = doctorService.findAll();
        return all;
    }

    @PostMapping("/addDoctor")
    public Object addDoctor(@RequestBody DoctorModel model){
        Doctor doctor = doctorService.create(model);
        return doctor;
    }
}
