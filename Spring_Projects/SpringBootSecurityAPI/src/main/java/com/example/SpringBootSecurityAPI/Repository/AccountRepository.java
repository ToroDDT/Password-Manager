package com.example.SpringBootSecurityAPI.Repository;

import com.example.SpringBootSecurityAPI.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<User, Integer> {

}
