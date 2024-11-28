package com.website.securitykonfiguracja.web;

import com.website.securitykonfiguracja.user.UserService;
import com.website.securitykonfiguracja.user.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    String registrationForm(Model model) {
        UserRegistrationDto user = new UserRegistrationDto();
        model.addAttribute("user", user);
        return "registration-form";
    }

    @PostMapping("/register")
    String register(UserRegistrationDto user) {
        userService.register(user);
        return "redirect:/confirmation";
    }

    @GetMapping("/confirmation")
    String confirmation() {
        return "registration-confirm";
    }
}
