package org.group3.hospitalmanagementsystem.service;


import org.group3.hospitalmanagementsystem.entities.RoleGroup;
import org.group3.hospitalmanagementsystem.repository.RoleGroupRepository;
import org.group3.hospitalmanagementsystem.repository.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("roleGroupService")
@Transactional
public class RoleGroupServiceImpl implements RoleGroupService {

    private RoleGroupRepository roleGroupRepository;

    public RoleGroupServiceImpl(RoleGroupRepository roleGroupRepository) {
        this.roleGroupRepository = roleGroupRepository;
    }

    @Override
    public Optional<RoleGroup> findByGroupName(String groupName) {
        return roleGroupRepository.findByGroupName(groupName);
    }
}
