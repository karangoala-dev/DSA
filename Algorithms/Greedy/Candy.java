package Algorithms.Greedy;

public class Candy {
    //Space not optimised
    public int candy(int[] ratings) {
        int res = 0;
        int[] left = new int[ratings.length];
        left[0] = 1;
        int[] right = new int[ratings.length];
        right[right.length - 1] = 1;

        for(int i=1; i < ratings.length; i++){
            if(ratings[i] > ratings[i - 1]){
                left[i] = left[i - 1] + 1;
            }
            else{
                left[i] = 1;
            }
        }
        for(int i=ratings.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]){
                right[i] = right[i + 1] + 1;
            }
            else{
                right[i] = 1;
            }
        }

        for(int i = 0; i < left.length; i++){
            System.out.print(left[i]);
        }
        System.out.println();
        for(int i = 0; i < left.length; i++){
            System.out.print(right[i]);
        }

        for(int i = 0; i < ratings.length; i++){
            res += Math.max(left[i], right[i]);
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
