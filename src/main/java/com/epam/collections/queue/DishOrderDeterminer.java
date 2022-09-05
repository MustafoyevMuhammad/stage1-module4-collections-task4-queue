package com.epam.collections.queue;

import java.util.*;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        List<Integer> response = new LinkedList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>(); //11 блюд
        for (int x = 1; x <= numberOfDishes; x++) {
            queue.offer(x);
        }


 for (int x = 0; x < queue.size(); x++) {
     Integer first = queue.poll();
     Integer second = queue.poll();
     Integer third = queue.poll();

     if (first != null && second != null && third != null) {
         response.add(third);
     } else if (third == null) {
         queue.addFirst(second);
         queue.addFirst(first);
     } else if (second == null) {
         queue.addFirst(first);
     } else if (queue.size() == 2) {
         response.add(queue.pollLast());
         response.add(queue.pollLast());
     }
        }






        return response;
    }//4, 8, 1, 6, 11, 7, 3, 2, 5, 10, 9

    public static void main(String[] args) {
        DishOrderDeterminer a = new DishOrderDeterminer();
        List<Integer> res = a.determineDishOrder(11, 4);
        System.out.println(res);

    }
}



