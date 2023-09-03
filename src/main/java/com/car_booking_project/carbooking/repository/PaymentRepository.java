package com.car_booking_project.carbooking.repository;

import com.car_booking_project.carbooking.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
