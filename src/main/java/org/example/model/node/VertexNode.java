package org.example.model.node;

public class VertexNode {

    private int value;
    private EdgeNode edgeNode;
    private VertexNode next;

    public VertexNode(int value, EdgeNode edgeNode, VertexNode next) {
        this.value = value;
        this.edgeNode = edgeNode;
        this.next = next;
    }

    public EdgeNode getEdgeNode() {
        return edgeNode;
    }

    public void setEdgeNode(EdgeNode edgeNode) {
        this.edgeNode = edgeNode;
    }

    public VertexNode getNext() {
        return next;
    }

    public void setNext(VertexNode next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
