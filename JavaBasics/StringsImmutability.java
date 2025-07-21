package JavaBasics;

public class StringsImmutability {
    public static void main(String[] args) {
        String a = "Hello";
        String b = "Hello";
        a += "a";
        System.out.println(a.equals(b));
    }
}
