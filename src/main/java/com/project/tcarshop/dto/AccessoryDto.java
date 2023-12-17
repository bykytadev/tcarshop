package com.project.tcarshop.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccessoryDto {
    private Long id;
    @JsonProperty("licensePlate")
    private String carPkLicensePlate;
    @JsonProperty("repairDate")
    private LocalDate carPkRepairDate;
    private String name;
    private Long price;
    private String statusDamaged;
    private String repairStatus;
}