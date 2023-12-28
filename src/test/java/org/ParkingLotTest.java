package org;

import com.AirportSecurity;
import com.Car;
import com.ParkingLot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {
    ParkingLot parkingLot;
    @Before
    public void setUp(){
        parkingLot = new ParkingLot();
    }
    @Test
    public void givenACar_ShouldBeAbleToPark(){
        Car car = new Car();
        Assert.assertTrue(parkingLot.park(car));
    }
    @Test
    public void givenACar_ShouldBeAbleToUnpark(){
        Car car = new Car();
        Assert.assertTrue(parkingLot.unpark(car));
    }
    @Test
    public void givenParkingLot_ShouldReturnFullCapacity(){
        Assert.assertTrue(parkingLot.checkFullCapacity());
    }
    @Test
    public void givenCapacityFull_RedirectSecurity(){
        if(parkingLot.checkFullCapacity()){
            new AirportSecurity().redirectSecurityStaff();
        }
    }
}
