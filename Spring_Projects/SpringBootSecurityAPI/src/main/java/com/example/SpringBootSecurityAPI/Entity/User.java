package com.example.SpringBootSecurityAPI.Entity;

import com.example.SpringBootSecurityAPI.Models.SecurityQuestions;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;

@Entity
@Table(name = "AccountAuthenticationInformation")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String role;


    @JdbcTypeCode(SqlTypes.JSON)
    private SecurityQuestions questions;

    public User(String username, String password, String email, String role, String question1, String answer1, String question2, String answer2, String question3, String answer3 ) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.questions = new SecurityQuestions(question1, answer1, question2, answer2, question3, answer3);
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public SecurityQuestions getQuestions() {
        return questions;
    }
    public void setQuestions(SecurityQuestions questions) {
        this.questions = questions;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
