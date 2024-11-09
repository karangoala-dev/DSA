package CollectionsFramework;

import java.util.*;

public class ArrayDeques {
    public static void main(String[] args) {
        ArrayDeque<String> adq = new ArrayDeque<>();

        System.out.println("-------------------offer - add a new element----------------------");
        adq.offer("Lion");
        adq.offer("Dog");
        adq.offer("Cat");
        System.out.println(adq);
        System.out.println("-------------------peek - view top element----------------------");
        System.out.println(adq.peek());

        System.out.println("-------------------poll - remove top element----------------------");
        adq.poll();
        System.out.println(adq);

        System.out.println("-------------------offerFirst(), offerLast(), pollFirst(), pollLast(), peekFirst(), peekLast()----------------------");
    }
}
