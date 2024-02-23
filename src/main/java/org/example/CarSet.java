package org.example;

public interface CarSet extends CarCollector {
    boolean add(Car car);
    boolean remove(Car car);
    int size();
    void clear();
}
