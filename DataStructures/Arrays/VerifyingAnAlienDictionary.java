package DataStructures.Arrays;

import java.util.HashMap;

public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        //store character vs index in order here
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < order.length(); i++){
            map.put(order.charAt(i), i);
        }

        System.out.println(map);

        for(int i = 0; i < words.length - 1 ; i++){
            String a = words[i];
            String b = words[i + 1];

            //if 2 words are like abc and abcs then abcs must come after abc, or else invalid
            if(a.length() > b.length() && a.startsWith(b)){
                return false;
            }
            System.out.println("Comparing " + a + " " + b);
            //now find first differing character and check index value from hashMap
            for(int j = 0; j < Math.min(a.length(), b.length()); j++){
                //if characters not equal, compare and if incorrect ordering, then return false
                Character x = a.charAt(j);
                Character y = b.charAt(j);
                System.out.println(x +" "+ y);
                if(x != y){
                    //map index for char at a must be smaller than map index for char at b
                    if(map.get(x) > map.get(y)){
                        return false;
                    }
                    //since first non-similar found, break, as reaching here means first non-similar character is in-order
                    break;
                }
            }
        }
        //if all good then return true
        return true;
    }
    public static void main(String[] args) {
        VerifyingAnAlienDictionary verifyingAnAlienDictionary = new VerifyingAnAlienDictionary();
        System.out.println(verifyingAnAlienDictionary.isAlienSorted(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
    }
}
