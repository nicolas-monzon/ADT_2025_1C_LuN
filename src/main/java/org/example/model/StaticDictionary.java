package org.example.model;

public class StaticDictionary implements Dictionary {

    private static final int MAX = 10000;

    private final int[] keys;
    private final int[] values;
    private int count;

    public StaticDictionary() {
        keys = new int[MAX];
        values = new int[MAX];
    }

    @Override
    public void add(int key, int value) {
        for(int i = 0; i < count; i++) {
            if(keys[i] == key) {
                if(values[i] != value) {
                    throw new RuntimeException("Duplicate key");
                }
                return;
            }
        }
        keys[count] = key;
        values[count] = value;
        count++;
    }

    @Override
    public int get(int key) {
        for(int i = 0; i < count; i++) {
            if(keys[i] == key) {
                return values[i];
            }
        }
        throw new RuntimeException("No such key");
    }

    @Override
    public void remove(int key, int value) {
        for(int i = 0; i < count; i++) {
            if(keys[i] == key) {
                if(values[i] == value) {
                    keys[i] = keys[count - 1];
                    values[i] = values[count - 1];
                    count--;
                }
                return;
            }
        }
    }

    @Override
    public Set getKeys() {
        Set set = new StaticSet();

        for(int i = 0; i < count; i++) {
            set.add(keys[i]);
        }

        return set;
    }
}
