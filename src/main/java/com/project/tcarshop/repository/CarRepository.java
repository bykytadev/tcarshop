package com.project.tcarshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.project.tcarshop.entity.Car;

public interface CarRepository extends JpaRepository<Car, Car.PrimaryKey>, JpaSpecificationExecutor<Car> {
}
