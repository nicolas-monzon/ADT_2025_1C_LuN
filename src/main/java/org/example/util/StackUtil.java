package org.example.util;

import org.example.model.Stack;
import org.example.model.StaticStack;

public class StackUtil {

    private StackUtil() {

    }

    public static Stack copy(Stack stack) {
        Stack result = new StaticStack();
        Stack aux = new StaticStack();

        while(!stack.isEmpty()) {
            int top = stack.getTop();
            aux.add(top);
            stack.remove();
        }

        while(!aux.isEmpty()) {
            int top = aux.getTop();
            stack.add(top);
            result.add(top);
            aux.remove();
        }

        return result;
    }

    public static void print(Stack stack) {
        Stack copy = copy(stack);

        while(!copy.isEmpty()) {
            int top = copy.getTop();
            System.out.println(top);
            copy.remove();
        }
    }

    public static void bubbleSort(Stack stack) {
        int size = size(stack);
        for(int i = 0; i < size - 1; i++) {
            move(stack);
        }
    }

    public static int size(Stack stack) {
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

    private static void move(Stack stack) {
        if(stack == null) {
            return;
        }

        if(stack.isEmpty()) {
            return;
        }

        int top = stack.getTop();
        stack.remove();
        if(stack.isEmpty()) {
            stack.add(top);
            return;
        }

        int next = stack.getTop();
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

}
