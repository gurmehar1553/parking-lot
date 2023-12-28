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
            checkFullCapacity();
            return true;
        }
        return false;
    }

    public boolean unpark(Car car) {
        space.remove(car);
        checkFullCapacity();
        return true;
    }

    public boolean checkFullCapacity() {
        this.fullCapacity = space.size() == capacity;
        return this.fullCapacity;
    }
}