package com.qpassessment.qpgrocery.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qpassessment.qpgrocery.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

}
