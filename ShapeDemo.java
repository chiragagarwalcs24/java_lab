// Abstract class Shape
abstract class Shape {
    int a, b; // Dimensions (e.g., length & breadth, base & height, etc.)

    // Abstract method to print the area
    abstract void printArea();
}

// Rectangle class
class Rectangle extends Shape {

    Rectangle(int length, int breadth) {
        a = length;
        b = breadth;
    }

    // Override printArea() method
    void printArea() {
        double area = a * b;
        System.out.println("Area of Rectangle: " + area);
    }
}

// Triangle class
class Triangle extends Shape {

    Triangle(int base, int height) {
        a = base;
        b = height;
    }

    // Override printArea() method
    void printArea() {
        double area = 0.5 * a * b;
        System.out.println("Area of Triangle: " + area);
    }
}

// Circle class
class Circle extends Shape {

    Circle(int radius) {
        a = radius;
    }

    // Override printArea() method
    void printArea() {
        double area = Math.PI * a * a;
        System.out.println("Area of Circle: " + area);
    }
}

// Main class to test the program
public class ShapeDemo {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(10, 5);
        Triangle tri = new Triangle(10, 8);
        Circle cir = new Circle(7);

        rect.printArea();
        tri.printArea();
        cir.printArea();
    }
}
