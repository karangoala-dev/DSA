package DataStructures.Stack;

import java.util.*;

public class MaximumAreaRectangleInHistogram {
    private static class Pair{
        int val;
        int ind;
        Pair(int _v, int _i){
            this.val = _v;
            this.ind = _i;
        }
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Pair[] nse = new Pair[n];
        Pair[] pse = new Pair[n];
        Stack<Pair> st_pse = new Stack<>();
        Stack<Pair> st_nse = new Stack<>();

        //generate nse and pse
        for(int i = 0; i < n; i++){
            //pse generation
            while(!st_pse.isEmpty() && st_pse.peek().val >= heights[i]){
                st_pse.pop();
            }
            if(st_pse.isEmpty()){
                pse[i] = new Pair(-1, -1);
            }
            else{
                pse[i] = st_pse.peek();
            }

            st_pse.push(new Pair(heights[i], i));

            //nse generation
            //index from right side
            int _i = n - i - 1;
            while(!st_nse.isEmpty() && st_nse.peek().val >= heights[_i]){
                st_nse.pop();
            }
            if(st_nse.isEmpty()){
                nse[_i] = new Pair(-1, -1);
            }
            else{
                nse[_i] = st_nse.peek();
            }

            st_nse.push(new Pair(heights[_i], _i));
        }

        int res = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            Pair lBound = pse[i];
            Pair rBound = nse[i];

            //l means left boundary, r means right boundary, if l or r is -1, means current element has no smaller element on left/right
            int l = lBound.ind == -1 ? -1 : lBound.ind;
            int r = rBound.ind == -1 ? n : rBound.ind;

            int curr = heights[i] * (r - l - 1);

            res = Math.max(res, curr);
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
