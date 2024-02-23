package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarListTest {
    CarList carList;
    Car car;
    @Before
    public void setUp() throws Exception {
        // init
        car = new Car("Test", 1);
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAddedNewElement() {
        carList.add(car);
        assertEquals(101, carList.size());

        carList.add(car);
        assertEquals(102, carList.size());
    }

    @Test
    public void whenAddedNewElementByIndex() {
        Car expected = new Car("Test", 1);
        carList.add(car, 0);
        assertEquals(101, carList.size());
        assertEquals(expected, carList.get(0));

        carList.add(car, 1);
        assertEquals(102, carList.size());
        assertEquals(expected, carList.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddedNewElementByWrongAbsIndex() {
        carList.add(car, carList.size() + 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddedNewElementByWrongNoAbsIndex() {
        carList.add(car, -1);
    }
}