package JavaBasics;

// Data Types in Java
// | Data Type | Size (in bytes)  | Default Value | Range                                  | Description                                   |
// |-----------|------------------|---------------|----------------------------------------|-----------------------------------------------|
// | byte      | 1                | 0             | -128 to 127                            | 8-bit signed integer                          |
// | short     | 2                | 0             | -32,768 to 32,767                      | 16-bit signed integer                         |
// | int       | 4                | 0             | -2^31 to 2^31 - 1                      | 32-bit signed integer                         |
// | long      | 8                | 0L            | -2^63 to 2^63 - 1                      | 64-bit signed integer                         |
// | float     | 4                | 0.0f          | Depends on value                       | Single-precision 32-bit floating-point        |
// | double    | 8                | 0.0           | Depends on value                       | Double-precision 64-bit floating-point        |
// | char      | 2                | '\u0000'      | 0 to 65,535 (Unicode)                  | 16-bit Unicode character                      |
// | boolean   | 1                | false         | true or false                          | Represents a true or false value              |

public class DataTypes {
    public static void main(String[] args) {
        // Byte - 1 byte, range from -128 to 127
        byte b = 100; // 8-bit signed integer
        System.out.println("Byte value: " + b);
        
        // Short - 2 bytes, range from -32,768 to 32,767
        short s = 10000; // 16-bit signed integer
        System.out.println("Short value: " + s);
        
        // Int - 4 bytes, range from -2^31 to 2^31 - 1
        int i = 100000; // 32-bit signed integer
        System.out.println("Int value: " + i);
        
        // Long - 8 bytes, range from -2^63 to 2^63 - 1
        long l = 1000000000L; // 64-bit signed integer, 'L' denotes a long literal
        System.out.println("Long value: " + l);
        
        // Float - 4 bytes, single-precision floating-point, range of 7 digits precision
        float f = 3.14f; // 'f' denotes a float literal (by default it's double)
        System.out.println("Float value: " + f);
        
        // Double - 8 bytes, double-precision floating-point, range of 15 digits precision
        double d = 3.14159; // Double precision floating-point number
        System.out.println("Double value: " + d);
        
        // Char - 2 bytes, represents a single character (Unicode)
        char c = 'A'; // Unicode value of character 'A'
        System.out.println("Char value: " + c);
        
        // Boolean - Represents true or false value
        boolean flag = true; // Boolean value (can be true or false)
        System.out.println("Boolean value: " + flag);
    }
}
