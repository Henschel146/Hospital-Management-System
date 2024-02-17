package org.group3.hospitalmanagementsystem.service;

import org.group3.hospitalmanagementsystem.entities.RoleGroup;

import java.util.Optional;

public interface RoleGroupService {

    Optional<RoleGroup> findByGroupName(String groupName);
}
