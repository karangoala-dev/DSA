package DataStructures.Graphs;

public class AdjacencyMatrixUndirected {
    static int[][] adjacencyMatrix;

    static void addEdge(int u, int v) {
        adjacencyMatrix[u][v] = 1;
        adjacencyMatrix[v][u] = 1;
    }

    static void printMatrix(int n) {
        System.out.println("Adjacency Matrix:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //For a matrix with no of Node = 5, we initialise matrix to N+!, N+!
        adjacencyMatrix = new int[5 + 1][5 + 1];
        //For edges between 4,5| 2,4| 2,3| 3,5| 1,2| 1,3
        addEdge(4, 5);
        addEdge(2, 4);
        addEdge(2, 3);
        addEdge(3, 5);
        addEdge(1, 2);
        addEdge(1, 3);

        printMatrix(5);
    }
}
