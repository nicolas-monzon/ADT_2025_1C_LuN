package org.example.model;

public class HashTable implements Table {

    private static final int SIZE = 1000;

    private final String[] values;

    public HashTable() {
        values = new String[SIZE];
    }

    @Override
    public void add(String key, String value) {
        if (key == null) {
            throw new RuntimeException("key is null");
        }
        values[key.hashCode() % SIZE] = value;
    }

    @Override
    public String get(String key) {
        if (key == null) {
            throw new RuntimeException("key is null");
        }
        return values[key.hashCode() % SIZE];
    }

    @Override
    public void remove(String key) {
        if (key == null) {
            throw new RuntimeException("key is null");
        }
        values[key.hashCode() % SIZE] = null;
    }
}
