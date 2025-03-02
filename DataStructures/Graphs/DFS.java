package DataStructures.Graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DFS {
    Graph graph;
    int[] isVisited;

    public DFS(Graph graph){
        this.graph = graph;
        isVisited = new int[this.graph.getSize() + 1];
    }

    public void printDFS(int node){
        if(isVisited[node] == 1){
            return ;
        }

        System.out.println(node);
        isVisited[node] = 1;

        List<Integer> neighbours = graph.getNeighbors(node);
        for(int num: neighbours){
            if(isVisited[num] == 0){
                printDFS(num);
            }
        }
    }
}
