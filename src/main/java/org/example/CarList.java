package org.example;

public interface CarList extends CarCollector {
    boolean add(Car car);
    boolean add(Car car, int index);
    boolean removeAt(int index);
    boolean remove(Car car);
    Car get(int index);
    int size();
    void clear();
}
