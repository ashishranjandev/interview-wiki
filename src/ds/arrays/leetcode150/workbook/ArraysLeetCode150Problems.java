package ds.arrays.leetcode150.workbook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class ArraysLeetCode150Problems {
    public static void main(String[] args) {
        ArraysLeetCode150Problems arraysLeetCode150Problems = new ArraysLeetCode150Problems();

        // Problem 1: Duplicate Integer
        int[] nums1 = {1, 2, 3, 3};
        boolean expectedOutput1 = true;
        boolean actualOutput1 = arraysLeetCode150Problems.containsDuplicate(nums1);
        System.out.println("Problem 1 - Test Case 1");
        System.out.println("Expected Output: " + expectedOutput1);
        System.out.println("Actual Output: " + actualOutput1);
        System.out.println();

        int[] nums2 = {1, 2, 3, 4};
        boolean expectedOutput2 = false;
        boolean actualOutput2 = arraysLeetCode150Problems.containsDuplicate(nums2);
        System.out.println("Problem 1 - Test Case 2");
        System.out.println("Expected Output: " + expectedOutput2);
        System.out.println("Actual Output: " + actualOutput2);
        System.out.println();

        // Problem 2: Is Anagram
        String s1 = "racecar";
        String t1 = "carrace";
        boolean expectedOutput3 = true;
        boolean actualOutput3 = arraysLeetCode150Problems.isAnagram(s1, t1);
        System.out.println("Problem 2 - Test Case 1");
        System.out.println("Expected Output: " + expectedOutput3);
        System.out.println("Actual Output: " + actualOutput3);
        System.out.println();

        String s2 = "jar";
        String t2 = "jam";
        boolean expectedOutput4 = false;
        boolean actualOutput4 = arraysLeetCode150Problems.isAnagram(s2, t2);
        System.out.println("Problem 2 - Test Case 2");
        System.out.println("Expected Output: " + expectedOutput4);
        System.out.println("Actual Output: " + actualOutput4);
        System.out.println();

        // Problem 3: Two Integer Sum
        int[] nums3 = {3, 4, 5, 6};
        int target1 = 7;
        int[] expectedOutput5 = {0, 1};
        int[] actualOutput5 = arraysLeetCode150Problems.twoSum(nums3, target1);
        System.out.println("Problem 3 - Test Case 1");
        System.out.println("Expected Output: " + Arrays.toString(expectedOutput5));
        System.out.println("Actual Output: " + Arrays.toString(actualOutput5));
        System.out.println();

        int[] nums4 = {4, 5, 6};
        int target2 = 10;
        int[] expectedOutput6 = {0, 2};
        int[] actualOutput6 = arraysLeetCode150Problems.twoSum(nums4, target2);
        System.out.println("Problem 3 - Test Case 2");
        System.out.println("Expected Output: " + Arrays.toString(expectedOutput6));
        System.out.println("Actual Output: " + Arrays.toString(actualOutput6));
        System.out.println();

        int[] nums5 = {5, 5};
        int target3 = 10;
        int[] expectedOutput7 = {0, 1};
        int[] actualOutput7 = arraysLeetCode150Problems.twoSum(nums5, target3);
        System.out.println("Problem 3 - Test Case 3");
        System.out.println("Expected Output: " + Arrays.toString(expectedOutput7));
        System.out.println("Actual Output: " + Arrays.toString(actualOutput7));
        System.out.println();

        // Problem 4: Anagram Groups
        String[] strs1 = {"act", "pots", "tops", "cat", "stop", "hat"};
        List<List<String>> expectedOutput8 = Arrays.asList(
                Arrays.asList("hat"),
                Arrays.asList("act", "cat"),
                Arrays.asList("stop", "pots", "tops")
        );
        List<List<String>> actualOutput8 = arraysLeetCode150Problems.groupAnagrams(strs1);
        System.out.println("Problem 4 - Test Case 1");
        System.out.println("Expected Output: " + expectedOutput8);
        System.out.println("Actual Output: " + actualOutput8);
        System.out.println();

        String[] strs2 = {"x"};
        List<List<String>> expectedOutput9 = Arrays.asList(
                Arrays.asList("x")
        );
        List<List<String>> actualOutput9 = arraysLeetCode150Problems.groupAnagrams(strs2);
        System.out.println("Problem 4 - Test Case 2");
        System.out.println("Expected Output: " + expectedOutput9);
        System.out.println("Actual Output: " + actualOutput9);
        System.out.println();

        String[] strs3 = {""};
        List<List<String>> expectedOutput10 = Arrays.asList(
                Arrays.asList("")
        );
        List<List<String>> actualOutput10 = arraysLeetCode150Problems.groupAnagrams(strs3);
        System.out.println("Problem 4 - Test Case 3");
        System.out.println("Expected Output: " + expectedOutput10);
        System.out.println("Actual Output: " + actualOutput10);
        System.out.println();

        // Problem 5: Top K Elements in List
        int[] nums6 = {1, 2, 2, 3, 3, 3};
        int k1 = 2;
        int[] expectedOutput11 = {2, 3};
        int[] actualOutput11 = arraysLeetCode150Problems.topKFrequent(nums6, k1);
        System.out.println("Problem 5 - Test Case 1");
        System.out.println("Expected Output: " + Arrays.toString(expectedOutput11));
        System.out.println("Actual Output: " + Arrays.toString(actualOutput11));
        System.out.println();

        int[] nums7 = {7, 7};
        int k2 = 1;
        int[] expectedOutput12 = {7};
        int[] actualOutput12 = arraysLeetCode150Problems.topKFrequent(nums7, k2);
        System.out.println("Problem 5 - Test Case 2");
        System.out.println("Expected Output: " + Arrays.toString(expectedOutput12));
        System.out.println("Actual Output: " + Arrays.toString(actualOutput12));
        System.out.println();

        // Problem 6: String Encode and Decode
        List<String> strs4 = Arrays.asList("neet", "code", "love", "you");
        List<String> expectedOutput13 = Arrays.asList("neet", "code", "love", "you");
        List<String> actualOutput13 = arraysLeetCode150Problems.decode(arraysLeetCode150Problems.encode(strs4));
        System.out.println("Problem 6 - Test Case 1");
        System.out.println("Expected Output: " + expectedOutput13);
        System.out.println("Actual Output: " + actualOutput13);
        System.out.println();

        List<String> strs5 = Arrays.asList("we", "say", ":", "yes");
        List<String> expectedOutput14 = Arrays.asList("we", "say", ":", "yes");
        List<String> actualOutput14 = arraysLeetCode150Problems.decode(arraysLeetCode150Problems.encode(strs5));
        System.out.println("Problem 6 - Test Case 2");
        System.out.println("Expected Output: " + expectedOutput14);
        System.out.println("Actual Output: " + actualOutput14);
        System.out.println();

        // Problem 7: Products of Array Discluding Self
        int[] nums8 = {1, 2, 4, 6};
        int[] expectedOutput15 = {48, 24, 12, 8};
        int[] actualOutput15 = productExceptSelf(nums8);
        System.out.println("Problem 7 - Test Case 1");
        System.out.println("Expected Output: " + Arrays.toString(expectedOutput15));
        System.out.println("Actual Output: " + Arrays.toString(actualOutput15));
        System.out.println();

        int[] nums9 = {-1, 0, 1, 2, 3};
        int[] expectedOutput16 = {0, -6, 0, 0, 0};
        int[] actualOutput16 = productExceptSelf(nums9);
        System.out.println("Problem 7 - Test Case 2");
        System.out.println("Expected Output: " + Arrays.toString(expectedOutput16));
        System.out.println("Actual Output: " + Arrays.toString(actualOutput16));
        System.out.println();

        char[][] board1 = {
                {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
                {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean expectedBoolOutput1 = true;
        boolean actualBoolOutput1 = arraysLeetCode150Problems.isValidSudoku(board1);
        System.out.println("Problem 1 - Test Case 1");
        System.out.println("Expected Output: " + expectedBoolOutput1);
        System.out.println("Actual Output: " + actualBoolOutput1);
        System.out.println();

        char[][] board2 = {
                {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '9', '1', '.', '.', '.', '.', '.', '3'},
                {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean expectedBoolOutput2 = false;
        boolean actualBoolOutput2 = arraysLeetCode150Problems.isValidSudoku(board2);
        System.out.println("Problem 1 - Test Case 2");
        System.out.println("Expected Output: " + expectedBoolOutput2);
        System.out.println("Actual Output: " + actualBoolOutput2);
        System.out.println();

        // Problem 2: Longest Consecutive Sequence
        nums1 = new int[]{2, 20, 4, 10, 3, 4, 5};
        int expectedBoolOutput3 = 4;
        int actualBoolOutput3 = longestConsecutive(nums1);
        System.out.println("Problem 2 - Test Case 1");
        System.out.println("Expected Output: " + expectedOutput3);
        System.out.println("Actual Output: " + actualOutput3);
        System.out.println();

        nums2 = new int[]{0, 3, 2, 5, 4, 6, 1, 1};
        int expectedBoolOutput4 = 7;
        int actualBoolOutput4 = longestConsecutive(nums2);
        System.out.println("Problem 2 - Test Case 2");
        System.out.println("Expected Output: " + expectedBoolOutput4);
        System.out.println("Actual Output: " + actualBoolOutput4);
        System.out.println();
    }

    // Problem 1: Duplicate Integer

    /**
     * Duplicate Integer
     * Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.
     *
     * Example 1:
     *
     * Input: nums = [1, 2, 3, 3]
     *
     * Output: true
     *
     * Example 2:
     *
     * Input: nums = [1, 2, 3, 4]
     *
     * Output: false
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        return false;
    }

    // Problem 2: Is Anagram

    /**
     * Is Anagram
     * Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
     *
     * An anagram is a string that contains the exact same characters as another string, but the order of the characters
     * can be different.
     *
     * Example 1:
     *
     * Input: s = "racecar", t = "carrace"
     *
     * Output: true
     * Example 2:
     *
     * Input: s = "jar", t = "jam"
     *
     * Output: false
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        return true;
    }

    // Problem 3: Two Integer Sum

    /**
     * Two Integer Sum
     * Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] ==
     * target and i != j.
     *
     * You may assume that every input has exactly one pair of indices i and j that satisfy the condition.
     *
     * Return the answer with the smaller index first.
     *
     * Example 1:
     *
     * Input:
     * nums = [3,4,5,6], target = 7
     *
     * Output: [0,1]
     * Explanation: nums[0] + nums[1] == 7, so we return [0, 1].
     *
     * Example 2:
     *
     * Input: nums = [4,5,6], target = 10
     *
     * Output: [0,2]
     * Example 3:
     *
     * Input: nums = [5,5], target = 10
     *
     * Output: [0,1]
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        throw new IllegalArgumentException("No two sum solution");
    }

    // Problem 4: Anagram Groups
    /**
     * Anagram Groups
     * Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.
     *
     * An anagram is a string that contains the exact same characters as another string, but the order of the characters
     * can be different.
     *
     * Example 1:
     *
     * Input: strs = ["act","pots","tops","cat","stop","hat"]
     *
     * Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
     * Example 2:
     *
     * Input: strs = ["x"]
     *
     * Output: [["x"]]
     * Example 3:
     *
     * Input: strs = [""]
     *
     * Output: [[""]]
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        return null;
    }

    // Problem 5: Top K Elements in List
    /**
     * Top K Elements in List
     * Given an integer array nums and an integer k, return the k most frequent elements within the array.
     *
     * The test cases are generated such that the answer is always unique.
     *
     * You may return the output in any order.
     *
     * Example 1:
     *
     * Input: nums = [1,2,2,3,3,3], k = 2
     *
     * Output: [2,3]
     * Example 2:
     *
     * Input: nums = [7,7], k = 1
     *
     * Output: [7]
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        return new int[2];
    }

    // Problem 6: String Encode and Decode

    /**
     * String Encode and Decode
     * Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the
     * original list of strings.
     *
     * Please implement encode and decode
     *
     * Example 1:
     *
     * Input: ["neet","code","love","you"]
     *
     * Output:["neet","code","love","you"]
     * Example 2:
     *
     * Input: ["we","say",":","yes"]
     *
     * Output: ["we","say",":","yes"]
     *
     * @param strs
     * @return
     */
    public static String encode(List<String> strs) {
        return null;
    }


    public static List<String> decode(String s) {

        return null;
    }

    // Problem 7: Product of Array Except Self

    /**
     * Products of Array Discluding Self
     * Given an integer array nums, return an array output where output[i] is the product of all the elements of nums
     * except nums[i].
     *
     * Each product is guaranteed to fit in a 32-bit integer.
     *
     * Follow-up: Could you solve it in
     * O
     * (
     * n
     * )
     * O(n) time without using the division operation?
     *
     * Example 1:
     *
     * Input: nums = [1,2,4,6]
     *
     * Output: [48,24,12,8]
     * Example 2:
     *
     * Input: nums = [-1,0,1,2,3]
     *
     * Output: [0,-6,0,0,0]
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        return new int[2];
    }

    // Problem 8: Valid Sudoku
    /**
     * Valid Sudoku
     * You are given a a 9 x 9 Sudoku board board. A Sudoku board is valid if the following rules are followed:
     *
     * Each row must contain the digits 1-9 without duplicates.
     * Each column must contain the digits 1-9 without duplicates.
     * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without duplicates.
     * Return true if the Sudoku board is valid, otherwise return false
     *
     * Note: A board does not need to be full or be solvable to be valid.
     *
     * Example 1:
     *
     *
     *
     * Input: board =
     * [["1","2",".",".","3",".",".",".","."],
     *  ["4",".",".","5",".",".",".",".","."],
     *  [".","9","8",".",".",".",".",".","3"],
     *  ["5",".",".",".","6",".",".",".","4"],
     *  [".",".",".","8",".","3",".",".","5"],
     *  ["7",".",".",".","2",".",".",".","6"],
     *  [".",".",".",".",".",".","2",".","."],
     *  [".",".",".","4","1","9",".",".","8"],
     *  [".",".",".",".","8",".",".","7","9"]]
     *
     * Output: true
     * Example 2:
     *
     * Input: board =
     * [["1","2",".",".","3",".",".",".","."],
     *  ["4",".",".","5",".",".",".",".","."],
     *  [".","9","1",".",".",".",".",".","3"],
     *  ["5",".",".",".","6",".",".",".","4"],
     *  [".",".",".","8",".","3",".",".","5"],
     *  ["7",".",".",".","2",".",".",".","6"],
     *  [".",".",".",".",".",".","2",".","."],
     *  [".",".",".","4","1","9",".",".","8"],
     *  [".",".",".",".","8",".",".","7","9"]]
     *
     * Output: false
     * Explanation: There are two 1's in the top-left 3x3 sub-box.
     *
     * @param board
     * @return
     */
    public static boolean isValidSudoku(char[][] board) {
        return true;
    }

    // Problem 9: Longest Consecutive Sequence

    /**
     * Longest Consecutive Sequence
     * Given an array of integers nums, return the length of the longest consecutive sequence of elements.
     *
     * A consecutive sequence is a sequence of elements in which each element is exactly 1 greater than the previous element.
     *
     * You must write an algorithm that runs in O(n) time.
     *
     * Example 1:
     *
     * Input: nums = [2,20,4,10,3,4,5]
     *
     * Output: 4
     * Explanation: The longest consecutive sequence is [2, 3, 4, 5].
     *
     * Example 2:
     *
     * Input: nums = [0,3,2,5,4,6,1,1]
     *
     * Output: 7
     *
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        return -1;
    }
}
