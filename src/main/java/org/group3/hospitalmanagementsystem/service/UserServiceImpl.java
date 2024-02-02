package org.group3.hospitalmanagementsystem.service;

import org.group3.hospitalmanagementsystem.entities.User;
import org.group3.hospitalmanagementsystem.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(User user) {
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
        existingUser.setPassword(user.getPassword());

        return userRepository.save(existingUser);
    }

    @Override
    public void batch() {

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
}
