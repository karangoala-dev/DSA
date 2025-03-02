package DataStructures.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    Graph graph;
    Queue<Integer> queue;
    int[] isVisited;

    public BFS(Graph graph){
        this.graph = graph;
        this.queue = new LinkedList<>();
        isVisited = new int[this.graph.getSize()];
    }

    public void printBFS(int start){
        this.queue.add(start);
        if(this.graph instanceof AdjacencyMatrix){

        }
        else if(this.graph instanceof AdjacencyList){

        }
    }

    public void printAdjacencyMatrix(){
        while(!queue.isEmpty()){
            int current = queue.poll();
            System.out.print(current);

        }
    }
}
