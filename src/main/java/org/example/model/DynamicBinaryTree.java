package org.example.model;

public class DynamicBinaryTree implements BinaryTree {

    private BinaryTree left;
    private BinaryTree right;
    private final int root;

    public DynamicBinaryTree(int root) {
        this.root = root;
    }

    @Override
    public int getRoot() {
        return this.root;
    }

    @Override
    public BinaryTree getLeft() {
        return left;
    }

    @Override
    public BinaryTree getRight() {
        return right;
    }

    @Override
    public void addLeft(int a) {
        if(left != null) {
            throw new RuntimeException("No se puede agregar el hijo izquierdo porque ya existe uno");
        }
        left = new DynamicBinaryTree(a);
    }

    @Override
    public void addRight(int a) {
        if(right != null) {
            throw new RuntimeException("No se puede agregar el hijo derecho porque ya existe uno");
        }
        right = new DynamicBinaryTree(a);
    }

    @Override
    public void removeLeft() {
        if(left == null) {
            throw new RuntimeException("No se puede borrar el hijo izquierdo porque no existe");
        }
        left = null;
    }

    @Override
    public void removeRight() {
        if(right == null) {
            throw new RuntimeException("No se puede borrar el hijo derecho porque no existe");
        }
        right = null;
    }
}
