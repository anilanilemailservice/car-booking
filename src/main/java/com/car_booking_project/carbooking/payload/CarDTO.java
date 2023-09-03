package com.car_booking_project.carbooking.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {
    private Long id;
    private String model;
    private String make;
    private boolean available;

    // Constructors, getters, and setters
}
