package JavaBasics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class ColorsWithComparable implements Comparable<ColorsWithComparable>{
    String colorName;

    ColorsWithComparable(String s){
        this.colorName = s;
    }

    @Override
    public int compareTo(ColorsWithComparable o) {
        return this.colorName.length() > o.colorName.length() ? 1 : -1;
    }

    @Override
    public String toString() {
        return "[ColorsWithComparable name = " + this.colorName + "]";
    }
}

class Student{
    int age;
    String name;

    Student(int a, String s){
        this.age = a;
        this.name = s;
    }

    @Override
    public String toString() {
        return "[Student age = " + this.age + ", " + this.name + "]";
    }
}

public class ComparatorComparable {
    public static void main(String[] args) {
        Comparator<Student> comparator = new Comparator<Student>() {
            public int compare(Student o1, Student o2) {
                if(o1.age > o2.age){
                    return 1;
                }
                else {
                    return -1;
                }
            }
        };

        Comparator<Student> comparator1 = (o1, o2) -> o1.name.length() > o2.name.length() ? 1 : -1;

        List<Student> list = new ArrayList<>();
        list.add(new Student(23, "A"));
        list.add(new Student(21, "BC"));
        list.add(new Student(24, "C"));
        list.add(new Student(25, "DE"));
        list.add(new Student(20, "EFG"));

        Collections.sort(list, comparator);

        for(Student s: list){
            System.out.println(s.toString());
        }

        System.out.println("------------------------------------------");

        Collections.sort(list, comparator1);

        // or, Collections.sort(list, (o1, o2) -> o1.name.length() > o2.name.length ? 1 : -1);

        for(Student s: list){
            System.out.println(s.toString());
        }

        System.out.println("------------------------------------------ Now Comparable");

        List<ColorsWithComparable> list1 = new ArrayList<>();
        list1.add(new ColorsWithComparable("Red"));
        list1.add(new ColorsWithComparable("Blue"));
        list1.add(new ColorsWithComparable("Green"));

        Collections.sort(list1);

        for (ColorsWithComparable color: list1)
            System.out.println(color);
    }
}
