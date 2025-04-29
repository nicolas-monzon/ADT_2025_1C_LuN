package org.example.util;

import org.example.model.DynamicPriorityQueue;
import org.example.model.PriorityQueue;
import org.example.model.Stack;
import org.example.model.StaticStack;

public class StackUtil {

    private StackUtil() {

    }

    public static Stack<Integer> copy(Stack<Integer> stack) {
        Stack<Integer> result = new StaticStack();
        Stack<Integer> aux = new StaticStack();

        while(!stack.isEmpty()) {
            Integer top = stack.getTop();
            aux.add(top);
            stack.remove();
        }

        while(!aux.isEmpty()) {
            Integer top = aux.getTop();
            stack.add(top);
            result.add(top);
            aux.remove();
        }

        return result;
    }

    public static void print(Stack<Integer> stack) {
        Stack<Integer> copy = copy(stack);

        while(!copy.isEmpty()) {
            Integer top = copy.getTop();
            System.out.println(top);
            copy.remove();
        }
    }

    public static void bubbleSort(Stack<Integer> stack) {
        int size = size(stack);
        for(int i = 0; i < size - 1; i++) {
            move(stack);
        }
    }

    public static int size(Stack<Integer> stack) {
        if (stack == null) {
            return 0;
        }

        if (stack.isEmpty()) {
            return 0;
        }

        int top = stack.getTop();
        stack.remove();
        int size = size(stack);
        stack.add(top);
        return 1 + size;
    }

    private static void move(Stack<Integer> stack) {
        if(stack == null) {
            return;
        }

        if(stack.isEmpty()) {
            return;
        }

        Integer top = stack.getTop();
        stack.remove();
        if(stack.isEmpty()) {
            stack.add(top);
            return;
        }

        Integer next = stack.getTop();
        stack.remove();
        if(top > next) {
            stack.add(top);
            move(stack);
            stack.add(next);
            return;
        }

        stack.add(next);
        move(stack);
        stack.add(top);
    }

    public static void sort(Stack<Integer> stack) {
        PriorityQueue priorityQueue = new DynamicPriorityQueue();

        while(!stack.isEmpty()) {
            priorityQueue.add(stack.getTop(), 1);
            stack.remove();
        }

        while(!priorityQueue.isEmpty()) {
            stack.add(priorityQueue.getPriority());
            priorityQueue.remove();
        }
    }

}
