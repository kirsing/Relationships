package com.example.relationshipspractise.controller.manytoone;

import com.example.relationshipspractise.model.manytoone.Car;
import com.example.relationshipspractise.model.manytoone.Manufacture;
import com.example.relationshipspractise.repository.CarRepository;
import com.example.relationshipspractise.repository.ManufactureRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/car-info")
public class CarManufactureController {
    CarRepository carRepository;
    ManufactureRepository manufactureRepository;

    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
    @PostMapping("/cars/create")
    public String createCar(@Valid @RequestBody Car car) {
        carRepository.save(car);
        return "You created a car";
    }
    @GetMapping("/manufactures")
    public List<Manufacture> getAllManufactures() {
        return manufactureRepository.findAll();
    }
    @PostMapping("/manufactures/create")
    public String createManufacture(@RequestBody Manufacture manufacture) {
        manufactureRepository.save(manufacture);
        return "You created a manufacture";
    }
    @DeleteMapping("/cars/delete/{carId}")
    public void deleteCarById(@Min(10) @PathVariable Long carId) {
        carRepository.deleteById(carId);
    }

    @DeleteMapping("/manufacture/delete/{manufactureId}")
    public void deleteManufactureById(@PathVariable Long manufactureId) {
        manufactureRepository.deleteById(manufactureId);
    }
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
