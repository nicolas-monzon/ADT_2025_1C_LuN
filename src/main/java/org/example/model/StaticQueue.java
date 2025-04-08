package org.example.model;

public class StaticQueue implements Queue {

    private static final int MAX_SIZE = 10000;

    private final int[] array;
    private int count;

    public StaticQueue() {
        array = new int[MAX_SIZE];
        count = 0;
    }

    @Override
    public void add(int a) {
        if(count == MAX_SIZE) {
            throw new RuntimeException("Queue is full");
        }

        array[count] = a;
        count++;
    }

    @Override
    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacía.");
        }

        for(int i = 0; i < count - 1; i++) {
            this.array[i] = array[i + 1];
        }
        count--;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int getFirst() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacía.");
        }
        return array[0];
    }
}
