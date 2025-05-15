package DataStructures.Stack;

import java.util.*;

public class minStackLeetcode {
    Stack<Long> stack;
    long min;
    public minStackLeetcode() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty()){
            stack.push((long)val);
            min = val;
            return;
        }
        //stack not empty
        if(val > min){
            stack.push((long)val);
        }
        else{
            //modified element to be pushed
            long newVal = 2L * val - min;
            stack.push(newVal);
            min = val;
        }
    }

    public void pop() {
        if(stack.isEmpty()){
            return;
        }

        long x = stack.pop();
        if(x < min){
            //means modified element is removed, so refresh the min value
            min = 2 * min - x;
        }
    }

    public int top() {
        if(stack.isEmpty()){
            return -1;
        }
        long x = stack.peek();
        if(x < min){
            //modified value, so return the min
            return (int)min;
        }
        else{
            //return the top;
            return (int)x;
        }
    }

    public int getMin() {
        return (int)min;
    }
    public static void main(String[] args) {

    }
}
