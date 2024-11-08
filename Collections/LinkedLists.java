package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedLists {
    public static void main(String[] args) {
        LinkedList<Integer> arrayList = new LinkedList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        System.out.println(arrayList);
        System.out.println("------------------------------------------------------------------------");
        arrayList.remove(1); // Will remove index 1 's element
        System.out.println(arrayList);
        System.out.println("------------------------------------------------------------------------");
        arrayList.remove(Integer.valueOf(30));// Will remove the value 30
        System.out.println(arrayList);
        System.out.println("------------------------------------------------------------------------");
        arrayList.set(2, 1000);
        System.out.println(arrayList);
        System.out.println("------------------------------------------------------------------------");
        System.out.println(arrayList.contains(1000));
        System.out.println("-----------------------------------Iterator-------------------------------------");

        // Iterator
        Iterator<Integer> it = arrayList.iterator();
        while (it.hasNext()) {
            int value = it.next();
            System.out.print(value);
            if (it.hasNext()) { // Add "->" only if there's another element after
                System.out.print("->");
            }
            else{
                System.out.println();
            }
        }
        System.out.println("---------------------------------Convert to array---------------------------------------");
        //Convert to array
        Object[] array = arrayList.toArray();
        System.out.println(Arrays.toString(array));

        System.out.println("---------------------------------forEach---------------------------------------");
        //forEach
        arrayList.forEach(item -> System.out.println(item));

        System.out.println("-------------------clone() Creates a shallow copy of the list----------------------");
        //clone() – Creates a shallow copy of the list.

        LinkedList<Integer> newArrayList = (LinkedList<Integer>) arrayList.clone();
        System.out.println(newArrayList);
    }
}
