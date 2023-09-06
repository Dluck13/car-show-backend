package com.carshow.exotics.entity;


import jakarta.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String make;

    private String model;

    private String color;

    private String registration;

    private int year;

    double price;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "owner")
    private Owner owner;

    public Car(){};

    public Car(Long id, String make, String model, String color, String registration, int year, double price) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.color = color;
        this.registration = registration;
        this.year = year;
        this.price = price;
    }

    public Car(String make, String model, String color, String registration, int year, double price, Owner owner) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.registration = registration;
        this.year = year;
        this.price = price;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }


}
