package com.example.SpringBootSecurityAPI.Controller;

import com.example.SpringBootSecurityAPI.Entity.User;
import com.example.SpringBootSecurityAPI.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
    @Autowired
    AccountRepository accountRepo;
    @PostMapping("/create")
    public void createUser(@RequestParam String username, @RequestParam String password, @RequestParam String email, @RequestParam String role, @RequestParam String security_question_1, @RequestParam String security_answer_1, @RequestParam String security_question_2, @RequestParam String security_answer_2, @RequestParam String security_question_3, @RequestParam String security_answer_3) {
        User user = new User(username,password, email, role, security_question_1, security_answer_1, security_question_2, security_answer_2, security_question_3, security_answer_3);
        accountRepo.save(user);
        System.out.println(user);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam String username) {
            accountRepo.deleteByUserName(username);
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
