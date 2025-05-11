package Algorithms.DynamicProgramming;

import DataStructures.Stack.MaximumAreaRectangleInHistogram;

import java.util.Stack;

public class MaximumAreaRectangleWith1s {
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
                nse[_i] = new Pair(-1, n);
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
            int l = lBound.ind;
            int r = rBound.ind;

            int curr = heights[i] * (r - l - 1);

            res = Math.max(res, curr);
        }

        return res;
    }

    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        //this array stores height of histogram column, if 0 is found, set histogram[i] = 0, else, histogram[i] += 1;
        int[] histogram = new int[matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '0'){
                    histogram[j] = 0;
                }
                else {
                    histogram[j] += 1;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(histogram));
        }
        return maxArea;
    }

    public static void main(String[] args) {

    }
}
