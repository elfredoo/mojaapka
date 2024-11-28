package com.website.securitykonfiguracja.web;

import com.website.securitykonfiguracja.message.WelcomeMessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecuredController {
    private final WelcomeMessageService welcomeMessageService;

    public SecuredController(WelcomeMessageService welcomeMessageService) {
        this.welcomeMessageService = welcomeMessageService;
    }

    @GetMapping("/secured")
    String home(@RequestParam(defaultValue = "en") String lang, Model model) {
        String welcomeMessage = welcomeMessageService.getWelcomeMessage(lang);
        model.addAttribute("lang",lang);
        model.addAttribute("welcomeMessage", welcomeMessage);
        return "secured";
    }
}
