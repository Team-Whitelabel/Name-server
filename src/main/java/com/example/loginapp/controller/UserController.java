package com.example.loginapp.controller;

import com.example.loginapp.entity.User;
import com.example.loginapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        userService.register(user);
        return ResponseEntity.ok("회원가입 성공");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginData) {
        Optional<User> user = userService.login(loginData.getEmail(), loginData.getPassword());
        if (user.isPresent()) {
            return ResponseEntity.ok("로그인 성공");
        }
        return ResponseEntity.status(401).body("잘못된 이메일 또는 비밀번호입니다.");
    }
}
