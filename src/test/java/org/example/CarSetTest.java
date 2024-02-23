package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarSetTest {
    CarSet carSet;
    Car car;

    @Before
    public void setUp() throws Exception {
        carSet = new CarHashSet();
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
        carSet.add(car);
        assertFalse(carSet.add(car));
        assertEquals(101, carSet.size());
    }

    @Test
    public void whenRemovedElement() {
        assertTrue(carSet.add(car));
        assertTrue(carSet.remove(car));
        assertEquals(100, carSet.size());

        assertTrue(carSet.remove(new Car("Brand0", 0)));
        assertEquals(99, carSet.size());
    }

    @Test
    public void whenRemovedNonExistentElement() {
        assertFalse(carSet.remove(new Car("Nothing", 0)));
        assertEquals(100, carSet.size());

        assertTrue(carSet.remove(new Car("Brand30", 30)));
        assertEquals(99, carSet.size());
        assertFalse(carSet.remove(new Car("Brand30", 30)));
        assertEquals(99, carSet.size());
    }

    @Test
    public void whenGetSize() {
        assertEquals(100, carSet.size());
    }

    @Test
    public void whenClear() {
        carSet.clear();
        assertEquals(0, carSet.size());
    }

}