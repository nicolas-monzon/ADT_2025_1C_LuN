package org.example.model;

public class StaticStack implements Stack<Integer> {

    private static final int MAX_SIZE = 10000;

    private final Integer[] array;
    private int count;

    // Terms Rewriting System -> TeReSe

    public StaticStack() { // C_1 + C_2 + C_3 + C_4 + C_5 entonces la complejidad es O(1)
        array = new Integer[MAX_SIZE];
        count = 0;
    }

    @Override
    public void add(Integer a) {
        if(count == MAX_SIZE) {
            throw new RuntimeException("Stack is full");
        }
        array[count] = a;
        count++;
    }

    @Override
    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar una pila vacía.");
        }
        count--;
    }

    @Override
    public Integer getTop() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope de una pila vacía.");
        }
        return this.array[count - 1];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }
}
