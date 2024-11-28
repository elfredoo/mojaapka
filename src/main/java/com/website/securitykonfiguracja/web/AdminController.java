package com.website.securitykonfiguracja.web;

import com.website.securitykonfiguracja.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    String adminPanel(Model model){
        boolean isAdmin = userService.isCurrentUserAdmin();
        if (isAdmin){
            List<String> userEmails = userService.findAllUserEmails();
            model.addAttribute("userEmails", userEmails);
            return "admin";
        }else{
            return "error";
        }
    }

    @GetMapping("/delete-user")
    String deleteUser(@RequestParam String email){
        userService.deleteUserByEmail(email);
        return "redirect:/admin";
    }
}
