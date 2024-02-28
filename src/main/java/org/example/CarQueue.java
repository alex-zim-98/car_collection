package org.example;

public interface CarQueue {
    boolean add(Car car);
    Car peek();
    Car poll();
}
