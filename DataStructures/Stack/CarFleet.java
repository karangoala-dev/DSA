package DataStructures.Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        HashMap<Integer, Integer> posVsSpeed = new HashMap<>();
        for(int i = 0; i < n; i++){
            posVsSpeed.put(position[i], speed[i]);
        }

        Arrays.sort(position);
        //now create time array for each
        //since time can be fractional here, use double
        double[] time = new double[n];
        for(int i = 0; i < n; i++){
            //time = distance_to_be_covered / speed
            time[i] = (target - position[i]) / (posVsSpeed.get(position[i]) * 1.0);
        }

        Stack<Double> st = new Stack<>();
        //this below nge is not required, we can remove, since we are calculating result while creating it
        double[] nge = new double[n];
        int res = 0;
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && time[n - 1 - i] > st.peek()){
                st.pop();
            }

            if(st.isEmpty()){
                //means no slower car on left to combine with
                res++;
                nge[i] = -1;
            }
            else {
                nge[i] = st.peek();
            }
            st.push(time[n - 1 - i]);
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
