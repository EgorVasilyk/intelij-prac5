package com.example.pract3.Controller;

import com.example.pract3.models.Driver;
import com.example.pract3.models.ErrorResp;
import com.example.pract3.repository.DriverRep;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/drivers/")
public class DriverController {
    private final DriverRep driverRep;

    public DriverController(DriverRep driverRep) {
        this.driverRep = driverRep;
    }
    @GetMapping
    public List<Driver> driverList(){
        return driverRep.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Driver> driverOptional(@PathVariable Long id){
        return driverRep.findById(id);
    }
    @PostMapping
    public Driver createDriver(@RequestBody Driver driver){return driverRep.save(driver);}
    @PutMapping("/{id}")
    public ResponseEntity<?> updateDriver(@PathVariable Long id, @RequestBody Driver driver){
        if (!driverRep.existsById(id)){
            ErrorResp errorResponse = new ErrorResp();
            errorResponse.setMessage("водитель по id не найден");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
        driver.setId(id);
        driverRep.save(driver);
        return new ResponseEntity<>(driverRep, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDriver(@PathVariable Long id){
        if (!driverRep.existsById(id)){
            ErrorResp errorResponse = new ErrorResp();
            errorResponse.setMessage("водитель по id не найден");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
        driverRep.deleteById(id);
        return new ResponseEntity<>(driverRep, HttpStatus.OK);
    }
}
