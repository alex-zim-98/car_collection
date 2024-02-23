package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarCollectorTest {
    CarCollector carCollector;

    @Before
    public void setUp() throws Exception {
        // Init
        for (int i = 0; i < 100; i++) {
            carCollector.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAddNewElement() {
        assertTrue(carCollector.add(new Car("Brand100", 100)));
        assertEquals(101, carCollector.size());
    }

    @Test
    public void whenRemoveElement() {
        assertTrue(carCollector.remove(new Car("Brand0", 0)));
        assertEquals(99, carCollector.size());
    }

    @Test
    public void whenContainsElement() {
        assertTrue(carCollector.contains(new Car("Brand0", 0)));
        assertFalse(carCollector.contains(new Car("Brand00", 0)));
    }

}