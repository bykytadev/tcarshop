package com.project.tcarshop.form;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarForm {
    @NotBlank(message = "{car.licensePlate.NotBlank.message}")
    @Length(max = 10, message = "{car.licensePlate.Length.message}")
    protected String licensePlate;

    @NotNull
    @PastOrPresent
    protected LocalDate repairDate;

    @NotBlank
    @Length(max = 50)
    protected String customerName;

    @NotBlank
    @Length(max = 50)
    protected String catalog;

    @NotBlank
    @Length(max = 50)
    protected String carMaker;
}