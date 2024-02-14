package org.group3.hospitalmanagementsystem.repository;

import org.group3.hospitalmanagementsystem.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByRoleId(Integer id);

}
