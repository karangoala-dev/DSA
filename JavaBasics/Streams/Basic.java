package JavaBasics.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

        //Filter and collect all strings starting with "A" from a list.
        List<String> list3 = Arrays.asList("Abcde", "AdisAbaba", "Jakarta", "Japan", "charliE", "mAngo", "africa");
        list3 = list3.stream().filter(o -> o.startsWith("A") || o.startsWith("a")).toList();
        System.out.println("Only starts with A or a strings: " + list3);

        //Count frequency of each character in a string using streams.
        String string1 = "AnUltraLongStringWithoutANyMeanning";
        List<Character> list4 = string1.chars().mapToObj(o -> (char)o).collect(Collectors.toList());
        System.out.println("Character list is as follows : " + list4);
    }
}
