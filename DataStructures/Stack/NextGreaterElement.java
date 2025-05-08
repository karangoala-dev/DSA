package DataStructures.Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    //General algo for next greater element in same array
    public static int[] nge(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && st.peek() < arr[i]){
                st.pop();
            }
            //now, if stack is empty, nge is -1, else nge is top of stack
            if(st.isEmpty()){
                res[i] = -1;
            }
            else {
                res[i] = st.peek();
            }
            st.push(arr[i]);
        }

        return res;
    }
    public static void main(String[] args) {
        int[] res = nge(new int[] {1,3,1,2,4,6});
        Arrays.stream(res).forEach(i -> System.out.print(i + ","));
    }
}
