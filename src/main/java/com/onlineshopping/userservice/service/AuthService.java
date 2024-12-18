package com.onlineshopping.userservice.service;

import com.onlineshopping.userservice.entity.UserInfo;
import com.onlineshopping.userservice.repository.UserInfoRepository;
import com.onlineshopping.userservice.dto.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthService {


    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private ProductService service;
    @Autowired
    private com.onlineshopping.userservice.service.JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;


    public String saveUser(UserInfo userInfo) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "User added successfully!";
    }

    public String authenticate(AuthRequest authRequest) {
        UsernamePasswordAuthenticationToken authentication1 = new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(authentication1);
        String roles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername(),roles);
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }

    public String validToken(String token) {
        jwtService.validateToken(token);
        return " Valid Token";
    }
}
