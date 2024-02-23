package org.example;

import java.util.Iterator;

public class CarLinkedList implements CarList {
    private Node first;
    private Node last;

    private int size = 0;

    @Override
    public boolean add(Car car) {
        if (size == 0) {
            first = new Node(null, car, null);
            last = first;
        } else {
            Node secondLast = last;
            last = new Node(secondLast, car, null);
            secondLast.next = last;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(Car car, int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        Node nextNode = getNode(index);
        Node previousNode = nextNode.previous;
        Node newNode = new Node(previousNode, car, nextNode);
        nextNode.previous = newNode;
        if (previousNode != null) {
            previousNode.next = newNode;
        } else {
            first = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean removeAt(int index) {
        Node node = getNode(index);
        Node nextNode = node.next;
        Node previousNode = node.previous;
        if (nextNode != null) {
            nextNode.previous = previousNode;
        } else {
            last = previousNode;
        }

        if (previousNode != null) {
            previousNode.next = nextNode;
        } else {
            first = nextNode;
        }

        size--;
        return true;
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
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(car))
                return i;
            node = node.next;
        }
        return -1;
    }

    @Override
    public Car get(int index) {
        return getNode(index).value;
    }

    private Node getNode(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public Iterator<Car> iterator() {
        return new Iterator<Car>() {
            Node node = first;
            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public Car next() {
                Car car = node.value;
                node = node.next;
                return car;
            }
        };
    }

    private static class Node {
        private Node previous;
        private Car value;
        private Node next;

        public Node(Node previous, Car value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
}
