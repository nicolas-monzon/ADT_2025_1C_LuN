package org.example.model;

public interface BinaryTree {

    int getRoot();
    BinaryTree getLeft();
    BinaryTree getRight();
    void addLeft(int a);
    void addRight(int a);

    void removeLeft();
    void removeRight();

}
