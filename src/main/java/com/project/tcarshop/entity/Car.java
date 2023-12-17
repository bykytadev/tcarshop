package com.project.tcarshop.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "car")
public class Car {
    @EmbeddedId
    private PrimaryKey pk;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "catalog", nullable = false)
    private String catalog;

    @Column(name = "car_maker", nullable = false)
    private String carMaker;

    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY)
    private List<Accessory> accessories;

    @Getter
    @Setter
    @Embeddable
    public static class PrimaryKey {
        @Column(name = "license_plate", nullable = false)
        private String licensePlate;

        @Column(name = "repair_date", nullable = false)
        private LocalDate repairDate;
    }
}