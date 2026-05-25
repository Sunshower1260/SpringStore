package com.example.SpringStore.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@Configuration
@EnableMongoAuditing
public class MongoConfig {
    // Kích hoạt tính năng tự động lưu createdAt, updatedAt cho MongoDB
}
