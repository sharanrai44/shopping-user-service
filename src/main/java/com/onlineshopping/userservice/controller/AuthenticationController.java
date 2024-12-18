package com.onlineshopping.userservice.controller;

import com.onlineshopping.userservice.dto.AuthRequest;
import com.onlineshopping.userservice.entity.UserInfo;
import com.onlineshopping.userservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserInfo userInfo) {
        return authService.saveUser(userInfo);
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        return authService.authenticate(authRequest);
    }

    @GetMapping("/validate")
    public String getToken(@RequestParam String token) {
        return authService.validToken(token);
    }


}
