package com.marketplace.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.util.List;
import java.time.LocalDateTime;

@Data
@Document(collection = "listings")
public class LandListing {
    @Id
    private String id;
    private String sellerId;
    private String title;
    private double amount;
    private Location location;
    private double areaSqYards;
    private List<DocumentFile> documents;
    private String visibility; // PAID_ONLY, PUBLIC
    private LocalDateTime createdAt;

    @Data
    public static class Location {
        private String address;
        private double lat;
        private double lng;
    }

    @Data
    public static class DocumentFile {
        private String docId;
        private String type;
        private String fileUrl;
        private String hash;
    }
}
