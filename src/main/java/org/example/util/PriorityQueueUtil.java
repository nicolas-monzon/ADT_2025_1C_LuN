package org.example.util;

import org.example.model.DynamicPriorityQueue;
import org.example.model.PriorityQueue;

public class PriorityQueueUtil {

    private PriorityQueueUtil() {

    }

    public static PriorityQueue copy(PriorityQueue priorityQueue) {
        PriorityQueue aux = new DynamicPriorityQueue();
        PriorityQueue result = new DynamicPriorityQueue();

        while(!priorityQueue.isEmpty()) {
            aux.add(priorityQueue.getPriority(), priorityQueue.getFirst());
            result.add(priorityQueue.getPriority(), priorityQueue.getFirst());
            priorityQueue.remove();
        }

        while(!aux.isEmpty()) {
            priorityQueue.add(aux.getPriority(), aux.getFirst());
            aux.remove();
        }

        return result;
    }



}
