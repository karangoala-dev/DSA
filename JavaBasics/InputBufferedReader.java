package JavaBasics;

import java.io.*;

public class InputBufferedReader {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter you name please : ");
            String name = reader.readLine();
            System.out.println("Hello " + name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
