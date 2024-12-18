//package com.onlineshopping.userservice2.service;
//
//import com.onlineshopping.userservice.model.UserCredential;
//import com.onlineshopping.userservice.repository.UserCredentialRepository;
//import com.onlineshopping.userservice.security.CustomAuthenticationProvider;
//import com.onlineshopping.userservice.security.JwtService;
//import com.onlineshopping.userservice.util.AuthRequest;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuthService {
//
//    private final CustomAuthenticationProvider authenticationManager;
//
//    private final UserCredentialRepository repository;
//
//    private final JwtService jwtService;
//
//    public AuthService(CustomAuthenticationProvider authenticationManager, UserCredentialRepository repository,
//                       JwtService jwtService) {
//        this.authenticationManager = authenticationManager;
//        this.repository = repository;
//        this.jwtService = jwtService;
//    }
//
//    public String saveUser(UserCredential credential) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
//        repository.save(credential);
//        return "User added successfully!";
//    }
//
//    public String getToken(AuthRequest authRequest) {
//        Authentication authenticate = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(authRequest.getUsername()
//                        , authRequest.getPassword()));
//        if (authenticate.isAuthenticated()) {
//            return jwtService.generateToken(authRequest.getUsername());
//        } else {
//            throw new UsernameNotFoundException("Invalid user access !!");
//        }
//    }
//
//    public String validToken(String token) {
//        jwtService.validateToken(token);
//        return " Valid Token";
//    }
//}
