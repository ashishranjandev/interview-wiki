package algo.twopointers.leetcode150.workbook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointersLeetcode150 {

    public static void main(String[] args) {
        TwoPointersLeetcode150 solution = new TwoPointersLeetcode150();

        // Problem 1: Palindrome String
        System.out.println("Problem 1: Palindrome String");
        System.out.println(solution.isPalindrome("Was it a car or a cat I saw?")); // true
        System.out.println(solution.isPalindrome("tab a cat")); // false
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(solution.isPalindrome("race a car")); // false
        System.out.println(solution.isPalindrome("No 'x' in Nixon")); // true

        // Problem 2: Two Sum II - Input Array Is Sorted
        System.out.println("\nProblem 2: Two Sum II - Input Array Is Sorted");
        System.out.println(Arrays.toString(solution.twoSum(new int[]{1, 2, 3, 4}, 3))); // [1, 2]
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9))); // [1, 2]
        System.out.println(Arrays.toString(solution.twoSum(new int[]{1, 2, 3, 4, 4, 9}, 8))); // [4, 5]
        System.out.println(Arrays.toString(solution.twoSum(new int[]{5, 25, 75}, 100))); // [2, 3]

        // Problem 3: 3Sum
        System.out.println("\nProblem 3: 3Sum");
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4})); // [[-1,-1,2],[-1,0,1]]
        System.out.println(solution.threeSum(new int[]{0, 1, 1})); // []
        System.out.println(solution.threeSum(new int[]{0, 0, 0})); // [[0,0,0]]

        // Problem 4: Container With Most Water
        System.out.println("\nProblem 4: Container With Most Water");
        System.out.println(solution.maxArea(new int[]{1, 7, 2, 5, 4, 7, 3, 6})); // 36
        System.out.println(solution.maxArea(new int[]{2, 2, 2})); // 4

        // Problem 5: Trapping Rain Water
        System.out.println("\nProblem 5: Trapping Rain Water");
        System.out.println(solution.trap(new int[]{0, 2, 0, 3, 1, 0, 1, 3, 2, 1})); // 9
    }

    /**
     * Given a string s, return true if it is a palindrome, otherwise return false.
     *
     * A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores all
     * non-alphanumeric characters.
     *
     * Example 1:
     *
     * Input: s = "Was it a car or a cat I saw?"
     *
     * Output: true
     * Explanation: After considering only alphanumerical characters we have "wasitacaroracatisaw", which is a palindrome.
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        return true;
    }

    /**
     * Given an array of integers numbers that is sorted in non-decreasing order.
     *
     * Return the indices (1-indexed) of two numbers, [index1, index2], such that they add up to a given target number
     * target and index1 < index2. Note that index1 and index2 cannot be equal, therefore you may not use the same element
     * twice.
     *
     * There will always be exactly one valid solution.
     *
     * Your solution must use
     * 𝑂
     * (
     * 1
     * )
     * O(1) additional space.
     *
     * Example 1:
     *
     * Input: numbers = [1,2,3,4], target = 3
     *
     * Output: [1,2]
     * Explanation:
     * The sum of 1 and 2 is 3. Since we are assuming a 1-indexed array, index1 = 1, index2 = 2. We return [1, 2].
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        return new int[]{-1, -1};
    }

    /**
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] where nums[i] + nums[j] + nums[k]
     * == 0, and the indices i, j and k are all distinct.
     *
     * The output should not contain any duplicate triplets. You may return the output and the triplets in any order.
     *
     * Example 1:
     *
     * Input: nums = [-1,0,1,2,-1,-4]
     *
     * Output: [[-1,-1,2],[-1,0,1]]
     * Explanation:
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
     * The distinct triplets are [-1,0,1] and [-1,-1,2].
     *
     * Example 2:
     *
     * Input: nums = [0,1,1]
     *
     * Output: []
     * Explanation: The only possible triplet does not sum up to 0.
     *
     * Example 3:
     *
     * Input: nums = [0,0,0]
     *
     * Output: [[0,0,0]]
     * Explanation: The only possible triplet sums up to 0.
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        return result;
    }

    // Problem 4: Container With Most Water

    /**
     * You are given an integer array heights where heights[i] represents the height of the
     * ith bar.
     *
     * You may choose any two bars to form a container. Return the maximum amount of water a container can store.
     *
     * Input: height = [1,7,2,5,4,7,3,6]
     *
     * Output: 36
     * Example 2:
     *
     * Input: height = [2,2,2]
     *
     * Output: 4
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        return -1;
    }

    /**
     * You are given an array non-negative integers heights which represent an elevation map. Each value heights[i]
     * represents the height of a bar, which has a width of 1.
     *
     * Return the maximum area of water that can be trapped between the bars.
     *
     * Input: height = [0,2,0,3,1,0,1,3,2,1]
     *
     * Output: 9
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        return -1;
    }
}
