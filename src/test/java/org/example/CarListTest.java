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

    @Test
    public void whenRemoveCar() {
        carList.add(car);
        assertTrue(carList.remove(car));
        assertEquals(100, carList.size());

        assertTrue(carList.remove(new Car("Brand0", 0)));
        assertEquals(99, carList.size());
    }

    @Test
    public void whenRemoveWrongCar() {
        assertFalse(carList.remove(car));
        assertEquals(100, carList.size());

        assertFalse(carList.remove(new Car("Brand101", 101)));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenRemoveCarByIndex() {
        carList.add(car);
        assertTrue(carList.removeAt(100));
        assertEquals(100, carList.size());

        assertTrue(carList.removeAt(99));
        assertEquals(99, carList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenRemoveCarByWrongAbsIndex() {
        carList.removeAt(101);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenRemoveCarByWrongNoAbsIndex() {
        carList.removeAt(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetDataByWrongNoAbsIndex() {
        carList.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetDataByWrongAbsIndex() {
        carList.get(101);
    }

}