package DataStructures.Graphs;

public class AdjacencyMatrix {
    public int[][] adjacencyMatrix;
    public int n;
    public AdjacencyMatrix(int n){
        this.adjacencyMatrix = new int[n + 1][n + 1];
        this.n = n;
    }
    public void printAdjacencyMatrix(){
        for(int i = 1; i <= this.n; i++){
            for(int j = 1; j <= this.n; j++){
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void addEdge(boolean directed, int u, int v){
        this.adjacencyMatrix[u][v] = 1;
        if(!directed){
            adjacencyMatrix[v][u] = 1;
        }
    }
}
