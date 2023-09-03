package com.car_booking_project.carbooking.repository;

import com.car_booking_project.carbooking.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
