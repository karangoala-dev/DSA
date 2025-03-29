package DataStructures.Graphs;

import java.util.*;

public class GetWatchedVideosByYourFriends {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = watchedVideos.size();
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        int[] visited = new int[n];
        visited[id] = 1;
        while(!q.isEmpty() && level != 0){
            int size = q.size();
            level--;
            for(int i = 0; i < size; i++){
                int curr = q.poll();
                int[] neis= friends[curr];
                for (int friend: neis){
                    if(visited[friend] == 0){
                        q.add(friend);
                        visited[friend] = 1;
                    }
                }
            }
        }
        //Create frequency map
        HashMap<String, Integer> freqMap = new HashMap<>();
        while(!q.isEmpty()){
            int node = q.poll();
            List<String> videos = watchedVideos.get(node);
            for(String s: videos){
                if(!freqMap.containsKey(s)){
                    freqMap.put(s, 0);
                }
                freqMap.put(s, freqMap.get(s) + 1);
            }
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((o1, o2) -> o1.getValue().equals(o2.getValue()) ? o1.getKey().compareTo(o2.getKey()) : o1.getValue() - o2.getValue());
        for(Map.Entry<String, Integer> entry: freqMap.entrySet()){
            pq.add(entry);
        }
        List<String> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(pq.poll().getKey());
        }
        return res;
    }
    public static void main(String[] args) {
        GetWatchedVideosByYourFriends obj = new GetWatchedVideosByYourFriends();

        List<List<String>> watchedVideos = Arrays.asList(
                Arrays.asList("A", "B"),
                Arrays.asList("C"),
                Arrays.asList("B", "C"),
                Arrays.asList("D")
        );

        int[][] friends = {
                {1, 2},  // Person 0 is friends with 1 and 2
                {0, 3},  // Person 1 is friends with 0 and 3
                {0, 3},  // Person 2 is friends with 0 and 3
                {1, 2}   // Person 3 is friends with 1 and 2
        };

        int id = 0;
        int level = 1;

        List<String> result = obj.watchedVideosByFriends(watchedVideos, friends, id, level);
        System.out.println(result);  // Expected output: ["B", "C"]
    }
}
