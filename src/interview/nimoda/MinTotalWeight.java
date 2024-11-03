package interview.nimoda;
import java.util.PriorityQueue;

public class MinTotalWeight {

    public static void main(String[] args) {
        // Test Case 1
        int[] weights1 = {10, 20, 30};
        int days1 = 3;
        int expectedOutput1 = 27;
        int actualOutput1 = minTotalWeight(weights1, days1);
        System.out.println("Test Case 1");
        System.out.println("Expected Output: " + expectedOutput1);
        System.out.println("Actual Output: " + actualOutput1);
        System.out.println();

        // Test Case 2
        int[] weights2 = {5, 7, 9};
        int days2 = 2;
        int expectedOutput2 = 12;
        int actualOutput2 = minTotalWeight(weights2, days2);
        System.out.println("Test Case 2");
        System.out.println("Expected Output: " + expectedOutput2);
        System.out.println("Actual Output: " + actualOutput2);
        System.out.println();

        // Test Case 3
        int[] weights3 = {1, 2, 3};
        int days3 = 1;
        int expectedOutput3 = 4;
        int actualOutput3 = minTotalWeight(weights3, days3);
        System.out.println("Test Case 3");
        System.out.println("Expected Output: " + expectedOutput3);
        System.out.println("Actual Output: " + actualOutput3);
        System.out.println();
    }

    /**
     * Finds the minimum possible total weight of the remaining chocolates after a given number of days.
     *
     * @param weights the weights of the chocolates
     * @param days the number of days
     * @return the minimum possible total weight of the remaining chocolates
     */
    public static int minTotalWeight(int[] weights, int days) {
        // Convert weights to a max-heap (using negative values for max-heap behavior)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int weight : weights) {
            maxHeap.offer(weight);
        }

        // Perform the operation for the given number of days
        for (int i = 0; i < days; i++) {
            // Extract the heaviest chocolate
            int heaviest = maxHeap.poll();
            // Eat half of it (floor division by 2)
            int remaining = heaviest / 2;
            // Put the remaining half back into the heap
            maxHeap.offer(remaining);
        }

        // Calculate the total weight of the remaining chocolates
        int totalWeight = 0;
        while (!maxHeap.isEmpty()) {
            totalWeight += maxHeap.poll();
        }

        return totalWeight;
    }
}
