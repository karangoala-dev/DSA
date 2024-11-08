package Collections;

import java.util.*;

public class HashSets {
    public static void main(String[] args) {
        // Cannot accept duplicate elements
        Set<Integer> set = new HashSet<>();
        set.add(1);
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