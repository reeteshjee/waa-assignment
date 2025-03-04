package com.assignment.assignment.controller;

import com.assignment.assignment.dto.request.LoginRequest;
import com.assignment.assignment.dto.response.LoginResponse;
import com.assignment.assignment.security.MyUserDetailsService;
import com.assignment.assignment.util.JWTUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final MyUserDetailsService userDetailsService;
    private final JWTUtil jwtUtil;

    // Constructor injection
    public AuthController(AuthenticationManager authenticationManager,
                          MyUserDetailsService userDetailsService,
                          JWTUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        // Authenticate user based on email and password
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );

        // Set the authentication in the Security context if successful
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Generate JWT token
        String token = jwtUtil.generateToken(loginRequest.getEmail());

        // Return the generated JWT token in the response
        return ResponseEntity.ok(new LoginResponse(token));
    }


}
