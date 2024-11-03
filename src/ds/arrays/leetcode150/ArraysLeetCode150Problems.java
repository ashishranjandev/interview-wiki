package ds.arrays.leetcode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        System.out.println("Expected Output: " + expectedOutput4);
        System.out.println("Actual Output: " + actualOutput4);
        System.out.println();
    }

        // Problem 1: Contains Duplicate
        public boolean containsDuplicate(int[] nums) {
            return false;
        }

        // Problem 2: Is Anagram
        public  boolean isAnagram(String s, String t) {
            return true;
        }

        // Problem 3: Two Sum
        public int[] twoSum(int[] nums, int target) {
            throw new IllegalArgumentException("No two sum solution");
        }

        // Problem 4: Group Anagrams
        public List<List<String>> groupAnagrams(String[] strs) {
            return null;
        }

        // Problem 5: Top K Frequent Elements
        public int[] topKFrequent(int[] nums, int k) {
            return new int[10];
        }

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder sb = new StringBuilder();
            for (String s : strs) {
                sb.append(s.length()).append('/').append(s);
            }
            return sb.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> strs = new ArrayList<>();
            int i = 0;
            while (i < s.length()) {
                int slash = s.indexOf('/', i);
                int size = Integer.parseInt(s.substring(i, slash));
                strs.add(s.substring(slash + 1, slash + 1 + size));
                i = slash + 1 + size;
            }
            return strs;
        }

        // Problem 7: Product of Array Except Self
        public static int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] output = new int[n];
            Arrays.fill(output, 1);
            int left = 1, right = 1;
            for (int i = 0; i < n; i++) {
                output[i] *= left;
                left *= nums[i];
                output[n - 1 - i] *= right;
                right *= nums[n - 1 - i];
            }
            return output;
        }

        // Problem 8: Longest Consecutive Sequence
        public static int longestConsecutive(int[] nums) {
            return -1;
        }

    public boolean isValidSudoku(char[][] board) {
        return false;
    }

    }
