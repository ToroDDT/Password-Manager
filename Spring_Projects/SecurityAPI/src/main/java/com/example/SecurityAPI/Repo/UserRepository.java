package com.example.SecurityAPI.Repo;


import com.example.SecurityAPI.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
   User findByUsername(String username);
}
