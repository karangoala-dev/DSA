package DataStructures.Graphs;

public class Main {
    public static void main(String[] args) {
        // Create an adjacency list graph
        AdjacencyList graphList = new AdjacencyList(7);
        graphList.addEdge(false, 1, 2);
        graphList.addEdge(false, 1, 3);
        graphList.addEdge(false, 2, 4);
        graphList.addEdge(false, 2, 5);
        graphList.addEdge(false, 3, 4);
        graphList.addEdge(false, 5, 6);
        graphList.addEdge(false, 6, 7);

        System.out.println("BFS using Adjacency List (starting from node 1):");
        BFS bfsAdjList = new BFS(graphList);
        bfsAdjList.printBFS(1);
        System.out.println();

        System.out.println("DFS using Adjacency List (starting from node 1):");
        DFS dfsAdjList = new DFS(graphList);
        dfsAdjList.printDFS(1);
        System.out.println();

        // Create an adjacency matrix graph
        AdjacencyMatrix graphMatrix = new AdjacencyMatrix(7);
        graphMatrix.addEdge(false, 1, 2);
        graphMatrix.addEdge(false, 1, 3);
        graphMatrix.addEdge(false, 2, 4);
        graphMatrix.addEdge(false, 2, 5);
        graphMatrix.addEdge(false, 3, 4);
        graphMatrix.addEdge(false, 5, 6);
        graphMatrix.addEdge(false, 6, 7);

        System.out.println("BFS using Adjacency Matrix (starting from node 1):");
        BFS bfsAdjMatrix = new BFS(graphMatrix);
        bfsAdjMatrix.printBFS(1);

        System.out.println("DFS using Adjacency Matrix (starting from node 1):");
        DFS dfsAdjMatrix = new DFS(graphMatrix);
        dfsAdjMatrix.printDFS(1);
        System.out.println();
    }
}
