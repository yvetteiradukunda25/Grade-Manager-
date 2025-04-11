//Grade manager class

import java.util.Arrays;

public class GradeManager {
      //changing the datatype into a wrapper class form double to Double
    private Double[] marks;
    private double sum;

    protected   double average;


    //constructor
    GradeManager(Double... marks) {
        this.marks = marks;
    }
   

    
    public void sum() {
       
        this.sum = Arrays.stream(marks).reduce((double) 0, (a, b) -> a + b);
        System.out.println("The total of marks: " + sum);
    }
}
