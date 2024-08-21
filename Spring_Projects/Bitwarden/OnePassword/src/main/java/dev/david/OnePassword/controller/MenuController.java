package dev.david.OnePassword.controller;

import dev.david.OnePassword.form_data.PasswordFormData;
import dev.david.OnePassword.passwordGenerator.PasswordGenTool;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
public class MenuController {
    @PostMapping("/tools/generator")
    public String displayGeneration(@ModelAttribute PasswordFormData passwordFormData, Model model) {
        PasswordGenTool newPassword = new PasswordGenTool();
        newPassword.generateRandomPassword(passwordFormData);
        model.addAttribute("newPassword", newPassword.getPassword());
        return "generator";
    }
    @GetMapping("/tools/generator")
    public String generatorTool(Model model) {
        model.addAttribute("passwordFormData", new PasswordFormData());
        return "generator";
    }

}
