package org.example.model;

import org.example.model.node.Node;

public class LinkedList implements List {

    private Node node;
    private Node last;
    private int size;

    @Override
    public void add(int a) {
        if(node == null) {
            node = new Node(a, null);
            last = node;
            size++;
            return;
        }
        last.setNext(new Node(a, null));
        last = last.getNext();
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void remove() {
        if(node == null) {
            throw new RuntimeException("List is empty");
        }

        if(node.getNext() == null) {
            node = null;
            last = null;
            size--;
            return;
        }

        Node previous = node;
        Node current = node.getNext();
        while(current.getNext() != null) {
            previous = current;
            current = current.getNext();
        }

        previous.setNext(null);
        last = previous;
        size--;
    }

    @Override
    public int get(int index) {
        if(index < 0 || index >= size) {
            throw new RuntimeException("Index out of bounds");
        }
        if(node == null) {
            throw new RuntimeException("List is empty");
        }

        int count = 0;
        Node candidate = node;
        while(candidate != null) {
            if(count == index) {
                return candidate.getValue();
            }
            candidate = candidate.getNext();
            count++;
        }

        throw new RuntimeException("Unexcepted (?) index");
    }
}
