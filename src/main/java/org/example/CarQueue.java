package org.example;

public interface CarQueue extends CarCollector {
    boolean add(Car car);
    Car peek();
    Car poll();
}
