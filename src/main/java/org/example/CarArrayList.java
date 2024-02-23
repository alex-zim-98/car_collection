package org.example;

import java.util.Arrays;
import java.util.Iterator;

public class CarArrayList implements CarList {
    private Car[] array = new Car[10];
    private int size = 0;

    @Override
    public boolean add(Car car) {
        increaseArray();
        array[size] = car;
        size++;
        return true;
    }

    @Override
    public boolean add(Car car, int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        increaseArray();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = car;
        size++;
        return true;
    }

    private void increaseArray() {
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        System.arraycopy(array, index + 1, array, index, size - 1 - index);
        size--;
        return true;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean remove(Car car) {
        int position = findElement(car);
        if (position != -1)
            return removeAt(position);
        return false;
    }

    @Override
    public boolean contains(Car car) {
        return findElement(car) != -1;
    }

    private int findElement(Car car) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(car))
                return i;
        }
        return -1;
    }

    @Override
    public Car get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Car[10];
        size = 0;
    }

    @Override
    public Iterator<Car> iterator() {
        return new Iterator<Car>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Car next() {
                return get(index++);
            }
        };
    }
}
