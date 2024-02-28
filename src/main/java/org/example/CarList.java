package org.example;

public interface CarList<T> extends CarCollector<T> {
    boolean add(T car);
    boolean add(T car, int index);
    boolean removeAt(int index);
    boolean remove(T car);
    T get(int index);
    int size();
    void clear();
}
