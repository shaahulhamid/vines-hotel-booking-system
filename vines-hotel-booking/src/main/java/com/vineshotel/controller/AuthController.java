package com.vineshotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    // ✅ Customer Login Page
    @GetMapping("/login")
    public String customerLogin() {
        return "login"; // templates/login.html
    }

    // ✅ Admin Login Page
    @GetMapping("/admin/login")
    public String adminLogin() {
        return "admin-login"; // templates/admin-login.html
    }
}
