package com.project.tcarshop.form;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccessoryForm {
    @NotBlank
    @Length(max = 50)
    protected String name;

    @NotNull
    @PositiveOrZero
    protected Long price;

    @NotBlank
    @Length(max = 50)
    protected String statusDamaged;

    @NotBlank
    @Length(max = 50)
    protected String repairStatus;
}