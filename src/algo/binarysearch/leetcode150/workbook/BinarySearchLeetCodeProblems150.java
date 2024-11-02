package algo.binarysearch.leetcode150.workbook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class BinarySearchLeetCodeProblems150 {
    public static void main(String[] args) {
        BinarySearchLeetCodeProblems150 binarySearchLeetCodeProblems150 = new BinarySearchLeetCodeProblems150();

        // Problem 1: Search in a Sorted Array
        int[] nums1 = {-1, 0, 2, 4, 6, 8};
        int target1 = 4;
        int expectedOutput1 = 3;
        int actualOutput1 = binarySearchLeetCodeProblems150.search(nums1, target1);
        System.out.println("Problem 1 - Test Case 1");
        System.out.println("Expected Output: " + expectedOutput1);
        System.out.println("Actual Output: " + actualOutput1);
        System.out.println();

        int[] nums2 = {-1, 0, 2, 4, 6, 8};
        int target2 = 3;
        int expectedOutput2 = -1;
        int actualOutput2 = binarySearchLeetCodeProblems150.search(nums2, target2);
        System.out.println("Problem 1 - Test Case 2");
        System.out.println("Expected Output: " + expectedOutput2);
        System.out.println("Actual Output: " + actualOutput2);
        System.out.println();

        // Problem 2: Search 2D Matrix
        int[][] matrix1 = {
                {1, 2, 4, 8},
                {10, 11, 12, 13},
                {14, 20, 30, 40}
        };
        int target3 = 10;
        boolean expectedOutput3 = true;
        boolean actualOutput3 = binarySearchLeetCodeProblems150.searchMatrix(matrix1, target3);
        System.out.println("Problem 2 - Test Case 1");
        System.out.println("Expected Output: " + expectedOutput3);
        System.out.println("Actual Output: " + actualOutput3);
        System.out.println();

        int[][] matrix2 = {
                {1, 2, 4, 8},
                {10, 11, 12, 13},
                {14, 20, 30, 40}
        };
        int target4 = 15;
        boolean expectedOutput4 = false;
        boolean actualOutput4 = binarySearchLeetCodeProblems150.searchMatrix(matrix2, target4);
        System.out.println("Problem 2 - Test Case 2");
        System.out.println("Expected Output: " + expectedOutput4);
        System.out.println("Actual Output: " + actualOutput4);
        System.out.println();

        // Problem 3: Eating Bananas
        int[] piles1 = {1, 4, 3, 2};
        int h1 = 9;
        int expectedOutput5 = 2;
        int actualOutput5 = binarySearchLeetCodeProblems150.minEatingSpeed(piles1, h1);
        System.out.println("Problem 3 - Test Case 1");
        System.out.println("Expected Output: " + expectedOutput5);
        System.out.println("Actual Output: " + actualOutput5);
        System.out.println();

        int[] piles2 = {25, 10, 23, 4};
        int h2 = 4;
        int expectedOutput6 = 25;
        int actualOutput6 = binarySearchLeetCodeProblems150.minEatingSpeed(piles2, h2);
        System.out.println("Problem 3 - Test Case 2");
        System.out.println("Expected Output: " + expectedOutput6);
        System.out.println("Actual Output: " + actualOutput6);
        System.out.println();

        // Problem 5: Find Minimum in Rotated Sorted Array
        int[] nums3 = {3, 4, 5, 6, 1, 2};
        int expectedOutput7 = 1;
        int actualOutput7 = binarySearchLeetCodeProblems150.findMin(nums3);
        System.out.println("Problem 5 - Test Case 1");
        System.out.println("Expected Output: " + expectedOutput7);
        System.out.println("Actual Output: " + actualOutput7);
        System.out.println();

        int[] nums4 = {4, 5, 0, 1, 2, 3};
        int expectedOutput8 = 0;
        int actualOutput8 = binarySearchLeetCodeProblems150.findMin(nums4);
        System.out.println("Problem 5 - Test Case 2");
        System.out.println("Expected Output: " + expectedOutput8);
        System.out.println("Actual Output: " + actualOutput8);
        System.out.println();

        int[] nums5 = {4, 5, 6, 7};
        int expectedOutput9 = 4;
        int actualOutput9 = binarySearchLeetCodeProblems150.findMin(nums5);
        System.out.println("Problem 5 - Test Case 3");
        System.out.println("Expected Output: " + expectedOutput9);
        System.out.println("Actual Output: " + actualOutput9);
        System.out.println();

        // Problem 6: Find Target in Rotated Sorted Array
        int[] nums6 = {3, 4, 5, 6, 1, 2};
        int target5 = 1;
        int expectedOutput10 = 4;
        int actualOutput10 = binarySearchLeetCodeProblems150.searchRotated(nums6, target5);
        System.out.println("Problem 6 - Test Case 1");
        System.out.println("Expected Output: " + expectedOutput10);
        System.out.println("Actual Output: " + actualOutput10);
        System.out.println();

        int[] nums7 = {3, 5, 6, 0, 1, 2};
        int target6 = 4;
        int expectedOutput11 = -1;
        int actualOutput11 = binarySearchLeetCodeProblems150.searchRotated(nums7, target6);
        System.out.println("Problem 6 - Test Case 2");
        System.out.println("Expected Output: " + expectedOutput11);
        System.out.println("Actual Output: " + actualOutput11);
        System.out.println();

        // Problem 7: Time Based Key-Value Store
        TimeMap timeMap = new TimeMap();
        timeMap.set("alice", "happy", 1);
        String expectedOutput12 = "happy";
        String actualOutput12 = timeMap.get("alice", 1);
        System.out.println("Problem 7 - Test Case 1");
        System.out.println("Expected Output: " + expectedOutput12);
        System.out.println("Actual Output: " + actualOutput12);
        System.out.println();

        String expectedOutput13 = "happy";
        String actualOutput13 = timeMap.get("alice", 2);
        System.out.println("Problem 7 - Test Case 2");
        System.out.println("Expected Output: " + expectedOutput13);
        System.out.println("Actual Output: " + actualOutput13);
        System.out.println();

        timeMap.set("alice", "sad", 3);
        String expectedOutput14 = "sad";
        String actualOutput14 = timeMap.get("alice", 3);
        System.out.println("Problem 7 - Test Case 3");
        System.out.println("Expected Output: " + expectedOutput14);
        System.out.println("Actual Output: " + actualOutput14);
        System.out.println();

        // Problem 8: Median of Two Sorted Arrays
        int[] nums8 = {1, 2};
        int[] nums9 = {3};
        double expectedOutput15 = 2.0;
        double actualOutput15 = binarySearchLeetCodeProblems150.findMedianSortedArrays(nums8, nums9);
        System.out.println("Problem 8 - Test Case 1");
        System.out.println("Expected Output: " + expectedOutput15);
        System.out.println("Actual Output: " + actualOutput15);
        System.out.println();

        int[] nums10 = {1, 3};
        int[] nums11 = {2, 4};
        double expectedOutput16 = 2.5;
        double actualOutput16 = binarySearchLeetCodeProblems150.findMedianSortedArrays(nums10, nums11);
        System.out.println("Problem 8 - Test Case 2");
        System.out.println("Expected Output: " + expectedOutput16);
        System.out.println("Actual Output: " + actualOutput16);
        System.out.println();
    }


    /**
     * Problem 1: Search in a Sorted Array
     * Given an array of distinct integers sorted in ascending order and a target value,
     * return the index of the target if it exists, otherwise return -1.
     * The solution must run in O(log n) time.
     *
     * @param nums   the sorted array of integers
     * @param target the target integer to search for
     * @return the index of the target if found, otherwise -1
     */
    public static int search(int[] nums, int target) {
        return -1;
    }

    /**
     * Problem 2: Search 2D Matrix
     * Given an m x n 2-D integer array matrix and an integer target,
     * return true if the target exists in the matrix, otherwise return false.
     * Each row in the matrix is sorted in non-decreasing order.
     * The first integer of every row is greater than the last integer of the previous row.
     * The solution must run in O(log(m * n)) time.
     *
     * @param matrix the 2-D integer array
     * @param target the target integer to search for
     * @return true if the target exists in the matrix, otherwise false
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        return false;
    }

    /**
     * Problem 3: Eating Bananas
     * Given an integer array piles where piles[i] is the number of bananas in the ith pile,
     * and an integer h representing the number of hours you have to eat all the bananas,
     * return the minimum integer k such that you can eat all the bananas within h hours.
     *
     * @param piles the array of banana piles
     * @param h     the number of hours to eat all bananas
     * @return the minimum integer k such that all bananas can be eaten within h hours
     */
    public static int minEatingSpeed(int[] piles, int h) {
        return -1;
    }


    /**
     * Problem 5: Find Minimum in Rotated Sorted Array
     * Given an array of length n which was originally sorted in ascending order and has been rotated,
     * return the minimum element of this array. The solution must run in O(log n) time.
     *
     * @param nums the rotated sorted array
     * @return the minimum element in the array
     */
    public static int findMin(int[] nums) {
        return -1;
    }

    /**
     * Problem 6: Find Target in Rotated Sorted Array
     * Given an array of length n which was originally sorted in ascending order and has been rotated,
     * return the index of the target if it exists, otherwise return -1.
     * The solution must run in O(log n) time.
     *
     * @param nums   the rotated sorted array
     * @param target the target integer to search for
     * @return the index of the target if found, otherwise -1
     */
    public static int searchRotated(int[] nums, int target) {
        return -1;
    }

    /**
     * Problem 7: Time Based Key-Value Store
     * Implement a time-based key-value data structure that supports storing multiple values for the same key
     * at specified time stamps and retrieving the key's value at a specified timestamp.
     */
    public static class TimeMap {
        private Map<String, TreeMap<Integer, String>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        /**
         * Stores the key with the value at the given timestamp.
         *
         * @param key       the key to store
         * @param value     the value to store
         * @param timestamp the timestamp at which to store the value
         */
        public void set(String key, String value, int timestamp) {

        }

        /**
         * Returns the most recent value of the key that is less than or equal to the given timestamp.
         *
         * @param key       the key to retrieve
         * @param timestamp the timestamp to retrieve the value for
         * @return the most recent value of the key at or before the given timestamp, or an empty string if none exists
         */
        public String get(String key, int timestamp) {
            return null;
        }
    }

    /**
     * Problem 8: Median of Two Sorted Arrays
     * Given two sorted arrays nums1 and nums2 of size m and n respectively,
     * return the median value among all elements of the two arrays.
     * The solution must run in O(log(m + n)) time.
     *
     * @param nums1 the first sorted array
     * @param nums2 the second sorted array
     * @return the median value among all elements of the two arrays
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0.0;
    }
}
