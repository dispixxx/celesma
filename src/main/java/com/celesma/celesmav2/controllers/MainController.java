package com.celesma.celesmav2.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")

public class MainController {
    @GetMapping
    public String showBoard() {
        return "home"; // Соответствует файлу dashboard.html в templates
    }

}
