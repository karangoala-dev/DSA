package DataStructures.Stack;

import java.util.*;

public class OnlineStockSpan {
    //each item is like [value, no of days this value was larger/equal than previous]
    Stack<int[]> stack;
    public OnlineStockSpan() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int days = 1;
        while(!stack.isEmpty() && stack.peek()[0] <= price){
            int[] top = stack.pop();
            days += top[1];
        }

        stack.push(new int[]{price, days});
        return days;
    }
    public static void main(String[] args) {

    }
}
