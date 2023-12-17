package com.project.tcarshop.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccessoryDto {

    @NotNull(message = "ID cannot be null")
    private Long id;

    @JsonProperty("licensePlate")
    @NotEmpty(message = "License plate cannot be empty")
    private String carPkLicensePlate;

    @JsonProperty("repairDate")
    @NotNull(message = "Repair date cannot be null")
    private LocalDate carPkRepairDate;

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Price cannot be null")
    private Long price;

    @NotEmpty(message = "Damage status cannot be empty")
    private String statusDamaged;

    @NotEmpty(message = "Repair status cannot be empty")
    private String repairStatus;
}