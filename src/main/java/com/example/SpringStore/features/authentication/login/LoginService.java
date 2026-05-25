package com.example.SpringStore.features.authentication.login;

import com.example.SpringStore.core.exception.AppException;
import com.example.SpringStore.core.exception.ErrorCode;
import com.example.SpringStore.core.shared.model.User;
import com.example.SpringStore.features.authentication.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LoginResponse execute(LoginRequest request) {
        String account = request.getUsernameOrEmail();
        
        // Tìm kiếm người dùng theo username hoặc email
        User user = userRepository.findByUsername(account)
                .orElseGet(() -> userRepository.findByEmail(account)
                        .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND)));

        // So khớp mật khẩu đã được mã hóa giả lập lúc đăng ký
        String expectedHashedPassword = "sha256_" + request.getPassword();
        if (!user.getPassword().equals(expectedHashedPassword)) {
            throw new AppException(ErrorCode.INVALID_PASSWORD);
        }

        // Tạo JWT Token giả lập cho client sử dụng
        String dummyToken = "jwt_session_token_for_" + user.getUsername() + "_" + System.currentTimeMillis();

        return LoginResponse.builder()
                .token(dummyToken)
                .username(user.getUsername())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .build();
    }
}
