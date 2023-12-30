package com;

public class ParkingAttendant {

    public boolean allotSlot(Car car, ParkingLot parkingLot,int slotNumber) {
        if(!parkingLot.checkFullCapacity()){
            car.setSlotNumber(slotNumber);
            parkingLot.park(car);
        }
        return false;
    }
}
