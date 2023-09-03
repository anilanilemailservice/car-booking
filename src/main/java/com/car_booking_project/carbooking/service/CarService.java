package com.car_booking_project.carbooking.service;

import com.car_booking_project.carbooking.entity.Car;
import com.car_booking_project.carbooking.payload.CarDTO;
import com.car_booking_project.carbooking.repository.CarRepository;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class CarService {

    private final CarRepository carRepository;
private final PaymentService paymentService;
    @Autowired
    public CarService(CarRepository carRepository, PaymentService paymentService) {
        this.carRepository = carRepository;
        this.paymentService = paymentService;
    }

    public List<CarDTO> getAllCars() {
        List<Car> cars = carRepository.findAll();
        return cars.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public List<CarDTO> getAvailableCars() {
        List<Car> availableCars = carRepository.findByAvailableTrue();
        return availableCars.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public ResponseEntity<String> bookCar(Long carId) {
        Optional<Car> optionalCar = carRepository.findById(carId);
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            if (car.isAvailable()) {
                // Call Stripe payment service to initiate the payment
                try {
                    PaymentIntent paymentIntent = paymentService.createPaymentIntent(1000, "usd");
                    // You can return the paymentIntent to the client to complete the payment on the frontend
                    car.setAvailable(false);
                    carRepository.save(car);
                    return ResponseEntity.ok(paymentIntent.toJson());
                } catch (StripeException e) {
                    return ResponseEntity.badRequest().body("Payment processing failed.");
                }
            } else {
                return ResponseEntity.badRequest().body("Car is not available for booking.");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ... Other methods ...

    private CarDTO mapToDto(Car car) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(car, CarDTO.class);
    }
}

