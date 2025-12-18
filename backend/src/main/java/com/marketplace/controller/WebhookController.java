package com.marketplace.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.razorpay.Utils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;

@RestController
@RequestMapping("/api/webhooks")
public class WebhookController {

    @Value("${razorpay.webhook_secret}")
    private String webhookSecret;

    @PostMapping("/razorpay")
    public ResponseEntity<String> handleRazorpayWebhook(@RequestBody String payload,
            @RequestHeader("X-Razorpay-Signature") String signature) {
        try {
            Utils.verifyWebhookSignature(payload, signature, webhookSecret);

            JSONObject json = new JSONObject(payload);
            String event = json.getString("event");

            if ("subscription.charged".equals(event)) {
                // Handle subscription charged
                // JSONObject paymentEntity =
                // json.getJSONObject("payload").getJSONObject("payment").getJSONObject("entity");
                // Update DB logic here
            } else if ("subscription.cancelled".equals(event)) {
                // Handle cancellation
            }

            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid Signature");
        }
    }
}
