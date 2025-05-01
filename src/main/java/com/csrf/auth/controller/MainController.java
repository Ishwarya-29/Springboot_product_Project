package com.csrf.auth.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/message")
    public String showMessage(HttpServletRequest res)
    {
        return "Welcome to this app."+res.getSession().getId();
    }
    @GetMapping("/")
    public String homePage(HttpServletRequest res)
    {
        return "This is my home page"+res.getSession().getId();
    }
    @GetMapping("/about")
    public String about(HttpServletRequest res)
    {
        return "This is my about page."+res.getSession().getId();
    }
    @GetMapping("/public/demo")
    public String publicFunction()
    {
        return "This is public page";
    }

}
