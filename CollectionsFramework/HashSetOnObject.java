package CollectionsFramework;

import java.util.*;

public class HashSetOnObject {
    public static void main(String[] args) {
        Set<StudentObjectClassMethods> set = new HashSet<>();
        //Here roll no is the criteria to check for same objects

        set.add(new StudentObjectClassMethods("Rohan Gupta", 1));
        set.add(new StudentObjectClassMethods("Rohan Gupta", 2));
        set.add(new StudentObjectClassMethods("Rohan Gupta", 3));
        set.add(new StudentObjectClassMethods("Rohan Gupta", 2));
        set.add(new StudentObjectClassMethods("Vipesh Mishra", 3));

        System.out.println(set);
    }
}
