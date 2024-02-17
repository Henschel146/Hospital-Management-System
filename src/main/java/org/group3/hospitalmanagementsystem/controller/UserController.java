package org.group3.hospitalmanagementsystem.controller;

import org.group3.hospitalmanagementsystem.entities.Role;
import org.group3.hospitalmanagementsystem.entities.RoleGroup;
import org.group3.hospitalmanagementsystem.entities.User;
import org.group3.hospitalmanagementsystem.entities.UserRoleMapping;
import org.group3.hospitalmanagementsystem.service.RoleGroupService;
import org.group3.hospitalmanagementsystem.service.RoleService;
import org.group3.hospitalmanagementsystem.service.UserRoleMappingService;
import org.group3.hospitalmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import static org.group3.hospitalmanagementsystem.Utils.DateUtil.calculateAge;

@Controller
public class UserController {

    private UserService userService;

    private UserRoleMappingService userRoleMappingService;

    private RoleService roleService;

    private RoleGroupService roleGroupService;

    @Autowired
    public UserController(UserService userService, RoleService roleService, UserRoleMappingService userRoleMappingService, RoleGroupService roleGroupService){
        this.userService = userService;
        this.roleService = roleService;
        this.userRoleMappingService = userRoleMappingService;
        this.roleGroupService = roleGroupService;
    }


    @GetMapping("/user")
    public String getUsers(Model model) {

        List<User> users = new ArrayList<>();
        users = userService.findAll();

        users.forEach( user -> user.setAge(calculateAge(user.getDateOfBirth())));

        model.addAttribute("users",users );
        return "users";
    }
    @GetMapping("/user/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        List<Role> roles = roleService.findAll();
        model.addAttribute("roles",roles);
        return "userAdd";
    }

    @GetMapping("/user/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        User user = userService.findById(id).orElseThrow( () -> new NoSuchElementException("User with ID " + id + " not found"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = user.getDateOfBirth().format(formatter);
        user.setDateOfBirthString(formattedDate);
        model.addAttribute("user",user);
        List<Role> roles = roleService.findAll();
        model.addAttribute("roles",roles);
        return "userUpdate";
    }

    @GetMapping("/user/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {
        User user = userService.findById(id).orElseThrow( () -> new NoSuchElementException("User with ID " + id + " not found"));
        userService.delete(id);
        return "redirect:/user";
    }

    @PostMapping("/users/add")
    public String addNewUser(@ModelAttribute("user") User user, @RequestParam("selectedRoles") Set<Integer> selectedRoleIds){
        user.setCreatedDate(LocalDate.now());
        user.setModifiedDate(LocalDate.now());
        User createdUser =  userService.create(user);
        Integer userId = createdUser.getUserId();

        List<UserRoleMapping> userRoleMappings = selectedRoleIds.stream()
                .map(roleId -> {
                    Role role = roleService.findById(roleId).orElse(null);
                    UserRoleMapping userRoleMapping = new UserRoleMapping(userId, roleId);

                    // Check if the role corresponds to "RECEPTIONIST" or "Doctor"
                    if (role != null && ("ADMIN".equals(role.getName()) || "DOCTOR".equals(role.getName()))) {
                        // Set the role group to "Management"
                        RoleGroup managementRoleGroup = roleGroupService.findByGroupName("MANAGEMENT").orElseThrow( () -> new NoSuchElementException("RoleGroup with Name  Management  not found"));
                        userRoleMapping.setUrRoleGroup(managementRoleGroup);
                    }else{
                        RoleGroup managementRoleGroup = roleGroupService.findByGroupName("GENERAL").orElseThrow( () -> new NoSuchElementException("RoleGroup with Name  Management  not found"));
                        userRoleMapping.setUrRoleGroup(managementRoleGroup);
                    }

                    return userRoleMapping;
                })
                .collect(Collectors.toList());

        userRoleMappings.forEach(userRoleMapping -> userRoleMappingService.create(userRoleMapping));
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
