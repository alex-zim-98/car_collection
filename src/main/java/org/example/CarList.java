package org.example;

public interface CarList {
    void add(Car car);
    void add(Car car, int index);
    boolean removeAt(int index);
    boolean remove(Car car);
    Car get(int index);
    int size();
    void clear();
}
