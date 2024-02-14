package org.group3.hospitalmanagementsystem.service;

import org.group3.hospitalmanagementsystem.entities.Role;
import org.group3.hospitalmanagementsystem.repository.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService{

    private RoleRepository roleRepository;


    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }



    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role create(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getRole(int id) {
        return null;
    }

    @Override
    public Role update(Role role) {
        return null;
    }

    @Override
    public void batch() {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Optional<Role> findById(Integer id) {
        return Optional.empty();
    }
}
