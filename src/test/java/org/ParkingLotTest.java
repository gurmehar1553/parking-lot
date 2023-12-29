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
        Car car1 = new Car("white","PB 01 4564","Creta");
        Car car2 = new Car("black","PB 02 9189","Brezza");
        parkingLot.park(car2);
        Assert.assertTrue(parkingLot.park(car1));
    }
    @Test
    public void givenACar_ShouldBeAbleToUnpark(){
        Car car = new Car("white","PB 01 4564","Creta");
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
    @Test
    public void givenDriver_ShouldReturnCar(){
        Car car1 = new Car("white","PB 01 4564","Creta");
        parkingLot.park(car1);
        Car car2 = new Car("black","PB 02 9189","Brezza");
        parkingLot.park(car2);
        Car actualCar = parkingLot.findCar(car1);
        Assert.assertEquals(car1,actualCar);
    }
    @Test
    public void givenCarParked_ShouldReturnLotCharges(){
        Car car1 = new Car("white","PB 01 4564","Creta");
        parkingLot.park(car1);
        Car car2 = new Car("black","PB 02 9189","Brezza");
        parkingLot.park(car2);
        parkingLot.unpark(car1);
        Assert.assertEquals(20,parkingLot.calculateCharges(car1));
    }
}
