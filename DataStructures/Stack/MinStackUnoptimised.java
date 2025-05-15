package DataStructures.Stack;

import java.util.Stack;

//Unoptimised for space complexity
public class MinStackUnoptimised {
    public static class Pair{
        int val;
        int min;
        Pair(int _v, int _m){
            this.val = _v;
            this.min = _m;
        }
    }

    private static Stack<Pair> minStack = new Stack<>();
    static int minSoFar = Integer.MAX_VALUE;

    public static void add(int num){
        if(num < minSoFar){
            minSoFar = num;
        }
        minStack.add(new Pair(num, minSoFar));
    }

    public static int getMin(){
        Pair top = minStack.peek();
        return top.min;
    }

    public static int popMin(){
        Pair top = minStack.pop();
        return top.min;
    }

    public static void main(String[] args) {
        add(12);
        add(15);
        add(10);
        System.out.println("min: " + getMin());
        System.out.println("remove min: " + popMin());
        System.out.println("now min: " + getMin());
    }
}
