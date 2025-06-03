package org.example.model;

import org.example.model.node.Node;

import java.util.Random;

public class DynamicSet implements Set {

    private final Random random;
    private Node node;
    private int size;

    public DynamicSet() {
        random = new Random();
    }

    @Override
    public void add(int a) {
        if (this.isEmpty()) {
            node = new Node(a, null);
            size++;
            return;
        }

        Node current = node;
        while (current.getNext() != null) {
            if (current.getValue() == a) {
                return;
            }
            current = current.getNext();
        }
        if (current.getValue() == a) {
            return;
        }
        current.setNext(new Node(a, null));
        size++;
    }

    @Override
    public void remove(int a) {
        if (this.isEmpty()) {
            return;
        }

        if (this.node.getValue() == a) {
            this.node = this.node.getNext();
            size--;
            return;
        }

        if (this.node.getNext() == null) {
            return;
        }

        Node before = this.node;
        Node current = this.node.getNext();
        while (current.getNext() != null) {
            if (a == current.getValue()) {
                before.setNext(current.getNext());
                size--;
                return;
            }
            before = current;
            current = current.getNext();
        }
        if (a == current.getValue()) {
            before.setNext(current.getNext());
            size--;
        }
    }

    @Override
    public int choose() {
        if (this.isEmpty()) {
            throw new RuntimeException("The set is empty");
        }
        int index = random.nextInt(size);

        int i = 0;
        Node current = this.node;
        while (current != null) {
            if (index == i) {
                return current.getValue();
            }
            i++;
            current = current.getNext();
        }
        throw new RuntimeException("");
    }

    @Override
    public boolean isEmpty() {
        return this.node == null;
    }
}
