package com.car_booking_project.carbooking.util;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public class StripePaymentService {

    private static final String STRIPE_SECRET_KEY = "sk_test_51NXEfLSDqSjbBCPTdehnLwxV6ic8r8pOppOnMFwYyexKWBR0L3Mx6gN6IJ08s6UfSJQc1YaCp8K8694M2XabKSeN00ub1xVsyv";

    static {
        Stripe.apiKey = STRIPE_SECRET_KEY;
    }

    public static PaymentIntent retrievePaymentIntent(String paymentIntentId) throws StripeException {
        return PaymentIntent.retrieve(paymentIntentId);
    }

}
