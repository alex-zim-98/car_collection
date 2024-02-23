package org.example;

public class CarHashSet implements CarSet {
    public static final int INITIAL_CAPACITY = 16;
    private Entry[] arrays = new Entry[INITIAL_CAPACITY];
    private int size = 0;

    @Override
    public boolean add(Car car) {
        return false;
    }

    @Override
    public boolean remove(Car car) {
        return false;
    }

    private int getPosition(Car car, int arrayLength) {
        return Math.abs(car.hashCode() % arrayLength);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        arrays = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    private static class Entry {
        private Car value;
        private Entry next;

        public Entry(Car value, Entry next) {
            this.value = value;
            this.next = next;
        }
    }
}
