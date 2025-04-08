package org.example.model;

public class AlternativeStaticQueue implements Queue {

    private static final int MAX_SIZE = 10000;

    private final int[] array;
    private int count;

    public AlternativeStaticQueue() {
        array = new int[MAX_SIZE];
        count = 0;
    }

    @Override
    public void add(int a) {
        if(count == MAX_SIZE) {
            throw new RuntimeException("Queue is full");
        }

        for(int i = count; i > 0; i--) {
            array[i] = array[i - 1];
        }

        array[0] = a;
        count++;
    }

    @Override
    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacía.");
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
        return array[count - 1];
    }
}
