package org.group3.hospitalmanagementsystem.controller;

import org.group3.hospitalmanagementsystem.entities.User;
import org.group3.hospitalmanagementsystem.service.UserService;
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

    @GetMapping("/user/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        User user = userService.findById(id).orElseThrow( () -> new NoSuchElementException("User with ID " + id + " not found"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = user.getDateOfBirth().format(formatter);
        user.setDateOfBirthString(formattedDate);

        model.addAttribute("user",user);
        return "userUpdate";
    }

    @GetMapping("/user/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {
        User user = userService.findById(id).orElseThrow( () -> new NoSuchElementException("User with ID " + id + " not found"));
        userService.delete(id);
        return "redirect:/user";
    }

    @PostMapping("/users/add")
    public String addNewUser(@ModelAttribute("user") User user){
        user.setCreatedDate(LocalDate.now());
        user.setModifiedDate(LocalDate.now());
        User createdUser =  userService.create(user);

        return "redirect:/user";
    }

    @PostMapping("/users/update")
    public String updateUser(@ModelAttribute("user") User user){
        user.setModifiedDate(LocalDate.now());


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfBirth = LocalDate.parse(user.getDateOfBirthString(), formatter);
        user.setDateOfBirth(dateOfBirth);

        User updatedUser =  userService.update(user);
        return "redirect:/user";
    }

}
