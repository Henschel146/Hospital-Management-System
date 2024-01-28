package org.group3.hospitalmanagementsystem.repository;

import org.group3.hospitalmanagementsystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

//28.01.2024 @karimberdiDekhkonov
public interface UserRepository extends JpaRepository<User, Integer> {
}
