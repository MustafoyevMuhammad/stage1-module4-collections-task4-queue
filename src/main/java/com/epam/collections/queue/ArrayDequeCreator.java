package com.epam.collections.queue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class ArrayDequeCreator extends PriorityQueue<String> {
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        ArrayDeque<Integer> list = new ArrayDeque<>();
        list.add(firstQueue.poll());
        list.add(firstQueue.poll());
        list.add(secondQueue.poll());
        list.add(secondQueue.poll());


        while(firstQueue.peek() != null){
            try{
                firstQueue.add(list.pollLast());
                list.add(firstQueue.remove());
                list.add(firstQueue.remove());


                secondQueue.add(list.pollLast());
                list.add(secondQueue.remove());
                list.add(secondQueue.remove());
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return list;
    }
}
