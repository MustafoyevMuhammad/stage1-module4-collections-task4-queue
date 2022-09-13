package com.epam.collections.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        List<Integer> response = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        LinkedList<Integer> temp = new LinkedList<>();


        for (int x = 1; x <= numberOfDishes; x++) {
            queue.offer(x);
        }

        while (queue.size() >= everyDishNumberToEat) {
            int count = 1;
            for (int y = 1; y <= everyDishNumberToEat; y++) {
                Integer n = queue.poll();
                if (n != null) {
                    if (count == everyDishNumberToEat) {
                        response.add(n);
                        count = 1;
                    } else {
                        temp.add(n);
                        count++;
                    }
                }
            }
            temp.addAll(0, queue);
            if (temp.size() == 3) {
                response.add(temp.pollFirst());
                response.add(temp.pollLast());
                response.add(temp.poll());
            }
            queue.clear();
            queue.addAll(temp);
            temp.clear();
        }
        return response;
    }
}
