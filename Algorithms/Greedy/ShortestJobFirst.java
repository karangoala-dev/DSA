package Algorithms.Greedy;
import java.util.*;
public class ShortestJobFirst {
    static int solve(int bt[] ) {
        // code here
        int t = 0;
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(bt);

        for(int b: bt){
            list.add(t);
            t += b;
        }

        int res = 0;
        for(Integer i: list){
            res += i;
        }

        return res / (bt.length);
    }

    public static void main(String[] args) {

    }
}
