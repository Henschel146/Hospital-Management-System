package org.group3.hospitalmanagementsystem.service;

import org.group3.hospitalmanagementsystem.entities.Role;
import org.group3.hospitalmanagementsystem.entities.User;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    List<Role> findAll();

    Role create(Role role);

    Role getRole(int id);

    Role update(Role role);

    void batch();

    void delete(int id);

    Optional<Role> findById(Integer id);
}
