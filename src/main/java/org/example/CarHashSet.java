package org.example;

public class CarHashSet implements CarSet {
    public static final int INITIAL_CAPACITY = 16;
    public static final double LOAD_FACTOR = 0.75;
    private Entry[] arrays = new Entry[INITIAL_CAPACITY];
    private int size = 0;

    @Override
    public boolean add(Car car) {
        increaseArray();
        boolean isAdded = add(car, arrays);
        if (isAdded) {
            size++;
            return true;
        }

        return false;
    }


    public boolean add(Car car, Entry[] dst) {
        int position = getPosition(car, dst.length);
        if (dst[position] == null) {
            dst[position] = new Entry(car, null);
            return true;
        }
        Entry existedElement = dst[position];
        if (existedElement.value.equals(car))
            return false;

        while (true) {
            if (existedElement.value.equals(car))
                return false;
            else if (existedElement.next == null) {
                existedElement.next = new Entry(car, null);
                return true;
            }
            else {
                existedElement = existedElement.next;
            }
        }
    }

    private void increaseArray() {
        if (size >= (arrays.length * LOAD_FACTOR)) {
            Entry[] newArray = new Entry[arrays.length * 2];
            for (Entry entry: arrays) {
                while (entry != null) {
                    add(entry.value, newArray);
                    entry = entry.next;
                }
            }
            arrays = newArray;
        }
    }

    @Override
    public boolean remove(Car car) {
        int position = getPosition(car, arrays.length);
        if (arrays[position] == null) {
            return false;
        }
        Entry secondLast = arrays[position];
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
            }  else {
                secondLast = lastElement;
                lastElement = lastElement.next;
            }
        }
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
