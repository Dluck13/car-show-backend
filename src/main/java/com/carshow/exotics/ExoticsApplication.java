package com.carshow.exotics;

import com.carshow.exotics.entity.Car;
import com.carshow.exotics.entity.Owner;
import com.carshow.exotics.repo.CarRepo;
import com.carshow.exotics.repo.OwnerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ExoticsApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(SpringApplication.class);

	@Autowired
	private CarRepo carRepo;
	@Autowired
	private OwnerRepo ownerRepo;

	public static void main(String[] args) {
		SpringApplication.run(ExoticsApplication.class, args);

		logger.warn("Application started");



	}

	@Override
	public void run(String... args) throws Exception {
		logger.warn("Owner created");

		Owner owner = new Owner("John","Smith");
		Owner o1 = new Owner("Jane", "Doe");
		logger.warn("Owners have been saved");

		ownerRepo.save(owner);
		ownerRepo.save(o1);
		List<Car> cars = Arrays.asList(
				new Car("Chevy", "Corvette", "Red", "abc", 2023, 80000.00,owner),
				new Car("Nissan","Leaf","Gray","EBF_1221",2020,32500, o1),
				new Car("Toyota","Camry","Silver","CDF_3123",2021,32000, owner),
				new Car("Toyota","Corolla","White","DDF_3421",2023,40000, o1));

		carRepo.saveAll(cars);
		logger.warn("Cars have been saved");

		logger.warn("Found all cars");

		carRepo.findAll().forEach(car -> logger.info(car.getMake()+" "+ car.getModel()));



	}
}
