package org.group3.hospitalmanagementsystem.service;

import org.group3.hospitalmanagementsystem.entities.UserRoleMapping;

import java.util.List;
import java.util.Optional;

public interface UserRoleMappingService {


    List<UserRoleMapping> findAll();

    UserRoleMapping create(UserRoleMapping userRoleMapping);

    UserRoleMapping getUserRole(int id);

    UserRoleMapping update(UserRoleMapping userRoleMapping);

    void batch();

    void delete(int id);




    Optional<UserRoleMapping> findById(Integer id);
}
