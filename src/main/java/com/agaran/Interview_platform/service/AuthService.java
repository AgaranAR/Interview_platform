package com.agaran.Interview_platform.service;

import com.agaran.Interview_platform.dto.*;
import com.agaran.Interview_platform.entity.Role;
import com.agaran.Interview_platform.entity.User;
import com.agaran.Interview_platform.repository.RoleRepo;
import com.agaran.Interview_platform.repository.UserRepo;
import com.agaran.Interview_platform.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepo userRepository;
    private final RoleRepo roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public void register(RegisterRequest request){

        Role role = roleRepository.findByName("CANDIDATE")
                .orElseThrow();

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(role)
                .build();

        userRepository.save(user);
    }

    public AuthResponse login(LoginRequest request){

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        return new AuthResponse(token);
    }
}