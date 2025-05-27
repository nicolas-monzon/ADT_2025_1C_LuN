package org.example.model;

import org.example.util.SetUtil;

import java.util.Random;

public class StaticSetOfSets implements SetOfSets {

    private static final int MAX_SIZE = 8;
    private final Set[] values;
    private int count;
    private final Random random;

    public StaticSetOfSets() {
        random = new Random();
        values = new Set[MAX_SIZE];
        count = 0;
    }

    @Override
    public void add(Set a) {
        if(count == MAX_SIZE) {
            throw new RuntimeException("The set is full");
        }
        if(a == null) {
            throw new RuntimeException("The set cannot be null");
        }
        for(int i = 0; i < count; i++) {
            if(SetUtil.equals(values[i], a)) {
                return;
            }
        }
        values[count++] = a;
    }

    @Override
    public void remove(Set a) {
        for(int i = 0; i < count; i++) {
            if(SetUtil.equals(values[i], a)) {
                values[i] = values[count-1];
                count--;
                return;
            }
        }
    }

    @Override
    public Set choose() {
        if(this.isEmpty()) {
            throw new RuntimeException("The set is empty");
        }
        int index = random.nextInt(count);
        return this.values[index];
    }

    @Override
    public boolean isEmpty() { // O(C)
        return count == 0;
    }
}
