import java.util.Arrays;

class InvalidGradeException extends IllegalArgumentException {
    public InvalidGradeException(String message) {
        super(message);
    }
}
public class GradeManager {
    private Double[] marks;
    private double sum;

    // Constructor declaration
    GradeManager(Double... marks) {
        if (marks == null) {
            throw new IllegalArgumentException("Marks array cannot be null.");
        }
        for (Double mark : marks) {
            if (mark == null || mark < 0 || mark > 100) {
                throw new InvalidGradeException("All marks must be between 0 and 100 (inclusive).");
            }
        }
        this.marks = marks;
    }

    // Adding grades
    public void sumOfMarks() {
        // To use reduce method, we convert the array into a stream
        if (marks == null || marks.length == 0) {
            System.out.println("No marks to calculate the sum for.");
            this.sum = 0.0;
            return;
        }
        try {
            this.sum = Arrays.stream(marks)
                    .mapToDouble(Double::doubleValue)
                    .reduce(0.0, Double::sum);
            System.out.println("The total of marks: " + sum);
        } catch (Exception e) {
            System.err.println("An error occurred while calculating the sum: " + e.getMessage());
            this.sum = 0.0;
            // Reset sum in case of error
        }
    }

    // Sorting out the marks in ascending order
    public void ascendingSortedMarks() {
        if (marks == null || marks.length == 0) {
            System.out.println("No marks to sort.");
            return;
        }
        try {
            Double[] sortedMarks = Arrays.copyOf(marks, marks.length);
            Arrays.sort(sortedMarks);
            System.out.println("Marks (Ascending): " + Arrays.toString(sortedMarks));
        } catch (Exception e) {
            System.err.println("An error occurred while sorting in ascending order: " + e.getMessage());
        }
    }

    // Sorting out the marks in descending order
    public void descendingSortedMarks() {
        if (marks == null || marks.length == 0) {
            System.out.println("No marks to sort.");
            return;
        }
        try {
            Double[] sortedMarks = Arrays.copyOf(marks, marks.length);
            Arrays.sort(sortedMarks, (a, b) -> Double.compare(b, a));
            System.out.println("Marks (Descending): " + Arrays.toString(sortedMarks));
        } catch (Exception e) {
            System.err.println("An error occurred while sorting in descending order: " + e.getMessage());
        } finally {
            System.out.println("\n--- Finally Block in Main ---");
            System.out.println("End of testing.");
        }
    }
}


