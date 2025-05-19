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
        int n = mat.length, up = 0, down = n - 1;

        while (up < down){
            if(mat[up][down] == 1){
                //means up knows down person -> means down could be a celebrity, so move up pointer below
                up++;
            }
            else if(mat[down][up] == 1){
                //means down person knows up -> means up could be a celebrity, so move down pointer above
                down--;
            }
            else {
                //means neother are celebrities as up is not known by down and down is not known by up
                //move both
                up++;
                down--;
            }
        }

        if(up > down){
            //means no celeb found
            return -1;
        }

        //verify
        for(int i = 0; i < n; i++){
            //if any i doesnt know the suspected celeb or suspected celeb knows someone, then not a celeb (considering i and up is not same, so i != up)
            if(i != up){
                if(mat[i][up] != 1 || mat[up][i] == 1){
                    return -1;
                }
            }
        }

        return up;
    }
    public static void main(String[] args) {

    }
}
