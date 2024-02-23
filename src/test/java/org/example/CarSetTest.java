package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarSetTest {
    CarSet carSet;
    Car car;

    @Before
    public void setUp() throws Exception {
        // Init
        car = new Car("Test", 1);
        for (int i = 0; i < 100; i++) {
            carSet.add(new Car("Brand"+i, i));
        }
    }

    @Test
    public void whenAddedNewElement() {
        assertTrue(carSet.add(car));
        assertEquals(101, carSet.size());
    }

    @Test
    public void whenAddedOldElement() {
        assertFalse(carSet.add(car));
        assertEquals(101, carSet.size());
    }

}