import java.util.Scanner;

public class Quadratic{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter coefficient a: ");
        double a = input.nextDouble();

        System.out.print("Enter coefficient b: ");
        double b = input.nextDouble();

        System.out.print("Enter coefficient c: ");
        double c = input.nextDouble();

        double discriminant = b * b - 4 * a * c;

        if (a == 0) {
            System.out.println("This is not a quadratic equation (a cannot be zero).");
        } else if (discriminant > 0) {
     
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("The equation has two real roots:");
            System.out.println("x1 = " + root1);
            System.out.println("x2 = " + root2);
        } else if (discriminant == 0) {
        
            double root = -b / (2 * a);
            System.out.println("The equation has one real root:");
            System.out.println("x = " + root);
        } else {
        
            System.out.println("The equation has no real solutions (discriminant is negative).");
        }

        input.close();
    }
}
