package com.celesma.celesmav2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
    @GetMapping
    public String showBoard() {
        return "dashboard"; // Соответствует файлу dashboard.html в templates
    }
}
