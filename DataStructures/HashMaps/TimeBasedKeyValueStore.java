package DataStructures.HashMaps;

import java.util.*;

public class TimeBasedKeyValueStore {
    private static class Pair{
        String value;
        int time;
        Pair(String _v, int _t){
            this.value = _v;
            this.time = _t;
        }
    }
    HashMap<String, List<Pair>> map;
    public TimeBasedKeyValueStore() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }

        List<Pair> dummy = map.get(key);
        dummy.add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key) || map.get(key).get(0).time > timestamp){
            //return empty array if first element of list is greater than the timestamp, since list is already sorted(due to nature of input)
            return "";
        }
        else {
            //we need to find pair where time is just <= timestamp
            List<Pair> list = map.get(key);
            int l = 0, r = list.size() - 1;
            Pair res = null;
            while(l <= r){
                int mid = (l + ((r - l) / 2));

                if(list.get(mid).time == timestamp){
                    //found match
                    return list.get(mid).value;
                }
                else if (list.get(mid).time < timestamp) {
                    //consider for result, and go right for more updated result with higher time value
                    l = mid + 1;
                    res = list.get(mid);
                }
                else {
                    //means mid is greater than timestamp, so go left for a smaller time
                    r = mid - 1;
                }
            }
            if(res != null){
                return res.value;
            }
            else {
                return "";
            }
        }
    }
    public static void main(String[] args) {

    }
}
