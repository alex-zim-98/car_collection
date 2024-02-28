package org.example;

public interface CarQueue<T> extends CarCollector<T> {
    boolean add(T car);
    T peek();
    T poll();
}
