package com.example.pract3.Controller;

import com.example.pract3.models.Car;
import com.example.pract3.models.ErrorResp;
import com.example.pract3.repository.CarRep;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars/")
public class CarController {
    private final CarRep carRep;

    public CarController(CarRep carRep) {
        this.carRep = carRep;
    }
    @GetMapping
    public List<Car> carList(){
        return carRep.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Car> carOptional(@PathVariable Long id){
        return carRep.findById(id);
    }
    @PostMapping
    public Car createCar(@RequestBody Car car){return carRep.save(car);}

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCar(@PathVariable Long id, @RequestBody Car car){
        if (!carRep.existsById(id)){
            ErrorResp errorResponse = new ErrorResp();
            errorResponse.setMessage("машина по id не найдена");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
        car.setId(id);
        carRep.save(car);
        return new ResponseEntity<>(carRep, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Long id){
        if (!carRep.existsById(id)){
            ErrorResp errorResponse = new ErrorResp();
            errorResponse.setMessage("машина по id не найдена");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
        carRep.deleteById(id);
        return new ResponseEntity<>(carRep, HttpStatus.OK);
    }
}
