package com.car_booking_project.carbooking.exception;

public class PetNotFoundException extends RuntimeException{

    public PetNotFoundException(long id){
        super("pet not found for id"+id);
    }
}
