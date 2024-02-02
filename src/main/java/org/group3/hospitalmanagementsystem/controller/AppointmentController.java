package org.group3.hospitalmanagementsystem.controller;


import org.group3.hospitalmanagementsystem.entities.Appointment;
import org.group3.hospitalmanagementsystem.model.SignIn;
import org.group3.hospitalmanagementsystem.service.AppointmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppointmentController {

    private AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService){this.appointmentService = appointmentService;}


    @GetMapping("/appointment")
    public String showSignInForm(Model model) {

        List<Appointment> appointments = new ArrayList<>();
        appointments = appointmentService.findAll();
        model.addAttribute("appointments",appointments );

        System.out.println("Rendering appointment");
        return "appointment";
    }
}
