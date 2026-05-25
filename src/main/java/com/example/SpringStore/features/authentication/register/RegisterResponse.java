package com.example.SpringStore.features.authentication.register;

import java.time.Instant;

public class RegisterResponse {
    private String id;
    private String username;
    private String email;
    private String fullName;
    private Instant createdAt;

    public RegisterResponse() {}

    public RegisterResponse(String id, String username, String email, String fullName, Instant createdAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.fullName = fullName;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public static RegisterResponseBuilder builder() {
        return new RegisterResponseBuilder();
    }

    public static class RegisterResponseBuilder {
        private String id;
        private String username;
        private String email;
        private String fullName;
        private Instant createdAt;

        public RegisterResponseBuilder id(String id) {
            this.id = id;
            return this;
        }

        public RegisterResponseBuilder username(String username) {
            this.username = username;
            return this;
        }

        public RegisterResponseBuilder email(String email) {
            this.email = email;
            return this;
        }

        public RegisterResponseBuilder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public RegisterResponseBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public RegisterResponse build() {
            return new RegisterResponse(id, username, email, fullName, createdAt);
        }
    }
}
