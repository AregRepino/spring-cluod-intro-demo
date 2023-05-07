package com.example.auth;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {
    @RequestMapping("/")
    public String helloAdmin(HttpSession session) {
        return "hello";
    }

}

