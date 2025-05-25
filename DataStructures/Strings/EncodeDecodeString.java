package DataStructures.Strings;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeString {
    public String encode(String s[]) {
        StringBuilder sb = new StringBuilder();
        for(String w: s){
            //@ added for words starting with number
            sb.append("#" + w.length() + "@");
            sb.append(w);
        }
        return sb.toString();
    }

    public String[] decode(String s) {
        List<String> res = new ArrayList<>();

        int i = 0;
        while(i < s.length() - 1){
            if(s.charAt(i) == '#' && Character.isDigit(s.charAt(i + 1))){
                //means we found a length from i + 1
                i++;
                int numStart = i;
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    i++;
                }
                int wordLen = Integer.parseInt(s.substring(numStart, i));
                //+1 done for @ delimiter
                res.add(s.substring(i + 1, i + wordLen + 1));
                i += wordLen;
            }
            else {
                i++;
                continue;
            }
        }

        return res.toArray(new String[0]);
    }
    public static void main(String[] args) {
        EncodeDecodeString encodeDecodeString = new EncodeDecodeString();
        String s = encodeDecodeString.encode(new String[]{"tv96", "np0", "eVHgP!", "I0", "Oeu8VIuWKJ", "0"});
        System.out.println(s);
        String[] res = encodeDecodeString.decode(s);
        System.out.println(res);
    }
}
