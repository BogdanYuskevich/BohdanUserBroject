package com.bogdan.uskevych.repository;

import com.bogdan.uskevych.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
