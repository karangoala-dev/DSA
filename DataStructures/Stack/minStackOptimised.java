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

    public static void main(String[] args) {

    }
}
