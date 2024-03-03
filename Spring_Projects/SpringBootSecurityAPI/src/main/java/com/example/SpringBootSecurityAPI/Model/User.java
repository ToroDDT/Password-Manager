package com.example.SpringBootSecurityAPI.Model;

import jakarta.persistence.*;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;


}

