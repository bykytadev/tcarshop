package com.project.tcarshop.response;

import java.util.List;

import com.project.tcarshop.dto.CarDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarResponse {
    private List<CarDto> cars;
    private long totalCars;
}
