package DataStructures.Stack;

import java.util.Stack;

public class PreviousSmallerElement {
    public int[] leftSmaller(int[] arr) {
        // code here
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && st.peek() >= arr[i]){
                st.pop();
            }

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

    }
}
