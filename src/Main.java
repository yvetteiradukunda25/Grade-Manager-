import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Test with valid inputs
            GradeManager validScores;
            validScores = new GradeManager(56.0, 23.9, 82.1,73.5);
            validScores.sumOfMarks();
            validScores.ascendingSortedMarks();
            validScores.descendingSortedMarks();

            // Test with null input for constructor
            try {
                GradeManager nullScores = new GradeManager((Double[]) null);
                nullScores.sumOfMarks();
                nullScores.descendingSortedMarks();
            } catch (IllegalArgumentException e) {
                System.err.println("Error creating GradeManager: " + e.getMessage());
            }


            // Test with empty marks

            GradeManager emptyScores = new GradeManager();
            emptyScores.sumOfMarks();
            emptyScores.descendingSortedMarks();

        } catch (Exception e) {
            System.err.println("An unexpected error occurred in main: " + e.getMessage());
        } finally {
            System.out.println("\nEnd of testing.");
            scanner.close();
        }
    }
}