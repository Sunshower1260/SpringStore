package com.example.SpringStore.features.authentication.profile;

import com.example.SpringStore.core.exception.AppException;
import com.example.SpringStore.core.exception.ErrorCode;
import com.example.SpringStore.core.shared.dto.ApiResponse;
import com.example.SpringStore.core.shared.model.User;
import com.example.SpringStore.features.authentication.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class ProfileController {

    private final UserRepository userRepository;

    public ProfileController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/profile")
    public ResponseEntity<ApiResponse<ProfileResponse>> getProfile(@AuthenticationPrincipal String username) {
        if (username == null) {
            throw new AppException(ErrorCode.UNAUTHENTICATED);
        }

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        ProfileResponse response = ProfileResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .createdAt(user.getCreatedAt())
                .build();

        ApiResponse<ProfileResponse> apiResponse = ApiResponse.<ProfileResponse>builder()
                .message("Lấy thông tin cá nhân thành công")
                .data(response)
                .build();

        return ResponseEntity.ok(apiResponse);
    }
}
