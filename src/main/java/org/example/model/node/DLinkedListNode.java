package org.example.model.node;

public class DLinkedListNode {

    private int value;
    private DLinkedListNode next;
    private DLinkedListNode prev;

    public DLinkedListNode(int value, DLinkedListNode next, DLinkedListNode prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public DLinkedListNode getNext() {
        return next;
    }

    public void setNext(DLinkedListNode next) {
        this.next = next;
    }

    public DLinkedListNode getPrev() {
        return prev;
    }

    public void setPrev(DLinkedListNode prev) {
        this.prev = prev;
    }
}
