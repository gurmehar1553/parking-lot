package com;

import java.util.ArrayList;
import java.util.List;

public class PoliceDept {
    public List<Integer> findCarFromGivenColor(String color, ParkingLotService parkingLotService) {
        List<Integer> ans = new ArrayList<>();
        for (ParkingLot parkingLot: parkingLotService.parkingLots){
            this.findCar(color,parkingLot,ans);
        }
        return ans;
    }

    private void findCar(String color, ParkingLot parkingLot,List<Integer> ans) {
        for (Car c: parkingLot.space) {
            if (c.color.equals(color)) {
                ans.add(c.slotNumber);
            }
        }
    }

    public Car findParticularCar(String color, String name,ParkingLotService parkingLotService ) {
        for (ParkingLot parkingLot : parkingLotService.parkingLots){
            Car ans = this.findCar(color,name,parkingLot);
            if (ans != null){
                return ans;
            }
        }
        return null;
    }

    private Car findCar(String color, String name, ParkingLot parkingLot) {
        for (Car car: parkingLot.space){
            if (car.color.equals(color) && car.name.equals(name)){
                return car;
            }
        }
        return null;
    }
    public int findCarFromGivenName(String name, ParkingLotService parkingLotService) {
        for (ParkingLot parkingLot : parkingLotService.parkingLots){
            Car car = this.findCar(name,parkingLot);
            if (car != null){
                return car.getSlotNumber();
            }
        }
        return -1;
    }

    private Car findCar(String name, ParkingLot parkingLot) {
        for (Car car : parkingLot.space){
            if (car.name.equals(name)){
                return car;
            }
        }
        return null;
    }
}