package ds.arrays.leetcode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysLeetCode150Problems {
    public static void main(String[] args) {
        ArraysLeetCode150Problems solution = new ArraysLeetCode150Problems();

        // Problem 1: Duplicate Integer
        // Test Case 1
        int[] nums1 = {1, 2, 3, 3};
        System.out.println(solution.containsDuplicate(nums1)); // Expected Output: true

        // Test Case 2
        int[] nums2 = {1, 2, 3, 4};
        System.out.println(solution.containsDuplicate(nums2)); // Expected Output: false

        // Problem 2: Is Anagram
        // Test Case 1
        String s1 = "racecar";
        String t1 = "carrace";
        System.out.println(solution.isAnagram(s1, t1)); // Expected Output: true

        // Test Case 2
        String s2 = "jar";
        String t2 = "jam";
        System.out.println(solution.isAnagram(s2, t2)); // Expected Output: false

        // Problem 3: Two Sum
        // Test Case 1
        int[] nums3 = {3, 4, 5, 6};
        int target1 = 7;
        System.out.println(Arrays.toString(solution.twoSum(nums3, target1))); // Expected Output: [0, 1]

        // Test Case 2
        int[] nums4 = {4, 5, 6};
        int target2 = 10;
        System.out.println(Arrays.toString(solution.twoSum(nums4, target2))); // Expected Output: [0, 2]

        // Test Case 3
        int[] nums5 = {5, 5};
        int target3 = 10;
        System.out.println(Arrays.toString(solution.twoSum(nums5, target3))); // Expected Output: [0, 1]

        // Problem 4: Group Anagrams
        // Test Case 1
        String[] strs1 = {"act", "pots", "tops", "cat", "stop", "hat"};
        System.out.println(solution.groupAnagrams(strs1)); // Expected Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]

        // Test Case 2
        String[] strs2 = {"x"};
        System.out.println(solution.groupAnagrams(strs2)); // Expected Output: [["x"]]

        // Test Case 3
        String[] strs3 = {""};
        System.out.println(solution.groupAnagrams(strs3)); // Expected Output: [[""]]

        // Problem 5: K Most Frequent Elements
        // Test Case 1
        int[] nums6 = {1, 2, 2, 3, 3, 3};
        int k1 = 2;
        System.out.println(Arrays.toString(solution.topKFrequent(nums6, k1))); // Expected Output: [2, 3]

        // Test Case 2
        int[] nums7 = {7, 7};
        int k2 = 1;
        System.out.println(Arrays.toString(solution.topKFrequent(nums7, k2))); // Expected Output: [7]

        // Problem 6: Encode and Decode
        // Test Case 1
        List<String> strs4 = Arrays.asList("neet", "code", "love", "you");
        String encoded = solution.encode(strs4);
        System.out.println(solution.decode(encoded)); // Expected Output: ["neet", "code", "love", "you"]

        // Test Case 2
        List<String> strs5 = Arrays.asList("we", "say", ":", "yes");
        String encoded2 = solution.encode(strs5);
        System.out.println(solution.decode(encoded2)); // Expected Output: ["we", "say", ":", "yes"]

        // Problem 7: Product of Array Except Self
        // Test Case 1
        int[] nums8 = {1, 2, 4, 6};
        System.out.println(Arrays.toString(productExceptSelf(nums8))); // Expected Output: [48, 24, 12, 8]

        // Test Case 2
        int[] nums9 = {-1, 0, 1, 2, 3};
        System.out.println(Arrays.toString(productExceptSelf(nums9))); // Expected Output: [0, -6, 0, 0, 0]

        // Problem 8: Longest Consecutive Sequence
        // Test Case 1
        int[] nums10 = {2, 20, 4, 10, 3, 4, 5};
        System.out.println(longestConsecutive(nums10)); // Expected Output: 4

        // Test Case 2
        int[] nums11 = {0, 3, 2, 5, 4, 6, 1, 1};
        System.out.println(longestConsecutive(nums11)); // Expected Output: 7
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

    }
