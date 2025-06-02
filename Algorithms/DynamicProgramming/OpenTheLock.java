package Algorithms.DynamicProgramming;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class OpenTheLock {
    private static class Pair{
        String s;
        Integer i;
        Pair(String _s, Integer _i){
            this.s = _s;
            this.i = _i;
        }
    }
    public int openLock_DJIKSTRA(String[] deadends, String target) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o1.i - o2.i);
        pq.add(new Pair("0000", 0));
        HashSet<String> set = new HashSet<>();
        set.add("0000");
        for(String s: deadends){
            set.add(s);
        }

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            StringBuilder curr = new StringBuilder(p.s);
            int moves = p.i;

            if(curr.equals(target)){
                return moves;
            }

            for(int i = 0; i < curr.length(); i++){
                char c = curr.charAt(i);
                StringBuilder nei1 = new StringBuilder(curr);
                StringBuilder nei2 = new StringBuilder(curr);
                if(c == '0'){
                    nei1.setCharAt(i, '1');
                    nei2.setCharAt(i, '9');
                }
                else if(c == '9'){
                    nei1.setCharAt(i, '0');
                    nei2.setCharAt(i, '8');
                }
                else{
                    int num = curr.charAt(i) - '0';
                    nei1.setCharAt(i, (char) ('0' + ((num - 1 + 10) % 10)));
                    nei2.setCharAt(i, (char) ('0' + ((num + 1 + 10) % 10)));
                }

                if(!set.contains(nei1.toString())){
                    pq.add(new Pair(nei1.toString(), moves + 1));
                    set.add(nei1.toString());
                }
                if(!set.contains(nei2.toString())){
                    pq.add(new Pair(nei2.toString(), moves + 1));
                    set.add(nei2.toString());
                }
            }
        }
        return -1;
    }

    public int openLock_BFS(String[] deadends, String target) {
        HashSet<String> visited = new HashSet<>();
        for(String s: deadends){
            visited.add(s);
        }

        Queue<String> q = new LinkedList<>();
        int moves = 0;
        if(!visited.contains("0000")){
            //this is an edge case
            q.add("0000");
            visited.add("0000");
        }

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String curr = q.poll();
                if(curr.equals(target)){
                    return moves;
                }

                //now iterate each digit in the string for next number
                for(int j = 0; j < 4; j++){
                    int digit = curr.charAt(j) - '0';
                    //we need previous and next move for each digit
                    int[] steps = new int[]{-1, 1};
                    for(int step: steps){
                        //+10 is used since in java -1%10 is -1 and not 1
                        int nextDigit = (digit + step + 10) % 10;
                        StringBuilder next = new StringBuilder(curr);
                        next.setCharAt(j, (char) (nextDigit + '0'));
                        if(!visited.contains(next.toString())){
                            q.add(next.toString());
                            visited.add(next.toString());
                        }
                    }
                }
            }
            moves++;
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}
