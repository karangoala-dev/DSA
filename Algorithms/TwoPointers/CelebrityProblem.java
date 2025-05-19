package Algorithms.TwoPointers;

public class CelebrityProblem {
    //unoptimised
    public int celebrity_O_2n(int mat[][]) {
        int n = mat.length;
        int[] iKnow = new int[n];
        int[] knowMe = new int[n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                iKnow[i] += mat[i][j];
                knowMe[j] += mat[i][j];
            }
        }

        //now find the celebrity
        for(int i = 0; i < n; i++){
            if(iKnow[i] == 1 && knowMe[i] == n){
                return i;
            }
        }
        return -1;
    }

    //Optimised approach
    public int celebrity(int mat[][]) {

    }
    public static void main(String[] args) {

    }
}
