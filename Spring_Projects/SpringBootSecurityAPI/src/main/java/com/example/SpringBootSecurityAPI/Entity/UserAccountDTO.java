package com.example.SpringBootSecurityAPI.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashMap;

@Entity
@Table(name = "userAccounts")
public class UserAccountDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull(message = "Username is required.")
    @Size(min = 6, message = "Password should be at least 6 characters.")
    private String username;

    @NotNull(message = "Password is required.")
    @Size(min = 6, message = "Password should be at least 6 characters.")
    private String password;
    @NotNull(message = "Email is required.")
    @Size(min = 1, message = "Email is required.")
    @Email(message = "Email is not well formatted.")
    private String email;
    @NotNull
    private String role;
    @NotNull
    private String security_question_1;
    @NotNull
    private String security_question_2;
    @NotNull
    private String security_question_3;
    public UserAccountDTO(String username, String password, String email, String role, String security_question_1, String security_question_2, String security_question_3) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.security_question_1 = security_question_1;
        this.security_question_2 = security_question_2;
        this.security_question_3 = security_question_3;
    }

}
