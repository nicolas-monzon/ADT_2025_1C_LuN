package org.example.model;

public interface SearchBinaryTree {

    int getRoot();
    SearchBinaryTree getLeft();
    SearchBinaryTree getRight();
    void add(int a);

    void removeLeft();
    void removeRight();

}
