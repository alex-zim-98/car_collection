package org.example;

public class CarLinkedList implements CarList {
    private Node first;
    private Node last;

    private int size = 0;

    @Override
    public void add(Car car) {

    }

    @Override
    public void add(Car car, int index) {

    }

    @Override
    public boolean removeAt(int index) {
        return false;
    }

    @Override
    public boolean remove(Car car) {
        return false;
    }

    @Override
    public Car get(int index) {
        return getNode(index).value;
    }

    private Node getNode(int index) {
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

    private static class Node {
        private Node next;
        private Car value;
        private Node previous;

        public Node(Node next, Car value, Node previous) {
            this.next = next;
            this.value = value;
            this.previous = previous;
        }
    }
}
