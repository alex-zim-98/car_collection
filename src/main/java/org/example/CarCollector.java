package org.example;

public interface CarCollector<T> extends Iterable<T> {
    boolean add(T car);
    boolean remove(T car);
    boolean contains(T car);
    int size();
    void clear();
}
