package Collections;

import java.util.TreeMap;
import java.util.Map;

public class TreeMaps {
    public static void main(String[] args) {
        //Same as hash map, only diff is keys are stored in an order using BST. It uses a Binary Search Tree
        Map<String, Integer> map = new TreeMap<>();
        map.put("One", 1);
        map.put("Two", 2);

        map.putIfAbsent("Two", 22);

        if(map.containsKey("One")){
            System.out.println("Has one");
        }

        if(map.containsValue(2)){
            System.out.println("Has 2 as a value");
        }

        System.out.println(map.isEmpty() ? "Empty" : "Not empty");
        System.out.println(map);
        System.out.println(map.size());

        //Iterate over the map now
        System.out.println("Iterating over the map now");
        for(Map.Entry<String, Integer> e: map.entrySet()){
            System.out.println("Entry : " + e + " | Key, Value : " + e.getKey() + "," + e.getValue());
        }
        //Iterate over the map keys
        System.out.println("Iterating over the map values");
        for(String e: map.keySet()){
            System.out.println("Key : " + e);
        }
        //Iterate over the map values
        System.out.println("Iterating over the map values");
        for(Integer e: map.values()){
            System.out.println("Value : " + e);
        }
    }
}
