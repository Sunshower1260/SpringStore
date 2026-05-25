package com.example.SpringStore.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public enum ErrorCode {
    SUCCESS(1000, "Thành công", HttpStatus.OK),
    UNCATEGORIZED_EXCEPTION(9999, "Lỗi không xác định từ hệ thống", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_KEY(8888, "Key thông báo lỗi không hợp lệ", HttpStatus.BAD_REQUEST),
    USER_EXISTED(1001, "Người dùng đã tồn tại trên hệ thống", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(1002, "Không tìm thấy người dùng", HttpStatus.NOT_FOUND),
    INVALID_PASSWORD(1003, "Mật khẩu không chính xác", HttpStatus.BAD_REQUEST),
    UNAUTHENTICATED(1004, "Yêu cầu không được xác thực", HttpStatus.UNAUTHORIZED),
    VALIDATION_ERROR(1005, "Dữ liệu đầu vào không hợp lệ", HttpStatus.BAD_REQUEST),
    ;

    private final int code;
    private final String message;
    private final HttpStatusCode statusCode;

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatusCode getStatusCode() {
        return statusCode;
    }
}
