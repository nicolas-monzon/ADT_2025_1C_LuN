package org.example.model;

public class StaticBinaryTree implements BinaryTree {

    private static final int MAX_LEVEL = 10;
    private final Integer[] array;
    private final int root;
    private final int indexRoot;

    public StaticBinaryTree(int root) {
        this.array = new Integer[(int) Math.pow(2, MAX_LEVEL) - 1];
        this.root = root;
        this.indexRoot = 0;
    }

    private StaticBinaryTree(int indexRoot, Integer[] array) {
        this.array = array;
        this.root = array[indexRoot];
        this.indexRoot = indexRoot;
    }

    @Override
    public int getRoot() {
        return array[indexRoot];
    }

    @Override
    public BinaryTree getLeft() {
        if(2*indexRoot + 1 >= array.length) {
            return null;
        }
        if(array[2*indexRoot + 1] == null) {
            return null;
        }
        return new StaticBinaryTree(2*indexRoot + 1, array);
    }

    @Override
    public BinaryTree getRight() {
        if(2*indexRoot + 2 >= array.length) {
            return null;
        }
        if(array[2*indexRoot + 2] == null) {
            return null;
        }
        return new StaticBinaryTree(2*indexRoot + 2, array);
    }

    @Override
    public void addLeft(int a) {
        BinaryTree left = this.getLeft();
        if(left != null) {
            throw new RuntimeException("No se puede agregar el hijo izquierdo porque ya existe uno");
        }
        if(2*indexRoot + 1 >= array.length) {
            throw new RuntimeException("Index out of bounds");
        }
        array[2*indexRoot + 1] = a;
    }

    @Override
    public void addRight(int a) {
        BinaryTree right = this.getRight();
        if(right != null) {
            throw new RuntimeException("No se puede agregar el hijo derecho porque ya existe uno");
        }
        if(2*indexRoot + 2 >= array.length) {
            throw new RuntimeException("Index out of bounds");
        }
        array[2*indexRoot + 2] = a;
    }

    @Override
    public void removeLeft() {
        BinaryTree left = this.getLeft();
        if(left == null) {
            throw new RuntimeException("No se puede borrar el hijo izquierdo porque no existe");
        }
        if(2*indexRoot + 1 < array.length) {
            StaticBinaryTree temp = new StaticBinaryTree(2*indexRoot + 1, array);
            temp.removeLeft();
            temp.removeRight();
        }

        array[2*indexRoot + 1] = null;
    }

    @Override
    public void removeRight() {
        BinaryTree right = this.getRight();
        if(right == null) {
            throw new RuntimeException("No se puede borrar el hijo derecho porque no existe");
        }
        if(2*indexRoot + 2 < array.length) {
            StaticBinaryTree temp = new StaticBinaryTree(2*indexRoot + 2, array);
            temp.removeLeft();
            temp.removeRight();
        }

        array[2*indexRoot + 2] = null;
    }
}
