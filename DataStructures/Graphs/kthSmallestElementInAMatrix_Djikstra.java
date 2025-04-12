package DataStructures.Graphs;

import java.util.Comparator;
import java.util.PriorityQueue;

public class kthSmallestElementInAMatrix_Djikstra {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length;
        int[][] visited = new int[n][m];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        visited[0][0] = 1;
        minHeap.add(new int[]{matrix[0][0], 0, 0});

        //since sorted row wise and column wise, either go horizontally right or vertically down
        int[] row = {0, 1};
        int[] col = {1, 0};

        int count = 0;
        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            count++;
            if(count == k){
                return curr[0];
            }
            for(int i = 0; i < 2; i++){
                int nRow = curr[1] + row[i];
                int nCol = curr[2] + col[i];

                if(nRow < n && nCol < m && visited[nRow][nCol] == 0){
                    visited[nRow][nCol] = 1;
                    minHeap.add(new int[]{matrix[nRow][nCol], nRow, nCol});
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}
