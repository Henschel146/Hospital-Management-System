package org.group3.hospitalmanagementsystem.controller;

import org.group3.hospitalmanagementsystem.entities.User;
import org.group3.hospitalmanagementsystem.model.SignIn;
import org.group3.hospitalmanagementsystem.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignInController {
    private UserService userService;

    public SignInController(UserService userService){this.userService = userService;}

    @GetMapping("/")
    public String showSignInForm(Model model) {
        model.addAttribute("signInModel", new SignIn());
        return "index";
    }

    @PostMapping("/sign-in")
    public String signInUser(@ModelAttribute("signInModel") SignIn signIn) {

        System.out.println("Email: " + signIn.getEmail());

        User user = userService.findByEmail(signIn.getEmail());

        System.out.println(user.getUserId());

        if( user.getEmail().equals(signIn.getEmail()) && user.getPassword().equals(signIn.getPassword())){
            return "redirect:/appointments";
        }
        return "redirect:/";
    }

}
