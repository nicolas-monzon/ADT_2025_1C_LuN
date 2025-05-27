package org.example.model.node;

public class ValueNode {

    private final int value;
    private ValueNode next;

    public ValueNode(int value, ValueNode next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public ValueNode getNext() {
        return next;
    }

    public void setNext(ValueNode next) {
        this.next = next;
    }
}
