package com.example.SpringBootSecurityAPI.SecurityConfig;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

public class LoginFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
       String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean error = true;
        String userNameError;
        String passwordError;
        if (username.isEmpty()) {
            userNameError = "Require username";
            error = false;
        }
        if (password.isEmpty()) {
            passwordError = "Require password";
            error = false;
        }
        if(error){
            chain.doFilter(request, response);
        }
    }
}
