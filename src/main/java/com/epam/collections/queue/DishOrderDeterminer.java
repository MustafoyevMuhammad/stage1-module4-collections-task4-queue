package com.epam.collections.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DishOrderDeterminer {

    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
                List<Integer> response = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        LinkedList<Integer> temp = new LinkedList<>();


        for (int x = 1; x <= numberOfDishes; x++) {
            queue.offer(x);
        }
//queue
//1, 2, 3, 4, 5, 6, 7, 8, 9, 10
//4, 5, 6, 7, 8, 9, 10, 1, 2
//10, 1, 2, 4, 5, 7, 8
//4, 5, 7, 8, 10, 1
//8, 10, 1, 4, 5
        //...
        while (queue.size() >= everyDishNumberToEat) {
            int count = 1;
            for (int y = 1; y <= everyDishNumberToEat; y++) {
                Integer n = queue.poll();
                if (n != null) {
                    if (count == everyDishNumberToEat) {
                        response.add(n);//3 ; 6 ; 9 ; 2 ; 7
                        count = 1;
                    } else {
                        temp.add(n);//1 2 ; 4 5 ; 7 8 ; 10  1 ; 4 5 ;
                        count++;
                    }
                }
            }
            temp.addAll(0, queue);
            //4, 5, 6, 7, 8, 9, 10, 1, 2
            //7, 8, 9, 10, 1, 2, 4, 5
            //10, 1, 2, 4, 5, 7, 8
            //4, 5, 7, 8, 10, 1
            //8, 10, 1, 4, 5
            if (temp.size() == 3) {
                response.add(temp.pollFirst());
                response.add(temp.pollLast());
                response.add(temp.poll());
            }
            queue.clear();//null ; null ; null ...
            queue.addAll(temp);
            //4, 5, 6, 7, 8, 9, 10, 1, 2
            //7, 8, 9, 10, 1, 2, 4, 5
            //10, 1, 2, 4, 5, 7, 8
            //4, 5, 7, 8, 10, 1
            //8, 10, 1, 4, 5
            temp.clear();//null ...
        }
        return response;
    }
}



