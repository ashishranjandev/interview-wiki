package algo.slidingwindow.leetcode150;

import java.util.*;

public class SlidingWindowLeetCodeProblems150 {

    public static void main(String[] args) {
        // Problem 1: Buy and Sell Crypto
        System.out.println("Problem 1: Buy and Sell Crypto");
        int[] prices1 = {10, 1, 5, 6, 7, 1};
        System.out.println("Input: prices = [10, 1, 5, 6, 7, 1]");
        System.out.println("Expected Output: 6");
        System.out.println("Actual Output: " + maxProfit(prices1));
        System.out.println();

        int[] prices2 = {10, 8, 7, 5, 2};
        System.out.println("Input: prices = [10, 8, 7, 5, 2]");
        System.out.println("Expected Output: 0");
        System.out.println("Actual Output: " + maxProfit(prices2));
        System.out.println();

        // Problem 2: Longest Substring Without Duplicates
        System.out.println("Problem 2: Longest Substring Without Duplicates");
        String s1 = "zxyzxyz";
        System.out.println("Input: s = \"zxyzxyz\"");
        System.out.println("Expected Output: 3");
        System.out.println("Actual Output: " + lengthOfLongestSubstring(s1));
        System.out.println();

        String s2 = "xxxx";
        System.out.println("Input: s = \"xxxx\"");
        System.out.println("Expected Output: 1");
        System.out.println("Actual Output: " + lengthOfLongestSubstring(s2));
        System.out.println();

        // Problem 3: Longest Repeating Substring With Replacement
        System.out.println("Problem 3: Longest Repeating Substring With Replacement");
        String s3 = "XYYX";
        int k1 = 2;
        System.out.println("Input: s = \"XYYX\", k = 2");
        System.out.println("Expected Output: 4");
        System.out.println("Actual Output: " + characterReplacement(s3, k1));
        System.out.println();

        String s4 = "AAABABB";
        int k2 = 1;
        System.out.println("Input: s = \"AAABABB\", k = 1");
        System.out.println("Expected Output: 5");
        System.out.println("Actual Output: " + characterReplacement(s4, k2));
        System.out.println();

        // Problem 4: Permutation String
        System.out.println("Problem 4: Permutation String");
        String s5 = "abc";
        String s6 = "lecabee";
        System.out.println("Input: s1 = \"abc\", s2 = \"lecabee\"");
        System.out.println("Expected Output: true");
        System.out.println("Actual Output: " + checkInclusion(s5, s6));
        System.out.println();

        String s7 = "abc";
        String s8 = "lecaabee";
        System.out.println("Input: s1 = \"abc\", s2 = \"lecaabee\"");
        System.out.println("Expected Output: false");
        System.out.println("Actual Output: " + checkInclusion(s7, s8));
        System.out.println();

        // Problem 5: Minimum Window With Characters
        System.out.println("Problem 5: Minimum Window With Characters");
        String s9 = "OUZODYXAZV";
        String t1 = "XYZ";
        System.out.println("Input: s = \"OUZODYXAZV\", t = \"XYZ\"");
        System.out.println("Expected Output: \"YXAZ\"");
        System.out.println("Actual Output: " + minWindow(s9, t1));
        System.out.println();

        String s10 = "xyz";
        String t2 = "xyz";
        System.out.println("Input: s = \"xyz\", t = \"xyz\"");
        System.out.println("Expected Output: \"xyz\"");
        System.out.println("Actual Output: " + minWindow(s10, t2));
        System.out.println();

        String s11 = "x";
        String t3 = "xy";
        System.out.println("Input: s = \"x\", t = \"xy\"");
        System.out.println("Expected Output: \"\"");
        System.out.println("Actual Output: " + minWindow(s11, t3));
        System.out.println();

        // Problem 6: Sliding Window Maximum
        System.out.println("Problem 6: Sliding Window Maximum");

        // Test Case 1
        int[] nums1 = {1, 2, 1, 0, 4, 2, 6};
        int k3 = 3;
        System.out.println("Input: nums = [1, 2, 1, 0, 4, 2, 6], k = 3");
        System.out.println("Expected Output: [2, 2, 4, 4, 6]");
        System.out.println("Actual Output: " + Arrays.toString(maxSlidingWindow(nums1, k3)));
        System.out.println();

        // Test Case 2
        int[] nums2 = {1, 3, 1, 2, 0, 5};
        int k4 = 3;
        System.out.println("Input: nums = [1, 3, 1, 2, 0, 5], k = 3");
        System.out.println("Expected Output: [3, 3, 2, 5]");
        System.out.println("Actual Output: " + Arrays.toString(maxSlidingWindow(nums2, k4)));
        System.out.println();
    }

    // Problem 1: Buy and Sell Crypto

    /**
     * Buy and Sell Crypto
     * You are given an integer array prices where prices[i] is the price of NeetCoin on the ith day.
     *
     * You may choose a single day to buy one NeetCoin and choose a different day in the future to sell it.
     *
     * Return the maximum profit you can achieve. You may choose to not make any transactions, in which case the profit
     * would be 0.
     *
     * Example 1:
     *
     * Input: prices = [10,1,5,6,7,1]
     *
     * Output: 6
     * Explanation: Buy prices[1] and sell prices[4], profit = 7 - 1 = 6.
     *
     * Example 2:
     *
     * Input: prices = [10,8,7,5,2]
     *
     * Output: 0
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    // Problem 2: Longest Substring Without Duplicates

    /**
     * Longest Substring Without Duplicates
     * Given a string s, find the length of the longest substring without duplicate characters.
     *
     * A substring is a contiguous sequence of characters within a string.
     *
     * Example 1:
     *
     * Input: s = "zxyzxyz"
     *
     * Output: 3
     * Explanation: The string "xyz" is the longest without duplicate characters.
     *
     * Example 2:
     *
     * Input: s = "xxxx"
     *
     * Output: 1
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0, left = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    // Problem 3: Longest Repeating Substring With Replacement

    /**
     * Longest Repeating Substring With Replacement
     * You are given a string s consisting of only uppercase english characters and an integer k. You can choose up to k
     * characters of the string and replace them with any other uppercase English character.
     *
     * After performing at most k replacements, return the length of the longest substring which contains only one
     * distinct character.
     *
     * Example 1:
     *
     * Input: s = "XYYX", k = 2
     *
     * Output: 4
     * Explanation: Either replace the 'X's with 'Y's, or replace the 'Y's with 'X's.
     *
     * Example 2:
     *
     * Input: s = "AAABABB", k = 1
     *
     * Output: 5
     *
     * @param s
     * @param k
     * @return
     */
    public static int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxCount = 0, maxLength = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(right) - 'A']);
            while (right - left + 1 - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    // Problem 4: Permutation String

    /**
     * Permutation String
     * You are given two strings s1 and s2.
     *
     * Return true if s2 contains a permutation of s1, or false otherwise. That means if a permutation of s1 exists as a
     * substring of s2, then return true.
     *
     * Both strings only contain lowercase letters.
     *
     * Example 1:
     *
     * Input: s1 = "abc", s2 = "lecabee"
     *
     * Output: true
     * Explanation: The substring "cab" is a permutation of "abc" and is present in "lecabee".
     *
     * Example 2:
     *
     * Input: s1 = "abc", s2 = "lecaabee"
     *
     * Output: false
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (Arrays.equals(s1Count, s2Count)) return true;
            s2Count[s2.charAt(i + s1.length()) - 'a']++;
            s2Count[s2.charAt(i) - 'a']--;
        }
        return Arrays.equals(s1Count, s2Count);
    }

    // Problem 5: Minimum Window With Characters

    /**
     * Minimum Window With Characters
     * Given two strings s and t, return the shortest substring of s such that every character in t, including duplicates,
     * is present in the substring. If such a substring does not exist, return an empty string "".
     *
     * You may assume that the correct output is always unique.
     *
     * Example 1:
     *
     * Input: s = "OUZODYXAZV", t = "XYZ"
     *
     * Output: "YXAZ"
     * Explanation: "YXAZ" is the shortest substring that includes "X", "Y", and "Z" from string t.
     *
     * Example 2:
     *
     * Input: s = "xyz", t = "xyz"
     *
     * Output: "xyz"
     * Example 3:
     *
     * Input: s = "x", t = "xy"
     *
     * Output: ""
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        Map<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }
        int required = tCount.size();
        int left = 0, right = 0, formed = 0;
        Map<Character, Integer> windowCounts = new HashMap<>();
        int[] ans = {-1, 0, 0};
        while (right < s.length()) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);
            if (tCount.containsKey(c) && windowCounts.get(c).intValue() == tCount.get(c).intValue()) {
                formed++;
            }
            while (left <= right && formed == required) {
                c = s.charAt(left);
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (tCount.containsKey(c) && windowCounts.get(c).intValue() < tCount.get(c).intValue()) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    /**
     * Sliding Window Maximum
     * You are given an array of integers nums and an integer k. There is a sliding window of size k that starts at the
     * left edge of the array. The window slides one position to the right until it reaches the right edge of the array.
     *
     * Return a list that contains the maximum element in the window at each step.
     *
     * Example 1:
     *
     * Input: nums = [1,2,1,0,4,2,6], k = 3
     *
     * Output: [2,2,4,4,6]
     *
     * Explanation:
     * Window position            Max
     * ---------------           -----
     * [1  2  1] 0  4  2  6        2
     *  1 [2  1  0] 4  2  6        2
     *  1  2 [1  0  4] 2  6        4
     *  1  2  1 [0  4  2] 6        4
     *  1  2  1  0 [4  2  6]       6
     *
     * Finds the maximum element in each sliding window of size k.
     *
     * @param nums the array of integers
     * @param k the size of the sliding window
     * @return an array containing the maximum element in each sliding window
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove elements out of the current window
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // Remove elements smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add the current element at the end of the deque
            deque.offer(i);

            // The front of the deque is the largest element in the current window
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }

        return result;
    }
}
