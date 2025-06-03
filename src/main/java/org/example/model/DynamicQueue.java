package org.example.model;

import org.example.model.node.Node;

public class DynamicQueue implements Queue {

    private Node first;

    @Override
    public void add(int a) {
        if (this.isEmpty()) {
            this.first = new Node(a, null);
            return;
        }

        Node candidate = first;
        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
        }

        candidate.setNext(new Node(a, null));
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacía.");
        }

        if (this.first.getNext() == null) {
            this.first = null;
            return;
        }

        this.first = this.first.getNext();
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public int getFirst() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacía.");
        }
        return this.first.getValue();
    }
}
