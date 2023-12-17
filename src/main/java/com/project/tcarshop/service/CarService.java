package com.project.tcarshop.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.tcarshop.dto.CarDto;
import com.project.tcarshop.entity.Car;
import com.project.tcarshop.exception.ResourceNotFoundException;
import com.project.tcarshop.form.CarCreateForm;
import com.project.tcarshop.form.CarUpdateForm;
import com.project.tcarshop.repository.CarRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarService implements ICarService {
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public Page<CarDto> findAll(Pageable pageable) {
        return carRepository.findAll(pageable)
                .map(car -> modelMapper.map(car, CarDto.class));
    }

    @Override
    @Transactional
    public CarDto create(CarCreateForm form) {
        var car = modelMapper.map(form, Car.class);
        var pk = modelMapper.map(form, Car.PrimaryKey.class);
        car.setPk(pk);
        var savedCar = carRepository.save(car);
        return modelMapper.map(savedCar, CarDto.class);
    }

    @Override
    @Transactional
    public CarDto update(CarUpdateForm form) throws ResourceNotFoundException {
        var pk = modelMapper.map(form, Car.PrimaryKey.class);
        var car = carRepository.findById(pk).orElseThrow(() -> new ResourceNotFoundException("Car not found"));
        modelMapper.map(form, car);
        var savedCar = carRepository.save(car);
        return modelMapper.map(savedCar, CarDto.class);
    }

    @Override
    @Transactional
    public void deleteById(Car.PrimaryKey pk) {
        carRepository.deleteById(pk);
    }
}