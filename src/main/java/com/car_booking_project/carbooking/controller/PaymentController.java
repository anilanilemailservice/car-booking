package com.car_booking_project.carbooking.controller;

import com.car_booking_project.carbooking.payload.PaymentConfirmationDTO;
import com.car_booking_project.carbooking.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
//http://localhost:8080/api/payments/confirm
    @PostMapping("/confirm")
    public ResponseEntity<String> confirmPayment(@RequestBody PaymentConfirmationDTO confirmationDTO) {
        boolean paymentConfirmed = paymentService.confirmPayment(confirmationDTO);
        if (paymentConfirmed) {
            return ResponseEntity.ok("Payment confirmed successfully.");
        } else {
            return ResponseEntity.badRequest().body("Payment confirmation failed.");
        }
    }
}
