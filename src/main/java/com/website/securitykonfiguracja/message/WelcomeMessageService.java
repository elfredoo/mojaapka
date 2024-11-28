package com.website.securitykonfiguracja.message;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class WelcomeMessageService {
    private static final String LANG_EN = "en";
    private static final String LANG_ES = "es";
    private static final String LANG_PL = "pl";

    public String getWelcomeMessage(String lang){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        String welcomeMessage = switch (lang){
            case LANG_PL -> "Cześć ";
            case LANG_ES -> "HOLLA ";
            default -> "Hello ";
        };
        return welcomeMessage + username;
    }
}
