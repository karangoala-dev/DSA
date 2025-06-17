package Algorithms.IntervalQns;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();

        while (i < firstList.length && j < secondList.length){
            int[] f = firstList[i];
            int[] s = secondList[j];
            if(s[0] <= f[1] && s[0] >= f[0]){
                res.add(new int[]{s[0], Math.min(s[1], f[1])});

            }
            else if(f[0] <= s[1] && f[0] >= s[0]){
                res.add(new int[]{f[0], Math.min(s[1], f[1])});
            }

            //increment the smaller end time
            if(f[1] > s[1]){
                j++;
            }
            else {
                i++;
            }
        }

        return res.toArray(new int[0][]);
    }
    public static void main(String[] args) {

    }
}
