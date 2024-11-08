package Collections;

import java.util.LinkedList;
import java.util.Queue;

public class Queues {
    public static void main(String[] args) {
        Queue<String> animals = new LinkedList<>();
        System.out.println("-------------------offer - add a new element----------------------");
        animals.offer("Lion");
        animals.offer("Dog");
        animals.offer("Cat");
        System.out.println(animals);
        System.out.println("-------------------peek - view top element----------------------");
        System.out.println(animals.peek());

        System.out.println("-------------------poll - remove top element----------------------");
        animals.poll();
        System.out.println(animals);
    }
}
