package Algorithms.BinarySearch;

import java.util.Comparator;
import java.util.PriorityQueue;

public class kthSmallestElementInAMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length;
        //Here instead of doing binary search on index, we do a binary search on value.

        //smallest and largest values in the matrix will be as follows
        int smallest = matrix[0][0], largest = matrix[n - 1][m - 1];
        while(smallest < largest){
            int midValue = (smallest + (largest - smallest) / 2);
            int count = findSmallerOrEqual(matrix, midValue);

            if(count < k){
                //go right
                smallest = midValue + 1;
            }
            else {
                //go left
                largest = midValue;
            }
        }
        return smallest;
    }

    //this fn returns no of elements smaller or equal to midValue
    public int findSmallerOrEqual(int[][] matrix, int midValue){
        int count = 0;

        //we start from bottom-left cell
        int row = matrix.length - 1, col = 0;
        while(row >= 0 && col < matrix[0].length - 1){
            if(matrix[row][col] <= midValue){
                //means increment col to find elements less or equal to midValue
                //also increase count these elements are <= midValue
                count += row + 1;
                col++;
            }
            else {
                //means go above one step to previous row
                row--;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
