package com.example.pract3.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @NotNull (message = "заполните поле")
    private String Name;
    @NotNull (message = "заполните поле")
    private String LastName;
    @NotNull (message = "заполните поле")
    private Long phone;
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.MERGE)
    private Car carId;

    public Driver(Long id, String name, String lastName, Long phone, Car carId) {
        Id = id;
        Name = name;
        LastName = lastName;
        this.phone = phone;
        this.carId = carId;
    }

    public Driver() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Car getCarId() {
        return carId;
    }

    public void setCarId(Car carId) {
        this.carId = carId;
    }
}
