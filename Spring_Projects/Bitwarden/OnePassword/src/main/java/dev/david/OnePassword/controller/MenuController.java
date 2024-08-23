package dev.david.OnePassword.controller;

import dev.david.OnePassword.form_data.PasswordFormData;
import dev.david.OnePassword.form_data.PassPhraseFormData;
import dev.david.OnePassword.passwordGenerator.PasswordGenTool;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
public class MenuController {
    @PostMapping("/tools/generator")
    public String displayGeneration(@ModelAttribute PasswordFormData passwordFormData, Model model) {
        if( passwordFormData.getLength() < 5 ) {
            model.addAttribute("lengthNeeded", "please provide the desired length of password that is above 5");
            return "generator";
        }
        if (!passwordFormData.getZeroToNine() && !passwordFormData.getA_z() && !passwordFormData.getCapital_A_Z() && !passwordFormData.getSpecialCharacters()) {
            model.addAttribute("selectOption", "Please select at least one of the options");
        } else {
            PasswordGenTool newPassword = new PasswordGenTool();
            newPassword.generateRandomPassword(passwordFormData);
            model.addAttribute("newPassword", newPassword.getPassword());
        }
        return "generator";
    }
    @GetMapping("/tools/generator/password")
    public String generatorTool(Model model) {
        model.addAttribute("passwordFormData", new PasswordFormData());
        return "generator-password";
    }

    @GetMapping("/tools/generator/pass-phrase")
    public String showGeneratorPassPhrase(Model model) {
        model.addAttribute("passPhraseFormData", new PassPhraseFormData());
        return "generator-passphrase";
    }
}
