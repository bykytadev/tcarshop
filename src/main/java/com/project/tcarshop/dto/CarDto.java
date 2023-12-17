package com.project.tcarshop.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDto {

    @JsonProperty("licensePlate")
    @NotEmpty(message = "License plate cannot be empty")
    private String pkLicensePlate;

    @JsonProperty("repairDate")
    @NotNull(message = "Repair date cannot be null")
    private LocalDate pkRepairDate;

    @NotEmpty(message = "Customer name cannot be empty")
    private String customerName;

    @NotEmpty(message = "Catalog cannot be empty")
    private String catalog;

    @NotEmpty(message = "Car maker cannot be empty")
    private String carMaker;
}