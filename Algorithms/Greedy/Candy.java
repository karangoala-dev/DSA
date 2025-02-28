package Algorithms.Greedy;

public class Candy {
    //Space not optimised
    public int candy2NSpace(int[] ratings) {
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

        for(int i = 0; i < ratings.length; i++){
            res += Math.max(left[i], right[i]);
        }

        return res;
    }

    public int candy1NSpace(int[] ratings) {
        int res = 0;
        int[] left = new int[ratings.length];
        left[0] = 1;


        for(int i=1; i < ratings.length; i++){
            if(ratings[i] > ratings[i - 1]){
                left[i] = left[i - 1] + 1;
            }
            else{
                left[i] = 1;
            }
        }
        int curr = 1, prev = 1;
        res = res + Math.max(prev, left[left.length - 1]);
        for(int i=ratings.length - 2; i >= 0; i--){
            int current;
            if(ratings[i] > ratings[i + 1]){
                current = prev + 1;
            }
            else {
                current = 1;
            }
            prev = current;
            res += Math.max(current, left[i]);
        }

        return res;
    }
    //Most optimised TC: O(N) / SC: O(1)
    public int candy(int[] ratings) {
        int i = 1, res = 1, n = ratings.length;
        while(i < n){
            if(ratings[i] == ratings[i - 1]){
                res += 1;
                i++;
                continue;
            }

            //Now check for upward and downward slopes
            int peak = 1;
            while(i < n && ratings[i] > ratings[i - 1]){
                peak++;
                res += peak;
                i++;
            }

            int down = 1;
            while(i < n && ratings[i] < ratings[i - 1]){
                res += down;
                down++;
                i++;
            }

            if(down > peak){
                res += (down - peak);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Candy candy = new Candy();
        int[] arr = new int[]{1,2,87,87,87,2,1};
        System.out.println(candy.candy1NSpace(arr));
        System.out.println(candy.candy2NSpace(arr));
    }
}
