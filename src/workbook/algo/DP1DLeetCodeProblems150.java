package workbook.algo;

import java.util.Arrays;
import java.util.List;

public class DP1DLeetCodeProblems150 {

    public static void main(String[] args) {
        // Test Case 1
        int n1 = 2;
        System.out.println("Input: n = 2");
        System.out.println("Expected Output: 2");
        System.out.println("Actual Output: " + climbStairs(n1));
        System.out.println();

        // Test Case 2
        int n2 = 3;
        System.out.println("Input: n = 3");
        System.out.println("Expected Output: 3");
        System.out.println("Actual Output: " + climbStairs(n2));
        System.out.println();

        int[] cost1 = {1, 2, 3};
        System.out.println("Input: cost = [1, 2, 3]");
        System.out.println("Expected Output: 2");
        System.out.println("Actual Output: " + minCostClimbingStairs(cost1));
        System.out.println();

        // Test Case 2
        int[] cost2 = {1, 2, 1, 2, 1, 1, 1};
        System.out.println("Input: cost = [1, 2, 1, 2, 1, 1, 1]");
        System.out.println("Expected Output: 4");
        System.out.println("Actual Output: " + minCostClimbingStairs(cost2));
        System.out.println();

        int[] nums1 = {1, 1, 3, 3};
        System.out.println("Input: nums = [1, 1, 3, 3]");
        System.out.println("Expected Output: 4");
        System.out.println("Actual Output: " + rob(nums1));
        System.out.println();

        // Test Case 2
        int[] nums2 = {2, 9, 8, 3, 6};
        System.out.println("Input: nums = [2, 9, 8, 3, 6]");
        System.out.println("Expected Output: 16");
        System.out.println("Actual Output: " + rob(nums2));
        System.out.println();

        nums1 = new int[]{3, 4, 3};
        System.out.println("Input: nums = [3, 4, 3]");
        System.out.println("Expected Output: 4");
        System.out.println("Actual Output: " + rob2(nums1));
        System.out.println();

        // Test Case 2
        nums2 = new int[]{2, 9, 8, 3, 6};
        System.out.println("Input: nums = [2, 9, 8, 3, 6]");
        System.out.println("Expected Output: 15");
        System.out.println("Actual Output: " + rob2(nums2));
        System.out.println();

        String s1 = "ababd";
        System.out.println("Input: s = \"ababd\"");
        System.out.println("Expected Output: \"bab\" or \"aba\"");
        System.out.println("Actual Output: " + longestPalindrome(s1));
        System.out.println();


        String s2 = "abbc";
        System.out.println("Input: s = \"abbc\"");
        System.out.println("Expected Output: \"bb\"");
        System.out.println("Actual Output: " + longestPalindrome(s2));
        System.out.println();

        String str1 = "abc";
        System.out.println("Input: s = \"abc\"");
        System.out.println("Expected Output: 3");
        System.out.println("Actual Output: " + countSubstrings(str1));
        System.out.println();

        String str2 = "aaa";
        System.out.println("Input: s = \"aaa\"");
        System.out.println("Expected Output: 6");
        System.out.println("Actual Output: " + countSubstrings(str2));
        System.out.println();

        s1 = "12";
        System.out.println("Input: s = \"12\"");
        System.out.println("Expected Output: 2");
        System.out.println("Actual Output: " + numDecodings(s1));
        System.out.println();

        // Test Case 2
        s2 = "01";
        System.out.println("Input: s = \"01\"");
        System.out.println("Expected Output: 0");
        System.out.println("Actual Output: " + numDecodings(s2));
        System.out.println();

        int[] coins1 = {1, 5, 10};
        int amount1 = 12;
        System.out.println("Input: coins = [1, 5, 10], amount = 12");
        System.out.println("Expected Output: 3");
        System.out.println("Actual Output: " + coinChange(coins1, amount1));
        System.out.println();

        // Test Case 2
        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println("Input: coins = [2], amount = 3");
        System.out.println("Expected Output: -1");
        System.out.println("Actual Output: " + coinChange(coins2, amount2));
        System.out.println();

        // Test Case 3
        int[] coins3 = {1};
        int amount3 = 0;
        System.out.println("Input: coins = [1], amount = 0");
        System.out.println("Expected Output: 0");
        System.out.println("Actual Output: " + coinChange(coins3, amount3));
        System.out.println();

        nums1 = new int[]{1, 2, -3, 4};
        System.out.println("Input: nums = [1, 2, -3, 4]");
        System.out.println("Expected Output: 4");
        System.out.println("Actual Output: " + maxProduct(nums1));
        System.out.println();

        // Test Case 2
        nums2 = new int[]{-2, -1};
        System.out.println("Input: nums = [-2, -1]");
        System.out.println("Expected Output: 2");
        System.out.println("Actual Output: " + maxProduct(nums2));
        System.out.println();

        s1 = "neetcode";
        List<String> wordDict1 = Arrays.asList("neet", "code");
        System.out.println("Input: s = \"neetcode\", wordDict = [\"neet\", \"code\"]");
        System.out.println("Expected Output: true");
        System.out.println("Actual Output: " + wordBreak(s1, wordDict1));
        System.out.println();

        // Test Case 2
        s2 = "applepenapple";
        List<String> wordDict2 = Arrays.asList("apple", "pen", "ape");
        System.out.println("Input: s = \"applepenapple\", wordDict = [\"apple\", \"pen\", \"ape\"]");
        System.out.println("Expected Output: true");
        System.out.println("Actual Output: " + wordBreak(s2, wordDict2));
        System.out.println();

        // Test Case 3
        String s3 = "catsincars";
        List<String> wordDict3 = Arrays.asList("cats", "cat", "sin", "in", "car");
        System.out.println("Input: s = \"catsincars\", wordDict = [\"cats\", \"cat\", \"sin\", \"in\", \"car\"]");
        System.out.println("Expected Output: false");
        System.out.println("Actual Output: " + wordBreak(s3, wordDict3));
        System.out.println();

        // Test Case 1
        nums1 = new int[]{9, 1, 4, 2, 3, 3, 7};
        System.out.println("Input: nums = [9, 1, 4, 2, 3, 3, 7]");
        System.out.println("Expected Output: 4");
        System.out.println("Actual Output: " + lengthOfLIS(nums1));
        System.out.println();

        // Test Case 2
        nums2 = new int[]{0, 3, 1, 3, 2, 3};
        System.out.println("Input: nums = [0, 3, 1, 3, 2, 3]");
        System.out.println("Expected Output: 4");
        System.out.println("Actual Output: " + lengthOfLIS(nums2));
        System.out.println();

        // Test Case 1
        nums1 = new int[]{1, 2, 3, 4};
        System.out.println("Input: nums = [1, 2, 3, 4]");
        System.out.println("Expected Output: true");
        System.out.println("Actual Output: " + canPartition(nums1));
        System.out.println();

        // Test Case 2
        nums2 = new int[]{1, 2, 3, 4, 5};
        System.out.println("Input: nums = [1, 2, 3, 4, 5]");
        System.out.println("Expected Output: false");
        System.out.println("Actual Output: " + canPartition(nums2));
        System.out.println();
    }

    /**
     * Returns the number of distinct ways to climb to the top of a staircase with n steps.
     *
     *
     *
     * @param n the number of steps to reach the top
     * @return the number of distinct ways to climb to the top
     */
    public static int climbStairs(int n) {
        return -1;
    }

    /**
     * Returns the minimum cost to reach the top of the staircase.
     *
     * @param cost the array of costs for each step
     * @return the minimum cost to reach the top
     */
    public static int minCostClimbingStairs(int[] cost) {
        return -1;
    }

    /**
     * Returns the maximum amount of money that can be robbed without alerting the police.
     *
     * @param nums the array of money in each house
     * @return the maximum amount of money that can be robbed
     */
    public static int rob(int[] nums) {
        return -1;
    }

    /**
     * Returns the maximum amount of money that can be robbed without alerting the police.
     *
     * @param nums the array of money in each house
     * @return the maximum amount of money that can be robbed
     */
    public static int rob2(int[] nums) {
        return -1;
    }

    /**
     * Helper function to calculate the maximum amount of money that can be robbed in a linear arrangement of houses.
     *
     * @param nums the array of money in each house
     * @param start the starting index
     * @param end the ending index
     * @return the maximum amount of money that can be robbed
     */
    private static int robHelper(int[] nums, int start, int end) {
        return -1;
    }

    /**
     * Returns the longest palindromic substring of the given string.
     *
     * @param s the input string
     * @return the longest palindromic substring
     */
    public static String longestPalindrome(String s) {
        return null;
    }

    /**
     * Expands around the center to find the length of the palindrome.
     *
     * @param s the input string
     * @param left the left index
     * @param right the right index
     * @return the length of the palindrome
     */
    private static int expandAroundCenter(String s, int left, int right) {
        return -1;
    }

    /**
     * Returns the number of palindromic substrings in the given string.
     *
     * @param s the input string
     * @return the number of palindromic substrings
     */
    public static int countSubstrings(String s) {
        return -1;
    }

    /**
     * Expands around the center to count palindromic substrings.
     *
     * @param s the input string
     * @param left the left index
     * @param right the right index
     * @return the number of palindromic substrings
     */
    private static int expandAroundCenter2(String s, int left, int right) {
        return -1;
    }

    /**
     * Returns the number of ways to decode the given string.
     *
     * @param s the input string containing only digits
     * @return the number of ways to decode the string
     */
    public static int numDecodings(String s) {
        return -1;
    }

    /**
     * Returns the fewest number of coins needed to make up the exact target amount.
     *
     * @param coins the array of coin denominations
     * @param amount the target amount of money
     * @return the fewest number of coins needed to make up the amount, or -1 if it is impossible
     */
    public static int coinChange(int[] coins, int amount) {
        return -1;
    }

    /**
     * Returns the maximum product of a subarray within the given array.
     *
     * @param nums the input array of integers
     * @return the maximum product of a subarray
     */
    public static int maxProduct(int[] nums) {
        return -1;
    }

    /**
     * Returns true if the string can be segmented into a space-separated sequence of dictionary words.
     *
     * @param s the input string
     * @param wordDict the list of dictionary words
     * @return true if the string can be segmented, otherwise false
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        return false;
    }

    /**
     * Returns the length of the longest strictly increasing subsequence.
     *
     * @param nums the input array of integers
     * @return the length of the longest strictly increasing subsequence
     */
    public static int lengthOfLIS(int[] nums) {
        return -1;
    }

    /**
     * Returns true if the array can be partitioned into two subsets with equal sum.
     *
     * @param nums the input array of positive integers
     * @return true if the array can be partitioned, otherwise false
     */
    public static boolean canPartition(int[] nums) {
        return false;
    }
}
