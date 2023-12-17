package com.project.tcarshop.validation;

import com.project.tcarshop.entity.Car;
import com.project.tcarshop.repository.CarRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CarPkExistsValidator implements ConstraintValidator<CarPkExists, Car.PrimaryKey> {
    private final CarRepository carRepository;


    @Override
    public boolean isValid(Car.PrimaryKey pk, ConstraintValidatorContext context) {
        return carRepository.existsById(pk);
    }
}