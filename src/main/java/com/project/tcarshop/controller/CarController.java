package com.project.tcarshop.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.tcarshop.dto.CarDto;
import com.project.tcarshop.entity.Car;
import com.project.tcarshop.form.CarCreateForm;
import com.project.tcarshop.form.CarUpdateForm;
import com.project.tcarshop.service.ICarService;
import com.project.tcarshop.validation.CarPkExists;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cars")
@CrossOrigin(origins = "*")
public class CarController {
    private final ICarService carService;

    @GetMapping
    public Page<CarDto> findAll(Pageable pageable) {
        return carService.findAll(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarDto create(@RequestBody @Valid CarCreateForm form) {
        return carService.create(form);
    }

    @PutMapping
    public CarDto update(@RequestBody @Valid CarUpdateForm form) {
        return carService.update(form);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@RequestBody @CarPkExists Car.PrimaryKey pk) {
        carService.deleteById(pk);
    }
}