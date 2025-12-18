package com.marketplace.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.util.List;
import java.time.LocalDateTime;

@Data
@Document(collection = "seller_profiles")
public class SellerProfile {
    @Id
    private String id;
    private String userId;
    private String businessName;
    private String phonePublic;
    private List<String> verifiedDocs;
    private boolean approved;
    private LocalDateTime createdAt;
    private Ratings ratings;

    @Data
    public static class Ratings {
        private int count;
        private double avg;
    }
}
