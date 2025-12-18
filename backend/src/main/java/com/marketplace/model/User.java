package com.marketplace.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String username;
    private String email;
    private boolean emailVerified;
    private String passwordHash;
    private Set<String> roles;
    private String phone;
    private boolean phoneVerified;
    private LocalDateTime createdAt;
    private Profile profile;

    @Data
    public static class Profile {
        private String fullName;
        private String address;
        private String gstin;
    }
}
