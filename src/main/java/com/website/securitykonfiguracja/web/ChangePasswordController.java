package com.website.securitykonfiguracja.web;

import com.website.securitykonfiguracja.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ChangePasswordController {
    private final UserService userService;

    public ChangePasswordController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/change-password")
    public String changePassword(@RequestParam String newPassword, RedirectAttributes redirectAttributes){
        userService.changeCurrentUserPassword(newPassword);
        return "redirect:/logout";
    }
}
