package JavaBasics.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Basic {
    public static void main(String[] args) {
        //Find all even numbers from a list using Streams.
        List<Integer> list1 = Arrays.asList(2, 3, 1, 4, 6, 7, 9, 12, 124, 123, 10010, 1001);
        list1 = list1.stream().filter(o -> o % 2 == 0).toList();
        System.out.println("Only even nos : " + list1);

        //Convert a list of strings to uppercase.
        List<String> list2 = Arrays.asList("Abcde", "AdisAbaba", "Jakarta", "Japan", "charliE", "mAngo");
        list2 = list2.stream().map(o -> o.toUpperCase()).toList();
        System.out.println("All in upper : " + list2);

        //
    }
}
