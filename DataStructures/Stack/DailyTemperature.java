package DataStructures.Stack;

import java.util.*;

public class DailyTemperature {
    public static class Pair{
        int temp;
        int ind;
        Pair(int _t, int _i){
            this.temp = _t;
            this.ind = _i;
        }
    }
    public int[] dailyTemperatures(int[] arr) {
        Stack<Pair> st = new Stack<>();
        int n = arr.length;
        int[] res = new int[n];
        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && st.peek().temp <= arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                //means no days ahead with a warmer temp
                res[i] = 0;
            }
            else{
                //mean we have some day with a warmer temp
                res[i] = st.peek().ind - i;
            }

            st.push(new Pair(arr[i], i));
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
