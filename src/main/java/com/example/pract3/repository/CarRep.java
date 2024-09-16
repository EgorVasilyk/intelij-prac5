package com.example.pract3.repository;

import com.example.pract3.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRep extends JpaRepository<Car,Long> {
}
