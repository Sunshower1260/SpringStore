package com.example.SpringStore.features.authentication.profile;

import java.time.Instant;

public class ProfileResponse {
    private String id;
    private String username;
    private String email;
    private String fullName;
    private Instant createdAt;

    public ProfileResponse() {}

    public ProfileResponse(String id, String username, String email, String fullName, Instant createdAt) {
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

    public static ProfileResponseBuilder builder() {
        return new ProfileResponseBuilder();
    }

    public static class ProfileResponseBuilder {
        private String id;
        private String username;
        private String email;
        private String fullName;
        private Instant createdAt;

        public ProfileResponseBuilder id(String id) {
            this.id = id;
            return this;
        }

        public ProfileResponseBuilder username(String username) {
            this.username = username;
            return this;
        }

        public ProfileResponseBuilder email(String email) {
            this.email = email;
            return this;
        }

        public ProfileResponseBuilder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public ProfileResponseBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public ProfileResponse build() {
            return new ProfileResponse(id, username, email, fullName, createdAt);
        }
    }
}
