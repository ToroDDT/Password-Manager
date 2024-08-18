package com.example.SpringBootSecurityAPI.Controller;

import com.example.SpringBootSecurityAPI.Entity.User;
import com.example.SpringBootSecurityAPI.Entity.UserAccountDTO;
import com.example.SpringBootSecurityAPI.Repository.AccountRepository;
import com.example.SpringBootSecurityAPI.SecurityConfig.LoginRequestDTO;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
    @Autowired
    AccountRepository accountRepo;

    @PostMapping("/create/account")
    public ResponseEntity<UserAccountDTO> createAccount(@RequestBody @Valid UserAccountDTO userAccount) {
        accountRepo.save(userAccount);
        return null;
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam String username) {
            accountRepo.deleteByUsername(username);
    }

    @PatchMapping("/update/account{id}")
    public User updateAccount(@PathVariable Integer id, @RequestBody Map<String, Object> fields) {
        Optional<User> userAccount = accountRepo.findById(id);
        if (userAccount.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(User.class, key);
                assert field != null;
                field.setAccessible(true);
                ReflectionUtils.setField(field, userAccount.get(), value);
            });
            return accountRepo.save(userAccount.get());
        }
        return null;
    }

}
