package DataStructures.Graphs;

import java.util.*;

public class GetWatchedVideosByYourFriends {
    private static class Pair{
        int n;
        int l;
        Pair(int _n, int _l){
            this.n = _n;
            this.l = _l;
        }
    }
    private static class Pair2{
        String s;
        int f;
        Pair2(String _s, int _f){
            this.s = _s;
            this.f = _f;
        }
    }
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = watchedVideos.size();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(id, 0));
        List<Integer> levelNode = new ArrayList<>();
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int[] neis = friends[curr.n];
            for(int nei: neis){
                if(curr.l == level - 1){
                    //We reached the level and we can stop traversing further, just add the nodes to levelNode list
                    levelNode.add(nei);
                }
                else {
                    q.add(new Pair(nei, curr.l + 1));
                }
            }
            if(levelNode.size() != 0){
                break;
            }
        }
        HashMap<String, Integer> map = new HashMap<>();
        PriorityQueue<Pair2> pq = new PriorityQueue<>(Comparator.comparingInt(o -> map.get(o.s)));
        for(int node: levelNode){
            //Get videos watched by that node
            System.out.println("->" + node);
            List<String> videos = watchedVideos.get(node);
            for(String s: videos){
                if(!map.containsKey(s)){
                    map.put(s, 0);
                }
                map.put(s, map.get(s) + 1);
            }
        }
        List<String> res = new ArrayList<>();
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            pq.add(new Pair2(entry.getKey(), entry.getValue()));
        }

        while (!pq.isEmpty()){
            res.add(pq.poll().s);
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
        int level = 2;

        List<String> result = obj.watchedVideosByFriends(watchedVideos, friends, id, level);
        System.out.println(result);  // Expected output: ["B", "C"]
    }
}
