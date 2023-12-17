package com.project.tcarshop.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.tcarshop.dto.AccessoryDto;
import com.project.tcarshop.entity.Accessory;
import com.project.tcarshop.entity.Car;
import com.project.tcarshop.exception.ResourceNotFoundException;
import com.project.tcarshop.form.AccessoryCreateForm;
import com.project.tcarshop.form.AccessoryUpdateForm;
import com.project.tcarshop.repository.AccessoryRepository;
import com.project.tcarshop.repository.CarRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor 
public class AccessoryService implements IAccessoryService {
    private final AccessoryRepository accessoryRepository;
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public Page<AccessoryDto> findAll(Pageable pageable) {
        return accessoryRepository.findAll(pageable)
                .map(accessory -> modelMapper.map(accessory, AccessoryDto.class));
    }

    @Override
    @Transactional
    public AccessoryDto create(AccessoryCreateForm form) {
        var accessory = modelMapper.map(form, Accessory.class);
        var pk = modelMapper.map(form, Car.PrimaryKey.class);
        var car = carRepository.findById(pk).orElseThrow(() -> new ResourceNotFoundException("Car not found"));
        accessory.setCar(car);
        var savedAccessory = accessoryRepository.save(accessory);
        return modelMapper.map(savedAccessory, AccessoryDto.class);
    }

    @Override
    @Transactional
    public AccessoryDto update(Long id, AccessoryUpdateForm form) throws ResourceNotFoundException {
        var accessory = accessoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Accessory not found"));
        modelMapper.map(form, accessory);
        var savedAccessory = accessoryRepository.save(accessory);
        return modelMapper.map(savedAccessory, AccessoryDto.class);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        accessoryRepository.deleteById(id);
    }
}