package org.example.model;

import org.example.model.node.PriorityQueueNode;

public class DynamicPriorityQueue implements PriorityQueue {

    private PriorityQueueNode first;

    @Override
    public void add(int priority, int value) {
        if (isEmpty()) {
            first = new PriorityQueueNode(priority, value, null);
            return;
        }

        PriorityQueueNode current = first;
        while (current.getNext() != null) {
            current = current.getNext();
        }

        if (current.getPriority() <= priority) {
            current.setNext(new PriorityQueueNode(priority, value, null));
            return;
        }

        if (first.getPriority() > priority) {
            first = new PriorityQueueNode(priority, value, first);
            return;
        }

        if (first.getNext() == null) {
            return;
        }

        PriorityQueueNode prev = first;
        current = first.getNext();

        while (current.getNext() != null) {
            if (current.getPriority() > priority) {
                prev.setNext(new PriorityQueueNode(priority, value, current));
                return;
            }
            prev = current;
            current = current.getNext();
        }
        if (current.getPriority() > priority) {
            prev.setNext(new PriorityQueueNode(priority, value, current));
        }
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("Priority queue is empty");
        }
        first = first.getNext();
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Priority queue is empty");
        }
        return first.getValue();
    }

    @Override
    public int getPriority() {
        if (isEmpty()) {
            throw new RuntimeException("Priority queue is empty");
        }
        return first.getPriority();
    }
}
