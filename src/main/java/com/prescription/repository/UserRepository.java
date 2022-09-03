package com.prescription.repository;

import com.prescription.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * User repository class for JPA operation
 *
 * @author Abdullah Al Masum
 * @version 1.0
 * @since 05-06-2020
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
}
