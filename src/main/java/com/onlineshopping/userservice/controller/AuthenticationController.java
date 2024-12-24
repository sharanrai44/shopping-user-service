package com.onlineshopping.userservice.controller;

import com.onlineshopping.userservice.dto.ApiResponse;
import com.onlineshopping.userservice.dto.AuthRequest;
import com.onlineshopping.userservice.dto.UserDTO;
import com.onlineshopping.userservice.entity.UserInfo;
import com.onlineshopping.userservice.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    public static final String SUCCESS = "SUCCESS";
    public static final String ERROR = "ERROR";

    private Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<String>> addNewUser(@RequestBody UserDTO userDTO) {
        String traceId = MDC.get("traceId");
        logger.info("addNewUser method is called");
        String response = authService.saveUser(userDTO);
        ApiResponse<String> apiResponse = new ApiResponse<>(SUCCESS, response, null, traceId);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<ApiResponse<String>> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        String traceId = MDC.get("traceId");
        String token = authService.authenticate(authRequest);

        ApiResponse<String> apiResponse = new ApiResponse<>(SUCCESS, token, null, traceId);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/validate")
    public ResponseEntity<ApiResponse<String>> getToken(@RequestParam String token) {
        String traceId = MDC.get("traceId");
        String message = authService.validToken(token);
        ApiResponse<String> apiResponse = new ApiResponse<>(SUCCESS, message, null, traceId);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


}
