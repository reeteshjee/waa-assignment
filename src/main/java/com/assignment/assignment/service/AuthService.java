package com.assignment.assignment.service;

import com.assignment.assignment.dto.request.LoginRequest;
import com.assignment.assignment.dto.response.LoginResponse;

public interface AuthService {

    LoginResponse login(LoginRequest loginRequest);

}
