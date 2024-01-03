package com;

public class ParkingAttendant {
    String attendantName;
    public ParkingAttendant(String attendantName){
        this.attendantName = attendantName;
    }

    public String getAttendantName() {
        return attendantName;
    }

    public void setAttendantName(String attendantName) {
        this.attendantName = attendantName;
    }

    public boolean allotSlot(Car car, ParkingLot parkingLot, int slotNumber) {
        if(!parkingLot.checkFullCapacity()){
            car.setSlotNumber(slotNumber);
            parkingLot.park(car);
        }
        return false;
    }
}
