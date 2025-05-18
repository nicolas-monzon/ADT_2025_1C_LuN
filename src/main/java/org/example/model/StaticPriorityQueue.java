package org.example.model;

public class StaticPriorityQueue implements PriorityQueue {

    private static final int MAX_SIZE = 10000;
    private final int[] values;
    private final int[] priorities;
    private int count;

    public StaticPriorityQueue() {
        values = new int[MAX_SIZE];
        priorities = new int[MAX_SIZE];
        count = 0;
    }

    @Override
    public void add(int priority, int value) {
        if(isEmpty()) {
            values[0] = value;
            priorities[0] = priority;
            count++;
            return;
        }

        if(count == MAX_SIZE) {
            throw new RuntimeException("Priority queue is full");
        }

        if(priority >= priorities[count - 1]) {
            values[count] = value;
            priorities[count] = priority;
            count++;
            return;
        }

        if(priority < priorities[0]) {
            for(int i = count; i > 0; i--) {
                values[i] = values[i - 1];
                priorities[i] = priorities[i - 1];
            }
            values[0] = value;
            priorities[0] = priority;
            count++;
            return;
        }

        int index;
        for(index = 1; index <= count; index++) {
            if(priorities[index] > priority) {
                break;
            }
        }

        for(int i = count; i > index; i--) {
            values[i] = values[i - 1];
            priorities[i] = priorities[i - 1];
        }

        values[index] = value;
        priorities[index] = priority;
        count++;
    }

    @Override
    public void remove() {
        if(isEmpty()) {
            throw new RuntimeException("Priority queue is empty");
        }
        for(int i = count; i > 0; i--) {
            values[i] = values[i - 1];
            priorities[i] = priorities[i - 1];
        }
        count--;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int getFirst() {
        if(isEmpty()) {
            throw new RuntimeException("Priority queue is empty");
        }
        return values[0];
    }

    @Override
    public int getPriority() {
        if(isEmpty()) {
            throw new RuntimeException("Priority queue is empty");
        }
        return priorities[0];
    }
}
