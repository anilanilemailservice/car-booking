package com.car_booking_project.carbooking.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutRequest {
    private Long petId;
    private List<Long> productIds;
    private String paymentMethodId;
}
