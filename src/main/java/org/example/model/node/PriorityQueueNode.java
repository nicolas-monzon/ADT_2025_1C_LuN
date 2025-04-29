package org.example.model.node;

public class PriorityQueueNode {

    private int priority;
    private int value;
    private PriorityQueueNode next;

    public PriorityQueueNode(int priority, int value, PriorityQueueNode next) {
        this.priority = priority;
        this.value = value;
        this.next = next;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    public PriorityQueueNode getNext() {
        return next;
    }

    public void setNext(PriorityQueueNode next) {
        this.next = next;
    }
}
