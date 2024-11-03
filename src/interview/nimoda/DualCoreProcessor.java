package interview.nimoda;

import java.util.Arrays;

public class DualCoreProcessor {

    public static void main(String[] args) {
        int[] times = {10, 21, 10, 21, 10};
        int[] result = assignProcesses(times);
        System.out.println("Core 1 Total Time: " + result[0]);
        System.out.println("Core 2 Total Time: " + result[1]);
    }


    /**
     * We use a dynamic programming (DP) approach to solve this problem. The idea is to keep track of the maximum sum of
     * times for each core as we assign processes, considering the latch mechanism.
     *
     * Detailed Steps
     * Dynamic Programming Table Setup:
     * We use a 2D DP array dp where:
     * dp[i][0] represents the maximum sum of times for core 1 when the latch is with core 1 after assigning the first i
     * processes.
     * dp[i][1] represents the maximum sum of times for core 2 when the latch is with core 2 after assigning the first i
     * processes.
     * Initialization:
     * Initialize the dp array with zeros. This represents the initial state where no processes have been assigned yet.
     * Filling the DP Table:
     * Iterate over each process from 1 to n (where n is the number of processes).
     * For each process i, we have two scenarios to consider:
     * Latch with Core 1:
     * Assign the process to core 1 and give the latch to core 2: dp[i][0] = dp[i-1][1] + times[i-1]
     * Assign the process to core 2 and retain the latch with core 1: dp[i][0] = dp[i-1][0]
     * Take the maximum of these two options.
     * Latch with Core 2:
     * Assign the process to core 2 and give the latch to core 1: dp[i][1] = dp[i-1][0] + times[i-1]
     * Assign the process to core 1 and retain the latch with core 2: dp[i][1] = dp[i-1][1]
     * Take the maximum of these two options.
     * Result Calculation:
     * After filling the DP table, dp[n][0] and dp[n][1] give us the maximum sums for core 1 and core 2, respectively.
     * Calculate the total sum of all process times.
     * Using the total sum and the values from the DP table, calculate the final sums for core 1 and core 2:
     * core1Sum = (totalSum + dp[n][0] - dp[n][1]) / 2
     * core2Sum = totalSum - core1Sum
     * Returning the Result:
     * Return an array containing the total times for core 1 and core 2.
     * Example Walkthrough
     * Let’s go through an example to see how this approach works in practice.
     *
     * Example: times = [10, 21, 10, 21, 10]
     *
     * Initialization:
     * dp array is initialized with zeros.
     * Filling the DP Table:
     * For i = 1:
     * dp[1][0] = max(dp[0][1] + 10, dp[0][0]) = max(10, 0) = 10
     * dp[1][1] = max(dp[0][0] + 10, dp[0][1]) = max(10, 0) = 10
     * For i = 2:
     * dp[2][0] = max(dp[1][1] + 21, dp[1][0]) = max(31, 10) = 31
     * dp[2][1] = max(dp[1][0] + 21, dp[1][1]) = max(31, 10) = 31
     * Continue this process for all i up to n.
     * Result Calculation:
     * After filling the DP table, dp[5][0] and dp[5][1] give us the maximum sums for core 1 and core 2.
     * Calculate the total sum of all process times: totalSum = 10 + 21 + 10 + 21 + 10 = 72
     * Calculate the final sums for core 1 and core 2:
     * core1Sum = (72 + dp[5][0] - dp[5][1]) / 2
     * core2Sum = 72 - core1Sum
     *
     * @param times
     * @return
     */
    public static int[] assignProcesses(int[] times) {
        int n = times.length;
        int[][] dp = new int[n + 1][2];

        // Initialize the dp array
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }

        // Iterate over each process
        for (int i = 1; i <= n; i++) {
            // If the latch is with core 1
            dp[i][0] = Math.max(dp[i - 1][1] + times[i - 1], dp[i - 1][0]);
            // If the latch is with core 2
            dp[i][1] = Math.max(dp[i - 1][0] + times[i - 1], dp[i - 1][1]);
        }

        // The result is the maximum of the two possible sums
        int core1Total = dp[n][0];
        int core2Total = dp[n][1];

        // Calculate the total time for each core
        int totalSum = Arrays.stream(times).sum();
        int core1Sum = (totalSum + core1Total - core2Total) / 2;
        int core2Sum = totalSum - core1Sum;

        return new int[]{core1Sum, core2Sum};
    }
}

