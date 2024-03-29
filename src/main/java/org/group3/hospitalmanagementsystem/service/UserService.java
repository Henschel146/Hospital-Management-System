package org.group3.hospitalmanagementsystem.service;

import org.group3.hospitalmanagementsystem.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    User create(User user);

    User getUser(int id);

    User update(User user);

    void batch();

    void delete(int id);

    User findByEmail(String email);


    Optional<User> findById(Integer id);
}
