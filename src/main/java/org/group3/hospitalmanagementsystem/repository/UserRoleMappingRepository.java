package org.group3.hospitalmanagementsystem.repository;

import org.group3.hospitalmanagementsystem.entities.Role;
import org.group3.hospitalmanagementsystem.entities.User;
import org.group3.hospitalmanagementsystem.entities.UserRoleMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface UserRoleMappingRepository extends JpaRepository<UserRoleMapping, Integer> {

    @Query("SELECT urm FROM UserRoleMapping urm WHERE urm.user = :user")
    Set<UserRoleMapping> findByUser(@Param("user") User user);

    @Query("SELECT urm.role FROM UserRoleMapping urm WHERE urm.user.userId = :userId")
    Set<Role> findRolesByUserId(@Param("userId") int userId);


}
