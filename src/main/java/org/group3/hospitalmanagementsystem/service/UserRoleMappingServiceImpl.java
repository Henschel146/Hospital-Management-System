package org.group3.hospitalmanagementsystem.service;

import org.group3.hospitalmanagementsystem.entities.UserRoleMapping;
import org.group3.hospitalmanagementsystem.repository.UserRoleMappingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("userRoleService")
@Transactional
public class UserRoleMappingServiceImpl implements UserRoleMappingService {

    private UserRoleMappingRepository userRoleMappingRepository;

    public UserRoleMappingServiceImpl(UserRoleMappingRepository userRoleMappingRepository) {
        this.userRoleMappingRepository = userRoleMappingRepository;
    }

    @Override
    public List<UserRoleMapping> findAll() {
        return userRoleMappingRepository.findAll();
    }

    @Override
    public UserRoleMapping create(UserRoleMapping userRoleMapping) {
        return userRoleMappingRepository.save(userRoleMapping);
    }

    @Override
    public UserRoleMapping getUserRole(int id) {
        return null;
    }

    @Override
    public UserRoleMapping update(UserRoleMapping userRoleMapping) {
        return null;
    }

    @Override
    public void batch() {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Optional<UserRoleMapping> findById(Integer id) {
        return Optional.empty();
    }
}
