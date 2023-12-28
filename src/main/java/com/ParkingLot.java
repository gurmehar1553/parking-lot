package com;

import java.util.ArrayList;

public class ParkingLot {
    ArrayList<Car> space;
    int capacity;
    public ParkingLot(){
        this.capacity = 100;
        space = new ArrayList<>(capacity);
    }
    public boolean park(){
        if (space.size() < 100){
            return true;
        }
        return false;
    }
}












