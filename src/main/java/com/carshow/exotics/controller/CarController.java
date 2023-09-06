package com.carshow.exotics.controller;

import com.carshow.exotics.entity.Car;
import com.carshow.exotics.exceptions.ResourceNotFoundException;
import com.carshow.exotics.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cars")
public class CarController {

    @Autowired
  CarsService carsService;

    @GetMapping
    public ResponseEntity<List<Car>> getCars() {
        return new ResponseEntity<>(carsService.getCars(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> retrieveCar(@PathVariable Long id) {
        return new ResponseEntity<>(carsService.retrieveCar(id), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCar(@PathVariable Long id) {
        carsService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);}

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        return new ResponseEntity<>(carsService.createCar(car), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@RequestBody Car car, @PathVariable Long id) {

        return  new ResponseEntity<>(carsService.updateCar(id, car), HttpStatus.OK);


    }
}
