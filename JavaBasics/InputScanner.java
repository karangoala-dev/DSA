package JavaBasics;

import java.util.*;

public class InputScanner{
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Enter your name : ");
        String name = scanner.nextLine();
        System.out.println("Hello " + name);
        scanner.close();
    }
}