package DataStructures.Graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DFS {
    Graph graph;
    Queue<Integer> queue;
    int[] isVisited;

    public DFS(Graph graph){
        this.graph = graph;
        this.queue = new LinkedList<>();
        isVisited = new int[this.graph.getSize() + 1];
    }

    public void printBFS(int start){
        this.queue.add(start);
        this.isVisited[start] = 1;
        printAdjacency();
    }

    public void printAdjacency(){
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int current = queue.poll();
                System.out.print(current);
                List<Integer> currentNodeNeighbours = this.graph.getNeighbors(current);
                for(int num: currentNodeNeighbours){
                    if(isVisited[num] == 0){
                        queue.add(num);
                        isVisited[num] = 1;
                    }
                }
            }
            System.out.println();
        }
    }
}
