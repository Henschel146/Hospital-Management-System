package org.group3.hospitalmanagementsystem.controller;

import org.group3.hospitalmanagementsystem.entities.Appointment;
import org.group3.hospitalmanagementsystem.entities.User;
import org.group3.hospitalmanagementsystem.model.SignIn;
import org.group3.hospitalmanagementsystem.service.AppointmentService;
import org.group3.hospitalmanagementsystem.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService){this.userService = userService;}


    @GetMapping("/user")
    public String getUsers(Model model) {

        List<User> users = new ArrayList<>();
        users = userService.findAll();
        model.addAttribute("users",users );


        return "users";
    }
    @GetMapping("/user/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "userAdd";
    }

    @PostMapping("/users/addorUpdate")
    public String addOrUpdate(@ModelAttribute("user") User user){
        user.setCreatedDate(LocalDate.now());
        user.setModifiedDate(LocalDate.now());
        User createdUser =  userService.create(user);
        System.out.println("User Created");
        return "users";
    }


}
