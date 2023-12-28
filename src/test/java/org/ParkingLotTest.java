package org;

import com.Car;
import com.ParkingLot;
import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {
    @Test
    public void givenACar_ShouldBeAbleToPark(){
        ParkingLot parkingLot = new ParkingLot();
        Assert.assertTrue(parkingLot.park());
    }
}
