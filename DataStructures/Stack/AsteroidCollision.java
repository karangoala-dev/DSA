package DataStructures.Stack;

import java.util.*;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(asteroids[i] > 0){
                st.push(asteroids[i]);
            }
            else{
                if(st.isEmpty()){
                    //means these asteroids wont collide and keep moving left
                    res.add(asteroids[i]);
                }
                else{
                    //means these will collide
                    int num = asteroids[i] * -1;
                    while(!st.isEmpty() && st.peek() <= num){
                        if(st.peek() == num){
                            //then both get destroyed
                            st.pop();
                            break;
                        }
                        else{
                            //means -ve one was larger
                            st.pop();
                            if(st.isEmpty()){
                                //means no more asteroids which will hit, so this remains
                                res.add(asteroids[i]);
                            }
                        }
                    }
                }
            }
        }
        List<Integer> list = new ArrayList<>(st);
        for(int i = 0; i < list.size(); i++){
            res.add(list.get(i));
        }

        int[] result = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            result[i] = res.get(i);
        }

        return result;
    }
    public static void main(String[] args) {

    }
}
