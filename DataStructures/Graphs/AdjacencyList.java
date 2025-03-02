package DataStructures.Graphs;

import java.util.*;

public class AdjacencyList {
    public ArrayList<ArrayList<Integer>> adjacencyList;
    public int n;
    public AdjacencyList(int n){
        this.n = n;
        this.adjacencyList = new ArrayList<>(n + 1);
        for(int i = 1; i <= n; i++){
            this.adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(boolean directed, int u, int v){
        this.adjacencyList.get(u).add(v);
        if(!directed){
            this.adjacencyList.get(v).add(u);
        }
    }

    public void printAdjacencyList(){
        for(int i = 1; i <= this.n; i++){
            System.out.print(i + " -> ");
            for(int num: this.adjacencyList.get(i)){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
