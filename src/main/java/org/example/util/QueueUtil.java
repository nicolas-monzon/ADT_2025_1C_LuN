package org.example.util;

import org.example.model.Queue;
import org.example.model.StaticQueue;

public class QueueUtil {

    private QueueUtil() {

    }

    public static void revert(Queue queue) {
        if(queue == null) {
            return;
        }

        if(queue.isEmpty()) {
            return;
        }

        int first = queue.getFirst();
        queue.remove();
        revert(queue);
        queue.add(first);
    }

    public static Queue copy(Queue queue) {
        Queue result = new StaticQueue();
        Queue aux = new StaticQueue();

        while(!queue.isEmpty()) {
            int first = queue.getFirst();
            aux.add(first);
            queue.remove();
        }

        while(!aux.isEmpty()) {
            int first = aux.getFirst();
            queue.add(first);
            result.add(first);
            aux.remove();
        }

        return result;
    }

    public static void print(Queue queue) {
        Queue copy = copy(queue);
        printAux(copy);
    }

    private static void printAux(Queue queue) {
        if(queue == null) {
            System.out.println("null");
            return;
        }

        String aux = "";

        if(queue.isEmpty()) {
            System.out.println();
            return;
        }

        while(!queue.isEmpty()) {
            int first = queue.getFirst();

            aux = aux + ", " + first;

            queue.remove();
        }

        System.out.println(aux.substring(2));
    }

}
