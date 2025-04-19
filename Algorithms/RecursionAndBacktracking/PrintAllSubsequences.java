package Algorithms.RecursionAndBacktracking;

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
        //remove -> backtracking
        sb.deleteCharAt(prevSize);

        //not take the char at this index
        generateSubsequences(str, index + 1, sb);
        //for not take scenario we aren't adding anything so no need to remove
    }
    public static void main(String[] args) {
        generateSubsequences("abc", 0, new StringBuilder());
    }
}
