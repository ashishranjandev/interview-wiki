package algo.greedy.leetcode;

public class GreedyLeetCodeProblems {

    public static void main(String...args) {
        GreedyLeetCodeProblems greedyLeetCodeProblems = new GreedyLeetCodeProblems();

        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println();
        System.out.println("Input array is [-2,1,-3,4,-1,2,1,-5,4]");
        System.out.println("Expected output is 6");
        System.out.println("Actual output " + greedyLeetCodeProblems.maxSubArray(nums1));

        int[] nums2 = {1};
        System.out.println();
        System.out.println("Input array is [1]");
        System.out.println("Expected output is 1");
        System.out.println("Actual output " + greedyLeetCodeProblems.maxSubArray(nums2));

        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println();
        System.out.println("Input array is [5, 4, -1, 7, 8]");
        System.out.println("Expected output is 23");
        System.out.println("Actual output " + greedyLeetCodeProblems.maxSubArray(nums3));

        int[] nums4 = {2, 3, 1, 1, 4};
        System.out.println();
        System.out.println("Input array is [2,3,1,1,4]");
        System.out.println("Expected output is true");
        System.out.println("Actual output " + greedyLeetCodeProblems.canJump(nums4));

        int[] nums5 = {3, 2, 1, 0, 4};
        System.out.println();
        System.out.println("Input array is [3,2,1,0,4]");
        System.out.println("Expected output is false");
        System.out.println("Actual output " + greedyLeetCodeProblems.canJump(nums5));

        int[] nums6 = {2, 3, 1, 1, 4};
        System.out.println();
        System.out.println("Input array is [2,3,1,1,4]");
        System.out.println("Expected output is 2");
        System.out.println("Actual output " + greedyLeetCodeProblems.jump(nums6));

        int[] nums7 = {2, 3, 0, 1, 4};
        System.out.println();
        System.out.println("Input array is [2,3,0,1,4]");
        System.out.println("Expected output is 2");
        System.out.println("Actual output " + greedyLeetCodeProblems.jump(nums7));

        int[] gas1 = {1,2,3,4,5};
        int[] cost1 = {3,4,5,1,2};
        System.out.println();
        System.out.println("Input array for gas is [1,2,3,4,5]");
        System.out.println("Input array for gas is [3,4,5,1,2]");
        System.out.println("Expected output is 3");
        System.out.println("Actual output " + greedyLeetCodeProblems.canCompleteCircuit(gas1, cost1));

        int[] gas2 = {2,3,4};
        int[] cost2 = {3,4,3};
        System.out.println();
        System.out.println("Input array for gas is [2,3,4]");
        System.out.println("Input array for gas is [3,4,3]");
        System.out.println("Expected output is -1");
        System.out.println("Actual output " + greedyLeetCodeProblems.canCompleteCircuit(gas2, cost2));

        String s = "()";
        System.out.println();
        System.out.println("Input array is ()");
        System.out.println("Expected output is true");
        System.out.println("Actual output " + greedyLeetCodeProblems.checkValidString(s));

        s = "(*)";
        System.out.println();
        System.out.println("Input array is (*)");
        System.out.println("Expected output is true");
        System.out.println("Actual output " + greedyLeetCodeProblems.checkValidString(s));

        s = "(*))";
        System.out.println();
        System.out.println("Input array is (*))");
        System.out.println("Expected output is true");
        System.out.println("Actual output " + greedyLeetCodeProblems.checkValidString(s));

        s = "(";
        System.out.println();
        System.out.println("Input array is (");
        System.out.println("Expected output is false");
        System.out.println("Actual output " + greedyLeetCodeProblems.checkValidString(s));
    }


    public boolean checkValidString(String s) {
        int maxInLeft = 0;
        int minInLeft = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                maxInLeft++;
                minInLeft++;
            } else if (s.charAt(i) == ')') {
                maxInLeft--;
                minInLeft--;
            } else {
                maxInLeft++;
                minInLeft--;
            }
            if (maxInLeft < 0) {
                return false;
            }
            if (minInLeft < 0) {
                minInLeft = 0;
            }
        }
        return minInLeft == 0;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int[] difference = new int[gas.length];

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
        }
        for (int i = 0; i < cost.length; i++) {
            totalCost += cost[i];
            difference[i] = gas[i] - cost[i];
        }
        if (totalCost > totalGas) {
            return -1;
        }

        int result = 0;
        int totalGasAtPosition = -1;
        for (int i = 0; i < gas.length; i++) {
            if (totalGasAtPosition < 0) {
                result = i;
                totalGasAtPosition = difference[i];
            } else {
                totalGasAtPosition += difference[i];
            }
        }
        return result;
    }

    public int jump(int[] nums) {
        int result = 0;
        int left = 0;
        int right = 0;

        while (right < nums.length - 1) {
            int maxReach = right;
            for (int i = left; i < right + 1; i++) {
                maxReach = Math.max(maxReach, i + nums[i]);
            }
            left = right + 1;
            right = maxReach;
            result += 1;
        }
        return result;
    }

    public boolean canJump(int[] nums) {
        int goalPost = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= goalPost) {
                goalPost = i;
            }
        }
        return goalPost == 0;
    }

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (currentSum < 0) {
                currentSum = 0;
            }
            currentSum += nums[i];
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
}
