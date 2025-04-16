package Algorithms.Recursion;

public class PrintAllSubsequences {
    public static void generateSubsequences(String str, int index, StringBuilder sb){
        //base case -> if index == str.length(not str.length - 1)
        if(index == str.length()){
            System.out.println("->" + sb);
            return;
        }

        //Take the char at current index
        int prevSize = sb.length();
        sb.append(str.charAt(index));
        generateSubsequences(str, index + 1, sb);

        //remove and not take the char at this index
        sb.deleteCharAt(prevSize);
        generateSubsequences(str, index + 1, sb);
    }
    public static void main(String[] args) {
        generateSubsequences("abc", 0, new StringBuilder());
    }
}
