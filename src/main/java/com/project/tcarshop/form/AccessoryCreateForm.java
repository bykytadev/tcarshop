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
public class AccessoryCreateForm extends AccessoryForm {
    @NotBlank
    @Length(max = 10)
    private String licensePlate;

    @NotNull
    @PastOrPresent
    private LocalDate repairDate;
}