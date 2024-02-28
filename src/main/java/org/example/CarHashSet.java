package org.example;

import java.util.Iterator;

public class CarHashSet<T> implements CarSet<T> {
    public static final int INITIAL_CAPACITY = 16;
    public static final double LOAD_FACTOR = 0.75;
    private Object[] arrays = new Object[INITIAL_CAPACITY];
    private int size = 0;

    @Override
    public boolean add(T car) {
        increaseArray();
        boolean isAdded = add(car, arrays);
        if (isAdded) {
            size++;
            return true;
        }

        return false;
    }


    public boolean add(T car, Object[] dst) {
        int position = getPosition(car, dst.length);
        if (dst[position] == null) {
            dst[position] = new Entry(car, null);
            return true;
        }
        Entry existedElement = (Entry) dst[position];
        if (existedElement.value.equals(car))
            return false;

        while (true) {
            if (existedElement.value.equals(car))
                return false;
            else if (existedElement.next == null) {
                existedElement.next = new Entry(car, null);
                return true;
            } else {
                existedElement = existedElement.next;
            }
        }
    }

    private void increaseArray() {
        if (size >= (arrays.length * LOAD_FACTOR)) {
            Object[] newArray = new Object[arrays.length * 2];
            for (Object entry : arrays) {
                Entry existedEntry = (Entry) entry;
                while (existedEntry != null) {
                    add(existedEntry.value, newArray);
                    existedEntry = existedEntry.next;
                }
            }
            arrays = newArray;
        }
    }

    @Override
    public boolean remove(T car) {
        int position = getPosition(car, arrays.length);
        if (arrays[position] == null) {
            return false;
        }
        Entry secondLast = (Entry) arrays[position];
        Entry lastElement = secondLast.next;
        if (secondLast.value.equals(car)) {
            arrays[position] = lastElement;
            size--;
            return true;
        }


        while (lastElement != null) {
            if (lastElement.value.equals(car)) {
                secondLast.next = lastElement.next;
                size--;
                return true;
            } else {
                secondLast = lastElement;
                lastElement = lastElement.next;
            }
        }
        return false;
    }

    @Override
    public boolean contains(T car) {
        int position = getPosition(car, arrays.length);
        Entry entry = (Entry) arrays[position];
        while (entry != null) {
            if (entry.value.equals(car)) {
                return true;
            }
            entry = entry.next;
        }
        return false;
    }

    private int getPosition(T car, int arrayLength) {
        return Math.abs(car.hashCode() % arrayLength);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        arrays = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            int arrayIndex = 0;
            Entry entry;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                while (arrays[arrayIndex] == null) {
                    arrayIndex++;
                }
                if (entry == null) {
                    entry = (Entry) arrays[arrayIndex];
                }
                T result = entry.value;
                entry = entry.next;
                if (entry == null) {
                    arrayIndex++;
                }
                index++;
                return result;
            }
        };
    }

    private class Entry {
        private T value;
        private Entry next;

        public Entry(T value, Entry next) {
            this.value = value;
            this.next = next;
        }
    }
}
