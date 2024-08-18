package com.example.SpringBootSecurityAPI.SecurityConfig;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginRequestDTO {

    @NotNull(message = "UserName is required")
    @Size(min = 1, message ="UserName is required")
    private String username;

    @NotNull(message = "Password is required.")
    @Size(min = 6, message = "Password should be at least 6 characters.")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
