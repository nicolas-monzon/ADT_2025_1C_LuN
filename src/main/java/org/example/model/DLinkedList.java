package org.example.model;

import org.example.model.node.DLinkedListNode;

public class DLinkedList implements List {

    private DLinkedListNode node;
    private DLinkedListNode last;
    private int size;

    @Override
    public void add(int a) {
        if(node == null) {
            node = new DLinkedListNode(a, null, null);
            last = node;
            size++;
            return;
        }
        last.setNext(new DLinkedListNode(a, null, last));
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

        DLinkedListNode current = node.getNext();
        while(current.getNext() != null) {
            current = current.getNext();
        }

        DLinkedListNode prev = current.getPrev();
        prev.setNext(null);
        last = prev;
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
        DLinkedListNode candidate = node;
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
