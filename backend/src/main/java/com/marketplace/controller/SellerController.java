package com.marketplace.controller;

import com.marketplace.model.SellerProfile;
import com.marketplace.repository.SellerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/sellers")
public class SellerController {

    @Autowired
    SellerProfileRepository sellerProfileRepository;

    @PostMapping("/profile")
    @PreAuthorize("hasRole('SELLER')")
    public SellerProfile createProfile(@RequestBody SellerProfile profile) {
        profile.setCreatedAt(LocalDateTime.now());
        return sellerProfileRepository.save(profile);
    }

    @GetMapping("/profile/{userId}")
    public ResponseEntity<SellerProfile> getProfileByUserId(@PathVariable String userId) {
        return sellerProfileRepository.findByUserId(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
