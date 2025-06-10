package org.example.model;

public class DynamicSearchBinaryTree implements SearchBinaryTree {

    private BinaryTree binaryTree;

    public DynamicSearchBinaryTree(int root) {
        this.binaryTree = new DynamicBinaryTree(root);
    }

    private DynamicSearchBinaryTree(BinaryTree binaryTree) {
        this.binaryTree = binaryTree;
    }

    @Override
    public int getRoot() {
        return this.binaryTree.getRoot();
    }

    @Override
    public SearchBinaryTree getLeft() {
        return new DynamicSearchBinaryTree(this.binaryTree.getLeft());
    }

    @Override
    public SearchBinaryTree getRight() {
        return new DynamicSearchBinaryTree(this.binaryTree.getRight());
    }

    @Override
    public void add(int a) {
        if (a == this.binaryTree.getRoot()) {
            return;
        }
        if (a < this.binaryTree.getRoot()) {
            if (this.binaryTree.getLeft() == null) {
                this.binaryTree.addLeft(a);
                return;
            }
            this.getLeft().add(a);
            return;
        }
        if (this.binaryTree.getRight() == null) {
            this.binaryTree.addRight(a);
            return;
        }
        this.getRight().add(a);
    }

    @Override
    public void removeLeft() {
        this.binaryTree.removeLeft();
    }

    @Override
    public void removeRight() {
        this.binaryTree.removeRight();
    }
}
