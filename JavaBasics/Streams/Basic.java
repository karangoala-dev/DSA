package JavaBasics.Streams;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class Basic {
    public static void main(String[] args) {
        //1->Find all even numbers from a list using Streams.
        List<Integer> list1 = Arrays.asList(2, 3, 1, 4, 6, 7, 9, 12, 124, 123, 10010, 1001);
        list1 = list1.stream().filter(o -> o % 2 == 0).toList();
        System.out.println("Only even nos : " + list1);

        //2->Convert a list of strings to uppercase.
        List<String> list2 = Arrays.asList("Abcde", "AdisAbaba", "Jakarta", "Japan", "charliE", "mAngo");
        list2 = list2.stream().map(o -> o.toUpperCase()).toList();
        System.out.println("All in upper : " + list2);

        //3->Filter and collect all strings starting with "A" from a list.
        List<String> list3 = Arrays.asList("Abcde", "AdisAbaba", "Jakarta", "Japan", "charliE", "mAngo", "africa");
        list3 = list3.stream().filter(o -> o.startsWith("A") || o.startsWith("a")).toList();
        System.out.println("Only starts with A or a strings: " + list3);

        //4->Count frequency of each character in a string using streams.
        String string1 = "aababacdccdea";

        //string1.chars() → gives IntStream of character codes
        //.mapToObj(c -> (char) c) → converts int to Character
        //.collect(Collectors.toList()) → makes a List<Character>
        List<Character> list4 = string1.chars().mapToObj(o -> (char)o).map(o -> Character.toLowerCase(o)).collect(Collectors.toList());
        System.out.println("Character list is as follows : " + list4);
        HashMap<Character, Long> frequencyMap = string1.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, HashMap::new, Collectors.counting()));
//        list4.stream().forEach(o -> {
//            int freq = frequencyMap.getOrDefault(o, 0);
//            frequencyMap.put(o, freq + 1);
//        });
//
        for(Map.Entry<Character, Long> entry: frequencyMap.entrySet()){
            System.out.println("Key : " + entry.getKey() + " value: " + entry.getValue());
        }

        //5->find first non-repeated character in a string.
        String string2 = "swiss"; //ans is w. not i (first non-repeated character)
        List<Character> list5 = string2.chars().mapToObj(o -> (char)o).toList();

        //A linked hashmap maintains order in which data is inserted to it
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        list5.stream().forEach(o -> {
            int freq = map.getOrDefault(o, 0);
            map.put(o, freq + 1);
        });
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue() == 1){
                System.out.println("First non-repeated character in string is : " + entry.getKey());
                break;
            }
        }
    }
}
