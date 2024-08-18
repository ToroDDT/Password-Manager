package com.example.SpringBootSecurityAPI.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String status;
    private String firstName;
    private String lastName;
    private String birthday;
    private String postalCode;
    private String mobilePhone;
    private String objectives;
    private String referredBy;
    private String notes;
}
