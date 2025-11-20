package Project;

import java.util.*;
import CIE.*;
import SEE.*;

public class MainFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        Internals internal[] = new Internals[n];
        External external[] = new External[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));

            System.out.print("USN: ");
            String usn = sc.next();

            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Semester: ");
            int sem = sc.nextInt();

            int inMarks[] = new int[5];
            System.out.println("Enter 5 Internal Marks:");
            for (int j = 0; j < 5; j++)
                inMarks[j] = sc.nextInt();

            internal[i] = new Internals(inMarks);

            int seeMarks[] = new int[5];
            System.out.println("Enter 5 SEE Marks:");
            for (int j = 0; j < 5; j++)
                seeMarks[j] = sc.nextInt();

            external[i] = new External(usn, name, sem, seeMarks);
        }

        System.out.println("\n----- FINAL MARKS -----");
        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1));
            System.out.println("USN: " + external[i].usn);
            System.out.println("Name: " + external[i].name);
            System.out.println("Semester: " + external[i].sem);

            System.out.println("Course-wise Final Marks:");
            for (int j = 0; j < 5; j++) {
                int finalMarks = internal[i].internalMarks[j] + (external[i].seeMarks[j] / 2);
                System.out.println("Course " + (j + 1) + ": " + finalMarks);
            }
        }
    }
}
