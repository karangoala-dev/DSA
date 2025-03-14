package DataStructures.Graphs;

import java.util.*;

public class AlienDictionary {
    public String findOrder(String[] words) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int index = 0;
        for(int i = 0; i < words.length; i++){
            char[] curr = words[i].toCharArray();
            for(char c: curr){
                if (!map.containsKey(c)) {
                    map.put(c, index++);
                }
            }
        }

        for(int i = 0; i < map.size(); i++){
            adj.add(new ArrayList<>());
        }
        for(int t = 1; t < words.length; t++){
            char[] a = words[t - 1].toCharArray();
            char[] b = words[t].toCharArray();
            if(a.length > b.length && words[t - 1].startsWith(words[t])){
                return "";
            }
            int i = 0, j = 0;
            while(i < a.length && j < b.length){
                if(a[i] != b[i]){
                    int ind = map.get(a[i]);
                    adj.get(ind).add(map.get(b[j]));
                    break;
                }
                i++;
                j++;
            }
        }

        int[] indegree = new int[map.size()];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < adj.size(); i++){
            ArrayList<Integer> curr = adj.get(i);
            for(int n: curr){
                indegree[n]++;
            }
        }
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        while(!q.isEmpty()){
            int curr = q.poll();
            ArrayList<Integer> neigh = adj.get(curr);
            for(int num: neigh){
                indegree[num]--;
                if(indegree[num] == 0){
                    q.add(num);
                }
            }
            res.add(curr);
        }
        //If cyclic, then return empty string
        if(map.size() != res.size()){
            return "";
        }
        char[] resArr = new char[res.size()];
        char[] indexToChar = new char[map.size()];
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            indexToChar[entry.getValue()] = entry.getKey();
        }
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = indexToChar[res.get(i)];
        }
        return new String(resArr);
    }
    public static void main(String[] args) {

    }
}
