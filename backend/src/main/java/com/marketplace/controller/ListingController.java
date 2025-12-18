package com.marketplace.controller;

import com.marketplace.model.LandListing;
import com.marketplace.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/listings")
public class ListingController {

    @Autowired
    ListingRepository listingRepository;

    @GetMapping
    public List<LandListing> getAllListings() {
        return listingRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LandListing> getListingById(@PathVariable String id) {
        return listingRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasRole('SELLER')")
    public LandListing createListing(@RequestBody LandListing listing) {
        listing.setCreatedAt(LocalDateTime.now());
        return listingRepository.save(listing);
    }
}
