package com.marketplace.service;

import com.razorpay.RazorpayClient;
import com.razorpay.Subscription;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RazorpayService {

    @Value("${razorpay.key_id}")
    private String keyId;

    @Value("${razorpay.key_secret}")
    private String keySecret;

    public Subscription createSubscription(String planId, int totalCount) throws Exception {
        RazorpayClient razorpay = new RazorpayClient(keyId, keySecret);
        JSONObject subscriptionRequest = new JSONObject();
        subscriptionRequest.put("plan_id", planId);
        subscriptionRequest.put("total_count", totalCount);
        subscriptionRequest.put("quantity", 1);
        subscriptionRequest.put("customer_notify", 1);

        return razorpay.subscriptions.create(subscriptionRequest);
    }
}
