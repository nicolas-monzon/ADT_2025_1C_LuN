package org.example.model;

public interface Dictionary {

    void add(int key, int value);
    int get(int key);
    void remove(int key, int value);
    Set getKeys();

}
