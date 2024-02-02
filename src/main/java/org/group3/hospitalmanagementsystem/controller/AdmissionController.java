package org.group3.hospitalmanagementsystem.controller;

import org.group3.hospitalmanagementsystem.entities.Admission;
import org.group3.hospitalmanagementsystem.model.AdmissionModel;
import org.group3.hospitalmanagementsystem.service.AdmissionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class AdmissionController {
    private AdmissionService admissionService;

    @GetMapping("/getAdmissions")
    public List<Admission> getAdmissions(){
        List<Admission> all = admissionService.findAll();
        return all;
    }

    @PostMapping("/addAdmission")
    public Object addAdmission(@RequestBody AdmissionModel admissionModel){
        Admission admission = admissionService.create(admissionModel);
        return admission;
    }
}
