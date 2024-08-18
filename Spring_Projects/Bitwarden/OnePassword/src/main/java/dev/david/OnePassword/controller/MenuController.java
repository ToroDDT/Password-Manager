package dev.david.OnePassword.controller;

import dev.david.OnePassword.form_data.PasswordFormData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Random;

@Controller
public class MenuController {
    @PostMapping("/tools/generator")
    public String displayGeneration(Model model, @RequestBody PasswordFormData passwordFormData) {

        return "generator";
    }
    @RequestMapping("/tools/generator")
    public String generatorTool(Model model) {
        model.addAttribute("generatedPassword", "HELOJOJDJF");
        return "generator";
    }

}
