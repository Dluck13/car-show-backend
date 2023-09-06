package com.carshow.exotics.service;

import com.carshow.exotics.entity.Car;
import com.carshow.exotics.exceptions.ResourceNotFoundException;
import com.carshow.exotics.repo.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarsService {

    @Autowired
    CarRepo carRepo;

    @Override
    public List<Car> getCars() {
        return (List<Car>) carRepo.findAll();
    }

    @Override
    public Car retrieveCar(Long id) {
        Optional<Car> carOptional = carRepo.findById(id);

        if (carOptional.isPresent()) {

            return carOptional.get();
        } else {
            throw new ResourceNotFoundException("Owner with " + id + " not found");

        }
    }

    @Override
    public void deleteCar(Long id) {
        Optional<Car> carOptional = carRepo.findById(id);
        if (carOptional.isPresent()) {
            carRepo.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Owner with " + id + " not found");
        }
    }

    @Override
    public Car createCar(Car car) {
        return carRepo.save(car);
    }

    @Override
    public Car updateCar(Long id, Car car) {
        Optional<Car> optionalCar = carRepo.findById(id);
        if (optionalCar.isPresent()) {
            optionalCar.get().setMake(car.getMake());
            optionalCar.get().setModel(car.getModel());
            optionalCar.get().setColor(car.getColor());
            optionalCar.get().setPrice(car.getPrice());
            optionalCar.get().setRegistration(car.getRegistration());
            optionalCar.get().setOwner(car.getOwner());
            optionalCar.get().setYear(car.getYear());
            carRepo.save(optionalCar.get());
            return optionalCar.get();
        } else {
            throw new ResourceNotFoundException("Owner with " + id + " not found");
        }
    }
}
