package com.zosiasg.shop.controller;

import com.zosiasg.shop.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        if (authenticationService.login(username, password)) {
            return "redirect:/";
        } else {
            model.addAttribute("error", "Niepoprawne dane logowania!");
            return "login";
        }
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           Model model) {
        if (authenticationService.register(username, password)) {
            return "redirect:/login";
        } else {
            model.addAttribute("error", "Nazwa użytkownika jest już zajęta!");
            return "register";
        }
    }
}

