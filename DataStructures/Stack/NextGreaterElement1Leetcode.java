package DataStructures.Stack;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement1Leetcode {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> nums2VsInd = new HashMap<>();
        int n2 = nums2.length;
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n2];

        for(int i = n2 - 1; i >= 0; i--){
            while(!st.isEmpty() && st.peek() < nums2[i]){
                st.pop();
            }

            if(st.isEmpty()){
                nge[i] = -1;
            }
            else {
                nge[i] = st.peek();
            }
            st.push(nums2[i]);
            nums2VsInd.put(nums2[i], i);
        }

        int n1 = nums1.length;
        int[] res = new int[n1];
        for(int i = 0; i < n1; i++){
            int num = nums1[i];
            int indInNums2 = nums2VsInd.get(num);
            res[i] = nge[indInNums2];
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
