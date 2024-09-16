package com.example.pract3.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Size(max = 25, min = 2, message = "От 2 до 25 символов")
    @NotNull(message = "заполните поле")
    private String Name;
    @NotNull (message = "заполните поле")
    private Long number;
    @JsonManagedReference
    @OneToMany(mappedBy = "carId", fetch = FetchType.EAGER)
    private Collection <Driver> driverFK;

    public Car(Long id, String name, Long number, Collection<Driver> driverFK) {
        Id = id;
        Name = name;
        this.number = number;
        this.driverFK = driverFK;
    }

    public Car() {
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

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Collection<Driver> getDriverFK() {
        return driverFK;
    }

    public void setDriverFK(Collection<Driver> driverFK) {
        this.driverFK = driverFK;
    }
}
