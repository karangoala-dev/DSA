package Algorithms.RecursionAndBacktracking;

import java.util.*;

public class LetterCombination {
    public List<Integer> nums = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9);
    public List<List<Character>> dictionary = Arrays.asList(
            Arrays.asList('a', 'b', 'c'),  // 2
            Arrays.asList('d', 'e', 'f'),  // 3
            Arrays.asList('g', 'h', 'i'),  // 4
            Arrays.asList('j', 'k', 'l'),  // 5
            Arrays.asList('m', 'n', 'o'),  // 6
            Arrays.asList('p', 'q', 'r', 's'),  // 7
            Arrays.asList('t', 'u', 'v'),  // 8
            Arrays.asList('w', 'x', 'y', 'z')   // 9
    );
    public List<Integer> digitsList = new ArrayList<>();
    public List<String> res = new ArrayList<>();

    public void helper(int i, StringBuilder c){
        if(i >= digitsList.size()){
            res.add(c.toString());
            return;
        }
        List<Character> dict = dictionary.get(digitsList.get(i) - 2);
        for(int it = 0; it < dict.size(); it++){
            c.append(dict.get(it));
            helper(i + 1, c);
            c.deleteCharAt(c.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
//        Use this when using below main function only
//        digitsList.clear();
//        res.clear();

        if(digits.isEmpty()){
            return res;
        }
        for(int i = 0; i < digits.length(); i++){
            char ch = digits.charAt(i);
            digitsList.add(Character.getNumericValue(ch));
        }
        StringBuilder c = new StringBuilder();
        helper(0, c);
        return res;
    }
    public static void main(String[] args) {
//        LetterCombination lc = new LetterCombination();
//        // Test case 1: Empty input
//        System.out.println("Test Case 1: Empty input");
//        System.out.println(lc.letterCombinations("")); // Expected: []
//
//        // Test case 2: Single digit
//        System.out.println("\nTest Case 2: Single digit (2)");
//        System.out.println(lc.letterCombinations("2")); // Expected: [a, b, c]
//
//        // Test case 3: Two digits
//        System.out.println("\nTest Case 3: Two digits (23)");
//        System.out.println(lc.letterCombinations("23")); // Expected: [ad, ae, af, bd, be, bf, cd, ce, cf]
//
//        // Test case 4: Three digits
//        System.out.println("\nTest Case 4: Three digits (234)");
//        System.out.println(lc.letterCombinations("234")); // Expected: Combination of 3 letters, like [adg, adh, adi, ...]
//
//        // Test case 5: Repeated digit
//        System.out.println("\nTest Case 5: Repeated digit (22)");
//        System.out.println(lc.letterCombinations("22")); // Expected: [aa, ab, ac, ba, bb, bc, ca, cb, cc]
//
//        // Test case 6: Large input
//        System.out.println("\nTest Case 6: Large input (2345)");
//        System.out.println(lc.letterCombinations("2345")); // Expected: Combinations with 4 digits
    }
}
