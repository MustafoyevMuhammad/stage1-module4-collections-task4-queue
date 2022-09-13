package com.epam.collections.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= numberOfDishes; i++) {
            queue.add(i);
        }
        List<Integer> list = new ArrayList<>();
        Queue<Integer> temp = new ArrayDeque<>();
        int i = 1;
        while (!queue.isEmpty()){
            while (!queue.isEmpty()) {
                if (i % everyDishNumberToEat == 0) {
                    list.add(queue.poll());//3 6 9
                } else
                    temp.add(queue.poll());//1 2 4 5 7 8 10
                i++;
            }
            i = 1;
            queue = temp;
        }//1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        //3, 6, 9, 2, 7, 1, 8, 5, 10, 4
        return list;
    }
}
