import java.util.Scanner;

class Student {
    String usn;
    String name;
    int n;               
    int[] credits;        
    int[] marks;         

    void acceptDetails() {
        Scanner sc= new Scanner(System.in);

        System.out.print("Enter USN: ");
        usn = sc.nextLine();

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter number of subjects: ");
        n = sc.nextInt();

        credits = new int[n];
        marks = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter credits for subject " + (i + 1) + ": ");
            credits[i] = sc.nextInt();

            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
    }

    double calculateSGPA() {
        int totalCredits = 0;
        double totalGradePoints = 0.0;

        for (int i = 0; i < n; i++) {
            int gradePoint;

            if (marks[i] >= 90)
                gradePoint = 10;
            else if (marks[i] >= 80)
                gradePoint = 9;
            else if (marks[i] >= 70)
                gradePoint = 8;
            else if (marks[i] >= 60)
                gradePoint = 7;
            else if (marks[i] >= 50)
                gradePoint = 6;
            else if (marks[i] >= 40)
                gradePoint = 5;
            else
                gradePoint = 0;

            totalGradePoints += gradePoint * credits[i];
            totalCredits += credits[i];
        }

        return totalCredits == 0 ? 0 : totalGradePoints / totalCredits;
    }

    void displayDetails() {
        System.out.println("\n--- Student Details ---");
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
        System.out.println("No. of Subjects: " + n);

        System.out.println("\nSub\tCredits\tMarks");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + "\t" + credits[i] + "\t" + marks[i]);
        }

        System.out.printf("\nSGPA: %.2f\n", calculateSGPA());
    }
}

public class StudentSGPA {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.acceptDetails();
        s1.displayDetails();
    }
}