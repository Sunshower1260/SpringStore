package com.example.SpringStore.features.authentication.register;

import com.example.SpringStore.core.exception.AppException;
import com.example.SpringStore.core.exception.ErrorCode;
import com.example.SpringStore.core.shared.model.User;
import com.example.SpringStore.features.authentication.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    private final UserRepository userRepository;

    public RegisterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public RegisterResponse execute(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        // Mô phỏng mã hóa mật khẩu đơn giản
        String dummyHashedPassword = "sha256_" + request.getPassword();

        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(dummyHashedPassword)
                .fullName(request.getFullName())
                .build();

        User savedUser = userRepository.save(user);

        return RegisterResponse.builder()
                .id(savedUser.getId())
                .username(savedUser.getUsername())
                .email(savedUser.getEmail())
                .fullName(savedUser.getFullName())
                .createdAt(savedUser.getCreatedAt())
                .build();
    }
}
