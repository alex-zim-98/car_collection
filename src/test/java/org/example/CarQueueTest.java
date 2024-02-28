package org.example;

import org.junit.Before;
import org.junit.Test;

import java.util.Queue;

import static org.junit.Assert.*;

public class CarQueueTest {
    CarQueue carQueue;

    @Before
    public void setUp() throws Exception {
        // init
        for (int i = 0; i < 10; i++) {
            carQueue.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void add() {
        assertTrue(carQueue.add(new Car("Brand10", 10)));
        assertEquals(11, carQueue.size());
    }

    @Test
    public void peek() {
        Car expected = new Car("Brand0", 0);
        assertEquals(expected, carQueue.peek());
        assertEquals(10, carQueue.size());
    }

    @Test
    public void poll() {
        Car expected = new Car("Brand0", 0);
        assertEquals(expected, carQueue.poll());
        assertEquals(9, carQueue.size());
    }
}