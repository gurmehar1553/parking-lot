package org;

import com.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
    @Test
    public void givenParkingAttendant_ShouldDirectEvenCarsToLots(){
        Car[] cars = {
                new Car("white","PB 01 4564","Creta"),
                new Car("black","PB 02 9189","Brezza"),
                new Car("red","CH 01 1234","Innova")
        };
        ParkingLotService parkingLotService = new ParkingLotService();
        Assert.assertEquals(3,parkingLotService.allotCar(cars));
    }
    @Test
    public void givenParkingAttendant_ShouldParkCarNearestFreeSpace(){
        Car[] cars = {
                new Car("white","PB 01 4564","Creta"),
                new Car("black","PB 02 9189","Brezza"),
                new Car("red","CH 01 1234","Innova")
        };
        ParkingLotService parkingLotService = new ParkingLotService();
        parkingLotService.allotCar(cars);
        Car car = new Car("white","CH 02 8674","Ecosport");
        Assert.assertEquals(3,parkingLotService.allotCarNearestSpace(car));
    }
    @Test
    public void givenParkingAttendant_ShouldParkLargeCarsWithHighestSpace(){
        Car[] cars = {
                new Car("white","PB 01 4564","Creta"),
                new Car("black","PB 02 9189","Brezza"),
                new Car("red","CH 01 1234","Innova"),
                new Car("white","CH 02 2345","BMW")
        };
        ParkingLotService parkingLotService = new ParkingLotService();
        parkingLotService.allotCar(cars);
        Car car = new Car("white","PB 01 1234","Ciaz");
        Assert.assertEquals(4,parkingLotService.allotCarHighestFreeSpace(car,parkingLot));
    }
    @Test
    public void givenPolice_ShouldReturnLocationOfWhiteCars(){
        Car[] cars = {
                new Car("white","PB 01 4564","Creta"),
                new Car("black","PB 02 9189","Brezza"),
                new Car("red","CH 01 1234","Innova"),
                new Car("white","CH 02 2345","BMW")
        };
        ParkingLotService parkingLotService = new ParkingLotService();
        parkingLotService.allotCar(cars);
        List<Integer> actualList = new PoliceDept().findCarFromGivenColor("white",parkingLotService);
        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(0);
        expectedList.add(3);
        Assert.assertEquals(expectedList,actualList);
    }
}
