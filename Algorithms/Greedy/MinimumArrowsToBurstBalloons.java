package Algorithms.Greedy;

import java.util.Arrays;

public class MinimumArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        //sort the balloons according to start index
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int[] prev = points[0];
        //initially equal to total balloons
        int res = points.length;
        for(int i = 1; i < points.length; i++){
            int[] curr = points[i];

            //if both merge, then decrease no of arrows and also store merged interval in prev
            if(curr[0] <= prev[1]){
                res--;
                prev[0] = curr[0]; // no need to do min since array is sorted acc to 0th index
                prev[1] = Math.min(curr[1], prev[1]); // keep min value as the end index for merged section
            }
            else{
                prev = curr;
            }
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
