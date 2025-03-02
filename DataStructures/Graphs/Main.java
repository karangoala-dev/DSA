package DataStructures.Graphs;

public class Main {
    public static void main(String[] args) {
        AdjacencyList graph = new AdjacencyList(5);
        graph.addEdge(false, 1, 2);
        graph.addEdge(false, 1, 3);
        graph.addEdge(false, 3, 4);
        graph.addEdge(false, 2, 5);

        BFS bfsAdjList = new BFS(graph);
        bfsAdjList.printBFS(1);
    }
}
