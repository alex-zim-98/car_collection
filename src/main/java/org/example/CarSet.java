package org.example;

public interface CarSet<T> extends CarCollector<T> {
    boolean add(T car);
    boolean remove(T car);
    int size();
    void clear();
}
