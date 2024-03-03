package com.example.GymAPI.Repos;

import com.example.GymAPI.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

public interface UserRepository extends CrudRepository<User, Integer> {
}
