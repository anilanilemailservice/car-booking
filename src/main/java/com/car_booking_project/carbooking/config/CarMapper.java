package com.car_booking_project.carbooking.config;
import com.car_booking_project.carbooking.entity.Car;

import com.car_booking_project.carbooking.payload.CarDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


@Component
public class CarMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public CarMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CarDTO toDto(Car car) {
        return modelMapper.map(car, CarDTO.class);
    }

    public Car toEntity(CarDTO carDTO) {
        return modelMapper.map(carDTO, Car.class);
    }
    public List<CarDTO> toDtoList(List<Car> cars) {
        return cars.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
