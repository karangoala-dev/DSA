package Collections;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSets {
    public static void main(String[] args) {
        //Same as HashSet
        Set<Integer> set = new LinkedHashSet<>();
        //Maintains order in which data is entered unlike HashSet
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
