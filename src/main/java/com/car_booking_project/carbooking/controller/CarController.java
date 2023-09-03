package com.car_booking_project.carbooking.controller;

import com.car_booking_project.carbooking.payload.CarDTO;
import com.car_booking_project.carbooking.service.CarService;

import com.car_booking_project.carbooking.service.PaymentService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;
    private final PaymentService paymentService;


    @Autowired
    public CarController(CarService carService, PaymentService paymentService) {
        this.carService = carService;
        this.paymentService = paymentService;
    }
//http://localhost:8080/cars
    @GetMapping
    public List<CarDTO> getAllCars() {
        return carService.getAllCars();
    }
    //http://localhost:8080/cars/available
    @GetMapping("/available")
    public List<CarDTO> getAvailableCars() {
        return carService.getAvailableCars();
    }
    //http://localhost:8080/cars/book/4
    @PostMapping("/book/{carId}")
    public ResponseEntity<String> bookCar(@PathVariable Long carId) {
        return carService.bookCar(carId);
    }

    // ...
    }


