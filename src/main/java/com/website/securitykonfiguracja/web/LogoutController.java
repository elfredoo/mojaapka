package com.website.securitykonfiguracja.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    @GetMapping("/loggedOut")
    public String loggedOut() {
        return "index";
    }
}
