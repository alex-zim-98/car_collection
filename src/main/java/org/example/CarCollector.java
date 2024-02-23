package org.example;

public interface CarCollector {
    boolean add(Car car);
    boolean remove(Car car);
    boolean contains(Car car);
    int size();
    void clear();
}
