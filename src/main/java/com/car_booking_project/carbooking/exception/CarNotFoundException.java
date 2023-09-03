package com.car_booking_project.carbooking.exception;

public class CarNotFoundException extends RuntimeException{
    public CarNotFoundException(long carId){
        super("car is not available");

    }
}
