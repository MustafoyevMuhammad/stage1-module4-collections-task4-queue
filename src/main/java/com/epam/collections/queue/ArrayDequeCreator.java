package com.epam.collections.queue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class ArrayDequeCreator extends PriorityQueue<String> {
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        ArrayDeque<Integer> result = new ArrayDeque<>();

        result.add(firstQueue.poll());
        result.add(firstQueue.poll());
        result.add(secondQueue.poll());
        result.add(secondQueue.poll());

        while (firstQueue.peek() != null) {
            try {
                firstQueue.add(result.pollLast());
                result.addLast(firstQueue.remove());
                result.addLast(firstQueue.remove());

                secondQueue.add(result.pollLast());
                result.addLast(secondQueue.remove());
                result.addLast(secondQueue.remove());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
