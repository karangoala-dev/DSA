package DataStructures.Graphs;

import java.util.ArrayList;

public class AdjacencyListDirected {
    static ArrayList<ArrayList<Integer>> adjacencyList;
    public static void addEdge(int u, int v){
        adjacencyList.get(u).add(v);
    }
    static void printList(int n) {
        System.out.println("Adjacency List:");
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " -> ");
            for(int num: adjacencyList.get(i)){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        //For a matrix with no of Node = 5, we initialise list with N+1 empty Lists
        adjacencyList = new ArrayList<>();
        for(int i = 0; i < (5 + 1); i++){
            adjacencyList.add(new ArrayList<Integer>(5 + 1));
        }

        //For edges between 4,5| 2,4| 2,3| 3,5| 1,2| 1,3
        addEdge(4, 5);
        addEdge(2, 4);
        addEdge(2, 3);
        addEdge(3, 5);
        addEdge(2, 1);
        addEdge(3, 1);

        printList(5);
    }
}
