package com.example.SpringStore.features.authentication.login;

import com.example.SpringStore.core.exception.AppException;
import com.example.SpringStore.core.exception.ErrorCode;
import com.example.SpringStore.core.shared.model.User;
import com.example.SpringStore.core.shared.security.JwtService;
import com.example.SpringStore.features.authentication.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public LoginService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public LoginResponse execute(LoginRequest request) {
        String account = request.getUsernameOrEmail();
        
        // Tìm kiếm người dùng theo username hoặc email
        User user = userRepository.findByUsername(account)
                .orElseGet(() -> userRepository.findByEmail(account)
                        .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND)));

        // So khớp mật khẩu thực tế bằng BCrypt
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new AppException(ErrorCode.INVALID_PASSWORD);
        }

        // Sinh JWT Token thật
        String realToken = jwtService.generateToken(user);

        return LoginResponse.builder()
                .token(realToken)
                .username(user.getUsername())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .build();
    }
}
