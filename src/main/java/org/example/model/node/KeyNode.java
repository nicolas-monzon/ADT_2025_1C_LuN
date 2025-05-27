package org.example.model.node;

public class KeyNode {

    private int key;
    private ValueNode values;
    private KeyNode next;

    public KeyNode(int key, ValueNode values, KeyNode next) {
        this.key = key;
        this.values = values;
        this.next = next;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public ValueNode getValues() {
        return values;
    }

    public void setValues(ValueNode values) {
        this.values = values;
    }

    public KeyNode getNext() {
        return next;
    }

    public void setNext(KeyNode next) {
        this.next = next;
    }
}
