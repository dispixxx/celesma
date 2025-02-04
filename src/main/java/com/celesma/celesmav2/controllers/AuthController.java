package com.celesma.celesmav2.controllers;

import com.celesma.celesmav2.models.User;
import com.celesma.celesmav2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register"; // Ссылается на register.html
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        if (userService.isUserExists(user.getEmail())) {
            model.addAttribute("error", "Пользователь с таким email уже существует!");
            return "register";
        }

        userService.saveUser(user);
        return "redirect:/auth/login"; // Перенаправление на страницу входа
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login"; // Ссылается на login.html
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user, Model model) {
        if (userService.authenticate(user.getEmail(), user.getPassword())) {
            return "redirect:/dashboard"; // Перенаправление на главную страницу после входа
        }
        model.addAttribute("error", "Неверные учетные данные!");
        return "login";
    }
}
