package DataStructures.Stack;

import java.util.Stack;

public class minStackOptimised {
    private static Stack<Integer> stack = new Stack<>();
    static int min = Integer.MAX_VALUE;

    public static void push(int val){
        if(stack.isEmpty()){
            min = val;
            stack.push(val);
        }
        else {
            if(val > min){
                //just push the value
                stack.push(val);
            }
            else {
                //push in modified value, this way we preserve the previous minimum in the stack value
                int newValue = 2 * val - min;
                min = val;
                stack.push(newValue);
            }
        }
    }

    public static void pop(){
        if(stack.isEmpty()){
            return ;
        }
        int x = stack.pop();
        if(x < min){
            //means x was a modified value, see derivation for why modified x will always be less than min
            //since we are doing a pop, we need to refresh the minimum to previous minimum
            min = 2 * min - x;
        }
    }

    public static int top(){
        if(stack.isEmpty()){
            return Integer.MAX_VALUE;
        }
        else {
            int x = stack.peek();
            if(x < min){
                //means modified value, so return the min variable which stores the value
                return min;
            }
            //for normal case return top
            return x;
        }
    }

    public static int getMin(){
        return min;
    }

    public static void main(String[] args) {
        push(12);
        push(15);
        push(10);
        System.out.println(top());
        System.out.println(stack);
        pop();
        System.out.println(top());
        push(10);
        System.out.println(min);
    }
}
