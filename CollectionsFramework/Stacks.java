package CollectionsFramework;

import java.util.Stack;

public class Stacks {
    public static void main(String[] args) {
        System.out.println("-------------------push - add a new element----------------------");
        Stack<String> animals = new Stack<>();
        animals.push("Dog");
        animals.push("Lion");
        animals.push("Cat");

        System.out.println(animals);

        System.out.println("--------------------peek - view top element---------------------");
        System.out.println(animals.peek());

        System.out.println("--------------------pop - remove top element---------------------");
        animals.pop();
        System.out.println(animals);
    }
}
