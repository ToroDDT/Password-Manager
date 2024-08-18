package com.example.SpringBootSecurityAPI.Controller;

import com.example.SpringBootSecurityAPI.Entity.Lead;
import com.example.SpringBootSecurityAPI.Entity.User;
import com.example.SpringBootSecurityAPI.Repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class LeadsController {

    @Autowired
    LeadRepository leadRepository;
    @GetMapping("/")
    public String helloWOrld() {
        return "hello World";
    }

    @GetMapping("/get/lead")
    public ResponseEntity<Lead> getLead(@PathVariable String name) {
        Lead lead = leadRepository.findByfirstName(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Name was not found in database"));
        return ResponseEntity.ok(lead);
    }
    @GetMapping("/user")
    public Object getObject() {
        Map<String, Object> object = new HashMap<>();
        object.put("name", "David");
        object.put("id", 3);
        return object;
    }
    @PostMapping("/add/lead")
    public ResponseEntity<String> addLead(@RequestBody Lead newLead) {
        String message = "";
        int statusCode = 200;
       try {
           leadRepository.save(newLead);
       } catch (DataAccessException error){
           System.out.println(error.getCause().getMessage());
           message = error.getCause().getMessage();
           statusCode = 401;

       }
       return new ResponseEntity<>(message, HttpStatusCode.valueOf(statusCode));
    }
    @PatchMapping("/update/lead{id}")
    public ResponseEntity<Optional<Lead>> updateAccount(@PathVariable Integer id, @RequestBody Map<String, Object> fields) {
        Optional<Lead> lead = Optional.ofNullable(leadRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "lead was not found with ID")));
        if (lead.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(User.class, key);
                assert field != null;
                field.setAccessible(true);
                ReflectionUtils.setField(field, lead.get(), value);
            });
            leadRepository.save(lead.get());
        }
        return ResponseEntity.ok(lead);
    }

}
