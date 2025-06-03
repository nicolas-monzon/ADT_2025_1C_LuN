package org.example.model;

public class StaticStringStack implements Stack<String> {

    private static final int MAX_SIZE = 10000;

    private final String[] array;
    private int count;

    public StaticStringStack() {
        array = new String[MAX_SIZE];
        count = 0;
    }

    @Override
    public void add(String a) {
        if (count == MAX_SIZE) {
            throw new RuntimeException("Stack is full");
        }
        array[count] = a;
        count++;
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar una pila vacía.");
        }
        count--;
    }

    @Override
    public String getTop() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope de una pila vacía.");
        }
        return this.array[count - 1];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }
}
