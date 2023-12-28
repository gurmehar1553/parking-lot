package com;

import java.util.ArrayList;

public class ParkingLot {
    ArrayList<Car> space;
    boolean fullCapacity;
    int capacity;
    public ParkingLot(){
        this.capacity = 100;
        space = new ArrayList<>(capacity);
        fullCapacity = false;
    }
    public boolean park(Car car){
        if (space.size() < 100){
            space.add(car);
            return true;
        }
        return false;
    }

    public boolean unpark(Car car) {
        space.remove(car);
        return true;
    }

    public boolean checkFullCapacity() {
        if (space.size()==capacity){
            this.fullCapacity = true;
        }
        return this.fullCapacity;
    }
}












