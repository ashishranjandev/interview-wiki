package interview.nimoda;
import java.util.Arrays;
import java.util.Scanner;

public class MinTimeToCompleteProcesses {

    public static void main(String[] args) {
        // Test Case 0
        int[] times0 = {1, 2, 2, 3, 3};
        int expectedOutput0 = 6;
        int actualOutput0 = minTimeToCompleteProcesses(times0.length, times0);
        System.out.println("Test Case 0");
        System.out.println("Expected Output: " + expectedOutput0);
        System.out.println("Actual Output: " + actualOutput0);
        System.out.println();

        // Test Case 1
        int[] times1 = {6, 100};
        int expectedOutput1 = 100;
        int actualOutput1 = minTimeToCompleteProcesses(times1.length, times1);
        System.out.println("Test Case 1");
        System.out.println("Expected Output: " + expectedOutput1);
        System.out.println("Actual Output: " + actualOutput1);
        System.out.println();
    }

    /**
     * Finds the minimum amount of time to complete execution of all processes on 2 processors in parallel.
     *
     * @param N the number of processes
     * @param times the execution times of the processes
     * @return the minimum amount of time to complete execution of all processes
     */
    public static int minTimeToCompleteProcesses(int N, int[] times) {
        // Sort the times in descending order
        Arrays.sort(times);

        // Initialize the two processors' total times
        int processor1 = 0;
        int processor2 = 0;

        // Assign processes to the processors
        for (int i = N - 1; i >= 0; i--) {
            if (processor1 <= processor2) {
                processor1 += times[i];
            } else {
                processor2 += times[i];
            }
        }

        // The total time to complete all processes is the maximum of the two processors' times
        return Math.max(processor1, processor2);
    }
}
