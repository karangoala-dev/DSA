package DataStructures.Graphs;

import java.util.*;

public class PathWIthMinimumEffort {
    private static class Node{
        int r;
        int c;
        int diff;
        Node(int _r, int _c, int _diff){
            this.r = _r;
            this.c = _c;
            this.diff = _diff;
        }
    }

    public int minimumEffortPath(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] diff = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(diff[i], Integer.MAX_VALUE);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)->o1.diff-o2.diff);
        pq.add(new Node(0, 0, 0));
        int[] row = {0, -1, 0, 1};
        int[] col = {-1, 0, 1, 0};
        while(!pq.isEmpty()){
            Node curr = pq.poll();
            if(curr.r == n - 1 && curr.c == m - 1){
                return curr.diff;
            }
            for(int i = 0; i < 4; i++){
                int nRow = curr.r + row[i];
                int nCol = curr.c + col[i];
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m){
                    int currDiff = Math.max(Math.abs(mat[curr.r][curr.c] - mat[nRow][nCol]), curr.diff);
                    if(currDiff < diff[nRow][nCol]){
                        diff[nRow][nCol] = currDiff;
                        pq.add(new Node(nRow, nCol, currDiff));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
