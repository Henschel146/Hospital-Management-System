package org.group3.hospitalmanagementsystem.service;

import org.group3.hospitalmanagementsystem.entities.User;
import org.group3.hospitalmanagementsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
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
        return null;
    }

    @Override
    public void batch() {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public User findByEmail(String email) {
       return userRepository.findByEmail(email);
    }
}
