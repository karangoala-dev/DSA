package CollectionsFramework;

import java.util.*;

public class ObjectListSorting {
    public static void main(String[] args) {
        List<StudentObjectClassMethods> list = new ArrayList<>();
        list.add(new StudentObjectClassMethods("Rahul Singh", 3));
        list.add(new StudentObjectClassMethods("Vipesh Mishra", 1));
        list.add(new StudentObjectClassMethods("Dinesh Jaiswal", 2));

        System.out.println(list);
        //Sort based on roll number
        Collections.sort(list);
        System.out.println(list);
        //Now sort based on name
        Collections.sort(list, new Comparator<StudentObjectClassMethods>(){
            @Override
            public int compare(StudentObjectClassMethods o1, StudentObjectClassMethods o2){
                return o1.name.compareTo(o2.name);
            }
        });
        System.out.println(list);
    }
}
