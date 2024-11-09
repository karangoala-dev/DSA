package CollectionsFramework;

import java.util.*;

public class PriorityQueues {
    public static void main(String[] args) {
        Queue<Integer> pq = new PriorityQueue<>();
        //By default implements a min heap - ie - min element is always at top
        System.out.println("-------------------Min heap----------------------");
        System.out.println("-------------------offer - add a new element----------------------");
        pq.offer(10);
        pq.offer(30);
        pq.offer(15);
        System.out.println(pq);
        System.out.println("-------------------peek - view top element----------------------");
        System.out.println(pq.peek());

        System.out.println("-------------------poll - remove top element----------------------");
        pq.poll();
        System.out.println(pq);

        System.out.println("-------------------Max heap----------------------");
        //Max element is always at top
        Queue<Integer> pqMax = new PriorityQueue<>(Comparator.reverseOrder());
        System.out.println("-------------------offer - add a new element----------------------");
        pqMax.offer(10);
        pqMax.offer(30);
        pqMax.offer(15);
        System.out.println(pqMax);
        System.out.println("-------------------peek - view top element----------------------");
        System.out.println(pqMax.peek());

        System.out.println("-------------------poll - remove top element----------------------");
        pqMax.poll();
        System.out.println(pqMax);
    }
}
