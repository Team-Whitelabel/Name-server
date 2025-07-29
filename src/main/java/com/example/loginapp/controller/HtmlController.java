package com.example.loginapp.controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.InputStream;
import java.net.URL;

@Controller
public class HtmlController {

    @GetMapping("/")
    public ResponseEntity<?> getSignUpHtml() {
        try {
            String fileUrl = "https://raw.githubusercontent.com/Team-Whitelabel/Name/main/signUp.html";
            InputStream inputStream = new URL(fileUrl).openStream();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.TEXT_HTML);
            return new ResponseEntity<>(new InputStreamResource(inputStream), headers, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("signUp.html을 불러오는 중 오류 발생: " + e.getMessage());
        }
    }

    @GetMapping("/login")
    public ResponseEntity<?> getSignInHtml() {
        try {
            String fileUrl = "https://raw.githubusercontent.com/Team-Whitelabel/Name/main/signIn.html";
            InputStream inputStream = new URL(fileUrl).openStream();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.TEXT_HTML);
            return new ResponseEntity<>(new InputStreamResource(inputStream), headers, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("signIn.html을 불러오는 중 오류 발생: " + e.getMessage());
        }
    }

}
