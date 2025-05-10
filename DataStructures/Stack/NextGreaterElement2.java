package DataStructures.Stack;

import java.util.Stack;

public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && st.peek() <= nums[i]){
                st.pop();
            }

            if(st.isEmpty()){
                res[i] = -1;
            }
            else{
                res[i] = st.peek();
            }
            st.push(nums[i]);
        }
        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && st.peek() <= nums[i]){
                st.pop();
            }

            if(st.isEmpty()){
                res[i] = -1;
            }
            else{
                res[i] = st.peek();
            }
            st.push(nums[i]);
        }

        return res;
    }

    //Optimal approach
    public int[] nextGreaterElements_optimal(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 2 * n - 1; i >= 0; i--){
            int ind = i % n;
            while(!st.isEmpty() && st.peek() <= nums[ind]){
                st.pop();
            }

            if(st.isEmpty()){
                res[ind] = -1;
            }
            else{
                res[ind] = st.peek();
            }
            st.push(nums[ind]);
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
