package com.assignment.assignment.service;

import com.assignment.assignment.domain.User;
import com.assignment.assignment.dto.request.LoginRequest;
import com.assignment.assignment.dto.response.LoginResponse;
import com.assignment.assignment.repo.UserRepo;
import com.assignment.assignment.security.MyUserDetailsService;
import com.assignment.assignment.util.JWTUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final MyUserDetailsService userDetailsService;
    private final JWTUtil jwtUtil;
    private final UserRepo userRepo;

    public AuthServiceImpl(AuthenticationManager authenticationManager,
                           MyUserDetailsService userDetailsService,
                           JWTUtil jwtUtil,
                           UserRepo userRepo) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
        this.userRepo = userRepo;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        // Authenticate user based on email and password
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword());

        // Authenticate using AuthenticationManager
        authenticationManager.authenticate(authenticationToken);

        // Set the authentication context if successful
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        // Generate JWT token after successful authentication
        String token = jwtUtil.generateToken(loginRequest.getEmail());

        // Return the JWT token in a LoginResponse
        return new LoginResponse(token);
    }


}
