package org.example.model.node;

import org.example.model.BinaryTree;

public class BQNode {

    private final BinaryTree value;
    private BQNode next;

    public BQNode(BinaryTree value, BQNode next) {
        this.value = value;
        this.next = next;
    }

    public BinaryTree getValue() {
        return value;
    }

    public BQNode getNext() {
        return next;
    }

    public void setNext(BQNode next) {
        this.next = next;
    }
}
