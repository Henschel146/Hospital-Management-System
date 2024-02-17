package org.group3.hospitalmanagementsystem.repository;

import org.group3.hospitalmanagementsystem.entities.Role;
import org.group3.hospitalmanagementsystem.entities.RoleGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleGroupRepository extends JpaRepository<RoleGroup, Integer> {

    Optional<RoleGroup> findByGroupName(String groupName);
}
