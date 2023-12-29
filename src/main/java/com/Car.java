package com;

import java.time.LocalTime;
import java.util.Objects;

public class Car {
    String color;
    String numberPlate;
    String name;
    LocalTime parkTime;
    LocalTime unparkTime;
    public Car(String color,String numberPlate,String name){
        this.color = color;
        this.numberPlate = numberPlate;
        this.name = name;
    }

    public LocalTime getParkTime() {
        return parkTime;
    }

    public void setParkTime(LocalTime parkTime) {
        this.parkTime = parkTime;
    }

    public LocalTime getUnparkTime() {
        return unparkTime;
    }

    public void setUnparkTime(LocalTime unparkTime) {
        this.unparkTime = unparkTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(color, car.color) && Objects.equals(numberPlate, car.numberPlate) && Objects.equals(name, car.name);
    }
}
