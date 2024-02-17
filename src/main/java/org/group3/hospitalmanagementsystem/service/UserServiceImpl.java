package org.group3.hospitalmanagementsystem.service;

import org.group3.hospitalmanagementsystem.entities.Role;
import org.group3.hospitalmanagementsystem.entities.RoleGroup;
import org.group3.hospitalmanagementsystem.entities.User;
import org.group3.hospitalmanagementsystem.entities.UserRoleMapping;
import org.group3.hospitalmanagementsystem.repository.UserRepository;
import org.group3.hospitalmanagementsystem.repository.UserRoleMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService , UserDetailsService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    private UserRoleMappingRepository userRoleMappingRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserRoleMappingRepository userRoleMappingRepository) {
        this.userRepository = userRepository;
        this.userRoleMappingRepository = userRoleMappingRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public User update(User user) {
        User existingUser = userRepository.findByUserId(user.getUserId()).orElseThrow( () -> new NoSuchElementException("User with ID " + user.getUserId() + " not found"));
        existingUser.setModifiedDate(LocalDate.now());
        existingUser.setEmail(user.getEmail());
        existingUser.setFirstname(user.getFirstname());
        existingUser.setDateOfBirth(user.getDateOfBirth());
        existingUser.setPhoneNumber(user.getPhoneNumber());

        if (!existingUser.getPassword().equals(user.getPassword())) {
            existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        return userRepository.save(existingUser);
    }

    @Override
    public void batch() {

    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void delete(int id) {
        userRepository.deleteByUserId(id);
    }

    @Override
    public User findByEmail(String email) {
       return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findById(Integer id){
        return userRepository.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        Set<UserRoleMapping> userRoleMappings = userRoleMappingRepository.findByUser(user);

        Set<Role> roles = userRoleMappingRepository.findRolesByUserId(user.getUserId());

        Set<RoleGroup> roleGroups = userRoleMappings.stream()
                .map(UserRoleMapping::getUrRoleGroup)
                .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), getAuthorities(roles, roleGroups));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Set<Role> roles, Set<RoleGroup> roleGroups) {

        Set<GrantedAuthority> authorities = new HashSet<>();

        authorities.addAll(roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toSet()));

        authorities.addAll(roleGroups.stream()
                .map(roleGroup -> new SimpleGrantedAuthority("GROUP_" + roleGroup.getGroupName()))
                .collect(Collectors.toSet()));

        return authorities;
    }

}
