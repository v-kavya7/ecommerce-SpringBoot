package com.example.E_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.E_commerce.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}

