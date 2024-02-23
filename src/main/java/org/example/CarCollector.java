package org.example;

public interface CarCollector extends Iterable<Car> {
    boolean add(Car car);
    boolean remove(Car car);
    boolean contains(Car car);
    int size();
    void clear();
}
