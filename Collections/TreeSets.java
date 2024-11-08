package Collections;

import java.util.Set;
import java.util.TreeSet;

public class TreeSets {
    public static void main(String[] args) {
        //Same as HashSet
        Set<Integer> set = new TreeSet<>();
        //Implements binary search tree and stores in a sorted order
        set.add(10);
        set.add(2);
        set.add(3);
        set.add(2);
        set.add(3);

        System.out.println(set);

        System.out.println(set.contains(5));

        System.out.println(set.isEmpty());

        set.remove(2);
        System.out.println(set);
    }
}