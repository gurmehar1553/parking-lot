package com;

import java.util.Map;

public class ParkingLotService {
    ParkingLot[] parkingLots;
    ParkingAttendant parkingAttendant;
    public ParkingLotService(){
        parkingLots = new ParkingLot[10];
        for (int i=0;i<10;i++){
            parkingLots[i] = new ParkingLot();
        }
        parkingAttendant = new ParkingAttendant();
    }
    public int allotCar(Car[] cars) {
        int slotNumber = 0;
        for (Car car : cars){
            parkingAttendant.allotSlot(car,parkingLots[slotNumber],slotNumber);
            slotNumber = (slotNumber+1)%10;
        }
        return this.giveNonEmptySlots();
    }

    private int giveNonEmptySlots() {
        int cnt=0;
        for (int i=0;i<10;i++){
            if (!parkingLots[i].space.isEmpty()){
                cnt++;
            }
        }
        return cnt;
    }

    public int allotCarNearestSpace(Car car) {
        int leastSpace = parkingLots[0].space.size();
        int slotNumber = 0;
        for (int i=0;i<10;i++){
            if (leastSpace > parkingLots[i].space.size()){
                leastSpace = parkingLots[i].space.size();
                slotNumber = i;
            }
        }
        parkingAttendant.allotSlot(car,parkingLots[slotNumber],slotNumber);
        return slotNumber;
    }

    public int allotCarHighestFreeSpace(Car car, ParkingLot parkingLot) {
        int maxFreeSpace = parkingLots[0].space.size();
        int slotNumber = 0;
        for (int i=0;i<10;i++){
            if (maxFreeSpace > parkingLots[i].space.size()){
                maxFreeSpace = parkingLots[i].space.size();
                slotNumber = i;
            }
        }
        parkingAttendant.allotSlot(car,parkingLots[slotNumber],slotNumber);
        return slotNumber;
    }
}
