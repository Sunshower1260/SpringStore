package com.example.SpringStore.features.authentication.login;

import com.example.SpringStore.core.shared.dto.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(@RequestBody @Valid LoginRequest request) {
        LoginResponse response = loginService.execute(request);
        ApiResponse<LoginResponse> apiResponse = ApiResponse.<LoginResponse>builder()
                .message("Đăng nhập thành công")
                .data(response)
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
