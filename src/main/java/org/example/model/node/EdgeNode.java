package org.example.model.node;

public class EdgeNode {

    private VertexNode to;
    private int weight;
    private EdgeNode next;

    public EdgeNode(VertexNode to, int weight, EdgeNode next) {
        this.to = to;
        this.weight = weight;
        this.next = next;
    }

    public VertexNode getTo() {
        return to;
    }

    public void setTo(VertexNode to) {
        this.to = to;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public EdgeNode getNext() {
        return next;
    }

    public void setNext(EdgeNode next) {
        this.next = next;
    }
}
