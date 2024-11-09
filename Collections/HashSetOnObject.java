package Collections;

import java.util.*;

public class HashSetOnObject {
    public static void main(String[] args) {
        Set<StudentObjectClassMethods> set = new HashSet<>();

        set.add(new StudentObjectClassMethods("Rohan Gupta", 1));
        set.add(new StudentObjectClassMethods("Rohan Gupta", 2));
        set.add(new StudentObjectClassMethods("Rohan Gupta", 3));
        set.add(new StudentObjectClassMethods("Rohan Gupta", 2));
        set.add(new StudentObjectClassMethods("Rohan Gupta", 3));

        System.out.println(set);
    }
}
