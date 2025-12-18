package com.marketplace.repository;

import com.marketplace.model.LandListing;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ListingRepository extends MongoRepository<LandListing, String> {
    List<LandListing> findBySellerId(String sellerId);
}
