package org.example.model;

import org.example.model.node.Node;

public class DynamicStack implements Stack<Integer> {

    private Node top;

    @Override
    public void add(Integer a) {
        top = new Node(a, top);
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar una pila vacía.");
        }
        top = top.getNext();
    }

    @Override
    public Integer getTop() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope de una pila vacía.");
        }
        return this.top.getValue();
    }

    @Override
    public boolean isEmpty() {
        return this.top == null;
    }
}
