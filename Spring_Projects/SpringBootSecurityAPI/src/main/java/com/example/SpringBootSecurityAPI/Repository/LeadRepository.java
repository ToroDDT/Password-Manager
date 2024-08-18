package com.example.SpringBootSecurityAPI.Repository;

import com.example.SpringBootSecurityAPI.Entity.Lead;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeadRepository extends CrudRepository<Lead, Integer>, JpaRepository<Lead, Integer> {

        Optional<Lead> findByfirstName(String firstName);
}
