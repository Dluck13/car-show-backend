package com.carshow.exotics.repo;

import com.carshow.exotics.entity.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepo extends CrudRepository<Car, Long> {

//    Car findCarByMake(String make);
//    //select * from car where make = "Chevy";
//
//    List<Car> findCarByColor(String color);
//    //select * from car where color = "red";
//
//
//    List<Car> findByBrandAndModel(String make, String model);
//    //Select * from car where make = "chevy" and model = "corvette";
//
//    List<Car> findByBrandSortByYear(String make, int year);
//    //select * from car where make = "chevy" order by year asc;





























}
