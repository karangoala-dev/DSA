package JavaBasics;

public class Strings {
    public static void main(String[] args) {
        String str = "Hello, Java!";
        System.out.println(str.length()); // Output: 12
        System.out.println(str.charAt(1)); // Output: e
        System.out.println(str.substring(0, 5)); // Output: Hello
        System.out.println(str.contains("Java")); // Output: true
        System.out.println(str.equals("Hello")); // Output: false
        System.out.println(str.toUpperCase()); // Output: HELLO, JAVA!

        System.out.println("--------------------------------------------------------------");

        StringBuilder sb = new StringBuilder("Hello"); //Or StringBuffer. Same but StringBuilder is not thread safe but fast. StringBuffer is thread safe but slow
        sb.append(", World!");
        System.out.println(sb.toString()); // Output: Hello, World!

        System.out.println("--------------------------------------------------------------");

        String sentence = "Java is awesome";
        String[] words = sentence.split(" ");

        for(String word: words){
            System.out.println(word);    
        }
    }
}
