package com.serhat.transportdemo.service;

import com.serhat.transportdemo.payload.LoginDto;
import com.serhat.transportdemo.payload.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}