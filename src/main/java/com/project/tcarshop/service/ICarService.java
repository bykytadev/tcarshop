package com.project.tcarshop.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.tcarshop.dto.CarDto;
import com.project.tcarshop.entity.Car;
import com.project.tcarshop.exception.ResourceNotFoundException;
import com.project.tcarshop.form.CarCreateForm;
import com.project.tcarshop.form.CarUpdateForm;

public interface ICarService {
    Page<CarDto> findAll(Pageable pageable);

    CarDto create(CarCreateForm form);

    CarDto update(CarUpdateForm form) throws ResourceNotFoundException;

    void deleteById(Car.PrimaryKey pk);
}