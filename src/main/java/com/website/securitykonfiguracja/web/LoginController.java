package com.website.securitykonfiguracja.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/logowanie")
    String login() {
        return "login-form";
    }
}
