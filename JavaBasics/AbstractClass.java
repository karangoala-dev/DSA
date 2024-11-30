package JavaBasics;

abstract class Shape {
    // Abstract method
    public abstract double getArea();

    // Concrete method
    public void display() {
        System.out.println("This is a shape.");
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}


public class AbstractClass {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        circle.display();
        System.out.println("Area: " + circle.getArea());
    }
}
