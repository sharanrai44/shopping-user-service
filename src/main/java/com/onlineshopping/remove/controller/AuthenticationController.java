//package com.onlineshopping.userservice2.controller;
//
//import com.onlineshopping.userservice.service.AuthService;
//import com.onlineshopping.userservice2.util.AuthRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/auth")
//public class AuthenticationController {
//
//    @Autowired
//    private AuthService authService;
//
////    @PostMapping("/register")
////    public String addNewUser(@RequestBody UserCredential userCredential) {
////        return authService.saveUser(userCredential);
////    }
//
//    @PostMapping("/token")
//    public String getToken(@RequestBody AuthRequest request) {
//        return authService.authenticate(request);
//    }
//    @PostMapping("/validate")
//    public String getToken(@RequestParam String token) {
//        return authService.validToken(token);
//    }
//
//
//}
