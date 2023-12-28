package com;

import java.util.Objects;

public class Car {
    String color;
    String numberPlate;
    String name;
    public Car(String color,String numberPlate,String name){
        this.color = color;
        this.numberPlate = numberPlate;
        this.name = name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(color, car.color) && Objects.equals(numberPlate, car.numberPlate) && Objects.equals(name, car.name);
    }
}
