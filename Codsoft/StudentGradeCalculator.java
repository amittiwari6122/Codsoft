import java.util.Scanner;
public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();
        String subjectNames[] = new String[subjects];
        int marks[] = new int[subjects];
        int total = 0;
        for (int i = 0; i < subjects; i++) {
            System.out.print("\nEnter name of subject " + (i + 1) + ": ");
            subjectNames[i] = sc.next();
            System.out.print("Enter marks for " + subjectNames[i] + " (out of 100): ");
            marks[i] = sc.nextInt();
            total = total + marks[i];
        }
        double average = total / subjects;
        char grade;
        if (average >= 90)
            grade = 'A';
        else if (average >= 75)
            grade = 'B';
        else if (average >= 60)
            grade = 'C';
        else if (average >= 50)
            grade = 'D';
        else
            grade = 'F';
        System.out.println("\n RESULT");
        for (int i = 0; i < subjects; i++) {
            System.out.println(subjectNames[i] + " : " + marks[i]);
        }
        System.out.println("\nTotal Marks: " + total);
        System.out.println("Average Percentage: " + average + "%");
        System.out.println("Grade: " + grade);
        sc.close();
    }
}