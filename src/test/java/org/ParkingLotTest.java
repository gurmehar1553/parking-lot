package org;

import com.Car;
import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {
    @Test
    public void givenACar_ShouldBeAbleToPark(){
        Car car = new Car();
        Assert.assertTrue(car.park());
    }
}
