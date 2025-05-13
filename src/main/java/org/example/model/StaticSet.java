package org.example.model;

import java.util.Random;

public class StaticSet implements Set {

    private static final int MAX_SIZE = 8;
    private final int[] values;
    private int count;
    private Random random;

    public StaticSet() {
        random = new Random();
        values = new int[MAX_SIZE];
        count = 0;
    }

    @Override
    public void add(int a) {
        // O(C) + MAX{O(C), O(n)} ~> O(n)
        if(count == MAX_SIZE) {
            throw new RuntimeException("The set is full");
        }
        // instruccion inicial + condicion de corte + n*del cuerpo
        // O(C) + O(C) + n*(O(C)) ~> O(n)
        for(int i = 0; i < count; i++) {
            if(values[i] == a) {
                return;
            }
        }
        values[count++] = a;
    }

    @Override
    public void remove(int a) { // O(n)
        for(int i = 0; i < count; i++) {
            if(values[i] == a) {
                values[i] = values[count-1];
                count--;
                return;
            }
        }
    }

    @Override
    public int choose() {
        // Condicion + MAX(cuerpo del then, cuerpo del else)
        // O(C) + MAX{O(C), O(C)} ~> O(C)
        if(this.isEmpty()) {
            throw new RuntimeException("The set is empty");
        } else {
            int index = random.nextInt(count);
            return this.values[index];
        }
    }

    @Override
    public boolean isEmpty() { // O(C)
        return count == 0;
    }
}
