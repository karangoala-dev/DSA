package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(115,212,23,47,1110111);
        Stream<Integer> numsStream = nums.stream();

        numsStream.sorted().forEach(n -> System.out.println(n));
    }
}
