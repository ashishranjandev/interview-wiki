package algo.dp.leetcode150;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * Returns the minimum cost to reach the top of the staircase.
     *
     * @param cost the array of costs for each step
     * @return the minimum cost to reach the top
     */
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }

    /**
     * Returns the maximum amount of money that can be robbed without alerting the police.
     *
     * @param nums the array of money in each house
     * @return the maximum amount of money that can be robbed
     */
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    /**
     * Returns the maximum amount of money that can be robbed without alerting the police.
     *
     * @param nums the array of money in each house
     * @return the maximum amount of money that can be robbed
     */
    public static int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
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
        int prev1 = 0, prev2 = 0;
        for (int i = start; i <= end; i++) {
            int temp = prev1;
            prev1 = Math.max(prev2 + nums[i], prev1);
            prev2 = temp;
        }
        return prev1;
    }

    /**
     * Returns the longest palindromic substring of the given string.
     *
     * @param s the input string
     * @return the longest palindromic substring
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
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
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    /**
     * Returns the number of palindromic substrings in the given string.
     *
     * @param s the input string
     * @return the number of palindromic substrings
     */
    public static int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            count += expandAroundCenter2(s, i, i); // Odd length palindromes
            count += expandAroundCenter2(s, i, i + 1); // Even length palindromes
        }

        return count;
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
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }

    /**
     * Returns the number of ways to decode the given string.
     *
     * @param s the input string containing only digits
     * @return the number of ways to decode the string
     */
    public static int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));

            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    /**
     * Returns the fewest number of coins needed to make up the exact target amount.
     *
     * @param coins the array of coin denominations
     * @param amount the target amount of money
     * @return the fewest number of coins needed to make up the amount, or -1 if it is impossible
     */
    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * Returns the maximum product of a subarray within the given array.
     *
     * @param nums the input array of integers
     * @return the maximum product of a subarray
     */
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
            minProduct = Math.min(nums[i], minProduct * nums[i]);

            result = Math.max(result, maxProduct);
        }

        return result;
    }

    /**
     * Returns true if the string can be segmented into a space-separated sequence of dictionary words.
     *
     * @param s the input string
     * @param wordDict the list of dictionary words
     * @return true if the string can be segmented, otherwise false
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    /**
     * Returns the length of the longest strictly increasing subsequence.
     *
     * @param nums the input array of integers
     * @return the length of the longest strictly increasing subsequence
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxLength = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    /**
     * Returns true if the array can be partitioned into two subsets with equal sum.
     *
     * @param nums the input array of positive integers
     * @return true if the array can be partitioned, otherwise false
     */
    public static boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // If the total sum is odd, it cannot be partitioned into two equal subsets
        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}
