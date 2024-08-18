package com.example.SpringBootSecurityAPI.Repository;

import com.example.SpringBootSecurityAPI.Entity.User;
import com.example.SpringBootSecurityAPI.Entity.UserAccountDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<UserAccountDTO, Integer>,JpaRepository<UserAccountDTO, Integer> {
    void deleteByUsername(String username);

}
