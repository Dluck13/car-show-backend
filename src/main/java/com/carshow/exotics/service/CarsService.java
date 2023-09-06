package com.carshow.exotics.service;

import com.carshow.exotics.entity.Car;

import java.util.List;

public interface CarsService {

    List<Car> getCars();

    Car retrieveCar(Long id);

    void deleteCar(Long id);

    Car createCar(Car car);

    Car updateCar(Long id, Car car);
}
