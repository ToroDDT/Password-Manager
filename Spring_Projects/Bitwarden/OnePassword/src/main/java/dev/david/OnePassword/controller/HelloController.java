package dev.david.OnePassword.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {
    @RequestMapping("/hello-world")
    public String sayHi(Model model) {
        model.addAttribute("message", "Hell World!");
        return "menu";
    }
}
