package com;

import java.time.LocalTime;
import java.util.ArrayList;

public class ParkingLot {
    public ArrayList<Car> space;
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
            car.setParkTime(LocalTime.now());
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
        car.setUnparkTime(LocalTime.now());
        checkFullCapacity();
        return true;
    }

    public boolean checkFullCapacity() {
        this.fullCapacity = space.size() == capacity;
        return this.fullCapacity;
    }

    public Car findCar(Car car) {
        for (Car c: space){
            if (c.equals(car)){
                return car;
            }
        }
        return null;
    }

    public int calculateCharges(Car car) {
        int timeParked = car.getUnparkTime().getHour() - car.getParkTime().getHour();
        return (timeParked+1)*20;
    }

    public boolean getCapacity() {
        return fullCapacity;
    }
}