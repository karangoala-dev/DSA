package DataStructures.Graphs;

public class FloydWarshall {
    public static void shortestDistance(int[][] mat) {
        int n = mat.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == -1){
                    mat[i][j] = (int) 1e9;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int u = 0; u < n; u++){
                for(int v = 0; v < n; v++){
                    mat[u][v] = Math.min(mat[u][v], mat[u][i] + mat[i][v]);
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == (int) 1e9){
                    mat[i][j] = -1;
                }
            }
        }
    }
    public static void main(String[] args) {

    }
}
