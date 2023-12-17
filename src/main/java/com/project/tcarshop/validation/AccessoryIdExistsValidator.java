package com.project.tcarshop.validation;

import com.project.tcarshop.repository.AccessoryRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AccessoryIdExistsValidator implements ConstraintValidator<AccessoryIdExists, Long> {
    private final AccessoryRepository accessoryRepository;

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        return accessoryRepository.existsById(id);
    }
}