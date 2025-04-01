package org.example.util;

import org.example.model.Stack;
import org.example.model.StaticStack;

public class StackUtil {

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

}
