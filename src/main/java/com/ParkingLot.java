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
    /**
     * @param car
     * @return
     */
    public boolean park(Car car){
        if (space.size() < 100){
            space.add(car);
            checkFullCapacity();
            return true;
        }
        return false;
    }

    /**
     * Remove car from the list
     * @param car
     * @return
     */
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