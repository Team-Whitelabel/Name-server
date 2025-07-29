package com.example.loginapp.controller;

import com.example.loginapp.entity.User;
import com.example.loginapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String blank() {
        return "redirect:/register";
    }

    // 회원가입 폼
    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    // 회원가입 처리
    @PostMapping("/register")
    public String register(User user) {
        userService.register(user);
        return "redirect:/login";
    }

    // 로그인 폼
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    // 로그인 처리
    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        Model model) {
        Optional<User> loginUser = userService.login(email, password);

        if (loginUser.isPresent()) {
            model.addAttribute("email", email);
            return "welcome";
        } else {
            model.addAttribute("error", "잘못된 이메일 또는 비밀번호입니다.");
            return "login";
        }
    }
}
