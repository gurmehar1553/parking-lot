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
}