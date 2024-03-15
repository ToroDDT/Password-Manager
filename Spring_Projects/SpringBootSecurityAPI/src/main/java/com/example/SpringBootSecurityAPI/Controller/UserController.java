package com.example.SpringBootSecurityAPI.Controller;

import com.example.SpringBootSecurityAPI.Entity.User;
import com.example.SpringBootSecurityAPI.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/account")
public class UserController {
    @Autowired
    AccountRepository accountRepo;
    @PostMapping("/create")
    public void createUser(@RequestParam String username, @RequestParam String password, @RequestParam String email, @RequestParam String security_question_1, @RequestParam String security_answer_1, @RequestParam String security_question_2, @RequestParam String security_answer_2, @RequestParam String security_question_3, @RequestParam String security_answer_3) {
        User user = new User(username,password, email, security_question_1, security_answer_1, security_question_2, security_answer_2, security_question_3, security_answer_3);
        accountRepo.save(user);
    }

    @
}
