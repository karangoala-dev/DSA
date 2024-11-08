package Collections;

//Every java class extends the "Object" class from java so it has toString, equals etc methods from default.
//Here we defined our own and override it.

//equals Method
// The equals method is used to determine if two objects are "equal." By default, the equals method in Java compares the memory addresses of the objects, 
// but we can override it to compare specific fields within the class (like rollNumber in this case).

// Here's how your equals method works:

// Check for Same Reference (this == obj):
// if (this == obj)
//     return true;
// If the this object (the current object) and obj refer to the exact same instance, they’re obviously equal, so we return true right away.

// Check for null or Different Class:
// if (obj == null)
//     return false;
// if (getClass() != obj.getClass())
//     return false;
// If obj is null, the objects can’t be equal, so return false.
// If the classes don’t match, they’re not the same type, so return false.

// Compare rollNumber:
// Student other = (Student) obj;
// if (rollNumber != other.rollNumber)
//     return false;
// Since the object obj passed the previous checks, it’s safe to cast obj to Student.
// Now we compare the rollNumber fields. If they’re different, return false.

// Return true if All Checks Passed:
// return true;
// If none of the above conditions return false, the objects are considered equal.



//hashCode Method
// The hashCode method generates a hash code for an object, which is used in hash-based collections like HashMap and HashSet for quick lookup. 
// The contract between equals and hashCode is that:

// If two objects are equal (i.e., equals returns true), they must have the same hash code.
// If two objects are not equal, they may have different hash codes (but they don’t have to).

// Your hashCode implementation:

// Define a Prime Constant (prime = 31):
// final int prime = 31;
// Using a prime number helps reduce the likelihood of collisions (i.e., different objects having the same hash code).

// Start with an Initial result Value:
// int result = 1;
// result is initialized to 1. This will be the base value that we will increment by adding fields.

// Multiply result by the Prime and Add the Field (rollNumber):
// result = prime * result + rollNumber;
// result is multiplied by prime and then added to the value of rollNumber.
// This calculation ensures that hashCode depends on rollNumber, so two Student objects with the same rollNumber will have the same hash code.
// This hashCode implementation will consistently return the same hash code for Student objects with identical rollNumber values, which is necessary to 
// maintain the hashCode contract.


public class StudentObjectClassMethods {
    
    String name;
    int rollNumber;

    @Override
    public String toString() {
        return "Student [name=" + name + ", rollNumber=" + rollNumber + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + rollNumber;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        StudentObjectClassMethods other = (StudentObjectClassMethods) obj;
        if (rollNumber != other.rollNumber)
            return false;
        return true;
    }

    public StudentObjectClassMethods(String name, int rollNo){
        this.name = name;
        this.rollNumber = rollNo;
    }
}
