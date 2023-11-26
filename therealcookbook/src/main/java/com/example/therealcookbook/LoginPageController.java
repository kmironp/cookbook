package com.example.therealcookbook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginPageController {

    @GetMapping("/")
    public String LoginPage()
    {
        return "index.html";
    }
}
