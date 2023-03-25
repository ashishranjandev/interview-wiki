package ds.arrays.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 *
 *
 * Target Questions:
 *
 * Q 1 Maximum and Minimum Element in an Array
 * Q 2 Reverse the Array
 * Q 3 Maximum-Subarray
 * Q 4 Contains Duplicate
 * Q 5 Chocolate Distribution Problem
 * Q 6 Search in Rotated Sorted Array
 * Q 7 Next Permutation
 * Q 8 Best time to Buy and Sell Stock
 * Q 9 Repeat and Missing Number Array
 * Q 10 Kth-Largest Element in an Array
 * Q 11 Trapping Rain Water
 * Q 12 Product of Array Except Self
 * Q 13 Maximum Product Subarray
 * Q 14 Find Minimum in Rotated Sorted Array
 * Q 15 Find Pair with Sum in Sorted & Rotated Array
 * Q 16 3Sum
 * Q 17 Container With Most Water
 * Q 18 Given Sum Pair
 * Q 19 Kth - Smallest Element
 * Q 20 Merge Overlapping Intervals
 * Q 21 Find Minimum Number of Merge Operations to Make an Array Palindrome
 * Q 22 Given an Array of Numbers Arrange the Numbers to Form the Biggest Number
 * Q 22 Space Optimization Using Bit Manipulations
 * Q 23 Subarray Sum Divisible K
 * Q 24 Print all Possible Combinations of r Elements in a Given Array of Size n
 * Q 25 Mo's Algorithm
 *
 * @author Ashish Ranjan
 */
public class ArraysLeetCodeProblems {

    public static void main(String[] args) {
        //Input: nums = [1,1,1,2,2,3], k = 2
        //Output: [1,2]
        int[] nums = new int[6];
        nums[0] = 1;
        nums[1] = 1;
        nums[2] = 1;
        nums[3] = 2;
        nums[4] = 2;
        nums[5] = 3;

        ArraysLeetCodeProblems arraysLeetCodeProblems = new ArraysLeetCodeProblems();
        int[] answer = arraysLeetCodeProblems.topKFrequent(nums, 2);
        System.out.print("Solution for top K frequent is - ");
        for (int num : answer) {
            System.out.print(num + " ");
        }

        nums = new int[6];
        nums[0] = 100;
        nums[1] = 4;
        nums[2] = 200;
        nums[3] = 1;
        nums[4] = 3;
        nums[5] = 2;
        System.out.println();
        System.out.println("Length of Consecutive sequence " + arraysLeetCodeProblems.longestConsecutive(nums));

        nums = new int[0];
        System.out.println("Length of Consecutive sequence for Empty Array is " + arraysLeetCodeProblems.longestConsecutive(nums));

        nums = new int[4];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        nums[3] = 4;
        answer = arraysLeetCodeProblems.productExceptSelf(nums);
        System.out.print("Solution for Product Except self for [1,2,3,4] is - ");
        for (int num : answer) {
            System.out.print(num + " ");
        }

        System.out.println();
        nums = new int[5];
        nums[0] = -1;
        nums[1] = 1;
        nums[2] = 0;
        nums[3] = -3;
        nums[4] = -3;
        answer = arraysLeetCodeProblems.productExceptSelf(nums);
        System.out.print("Solution for Product Except self for [-1,1,0,-3,-3] is - ");
        for (int num : answer) {
            System.out.print(num + " ");
        }

        System.out.println();
        // Input: nums = [4,5,6,7,0,1,2], target = 0
        // Output: 4
        nums = new int[7];
        nums[0] = 4;
        nums[1] = 5;
        nums[2] = 6;
        nums[3] = 7;
        nums[4] = 0;
        nums[5] = 1;
        nums[6] = 2;
        int answerInt = arraysLeetCodeProblems.search(nums, 0);
        System.out.print("Solution for Search in rotated array for [4,5,6,7,0,1,2] with target 0 is - " + answerInt);

        System.out.println();
        // Input: nums = [4,5,6,7,0,1,2], target = 0
        // Output: 4
        nums = new int[3];
        nums[0] = 5;
        nums[1] = 1;
        nums[2] = 3;
        answerInt = arraysLeetCodeProblems.search(nums, 5);
        System.out.print("Solution for Search in rotated array for [5,1,3] with target 5 is - " + answerInt);

    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] answer = new int[k];
        Map<Integer, Integer> numCountMap = new HashMap<>(nums.length);

        for (int num : nums) {
            if (numCountMap.containsKey(num)) {
                int count = numCountMap.get(num);
                numCountMap.put(num, ++count);
            } else {
                numCountMap.put(num, 1);
            }
        }

        Map<Integer, List<Integer>> countToNumMap = new HashMap<>(nums.length + 1);
        for (Map.Entry<Integer, Integer> numCountMapEntry : numCountMap.entrySet()) {
            List<Integer> listOfElements = null;
            if (countToNumMap.containsKey(numCountMapEntry.getValue())) {
                listOfElements = countToNumMap.get(numCountMapEntry.getValue());

            } else {
                listOfElements = new ArrayList<>();
            }
            listOfElements.add(numCountMapEntry.getKey());
            countToNumMap.put(numCountMapEntry.getValue(), listOfElements);
        }


        int countInAnswer = 0;
        for (int i = nums.length; i >= 0; i--) {
            if (countToNumMap.containsKey(i)) {
                for (Integer numberWithCount : countToNumMap.get(i)) {
                    answer[countInAnswer] = numberWithCount;
                    countInAnswer++;
                }
            }
            if (countInAnswer == k) {
                return answer;
            }
        }
        return  answer;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = 1;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            answer[i + 1] = answer[i] * nums[i];
        }

        int postFix = 1;
        for (int i = nums.length - 1; i >= 1; i--) {
            postFix *= nums[i];
            answer[i - 1] = answer[i - 1] * postFix;

        }
        return answer;
    }


    public int longestConsecutive(int[] nums) {
        int answer = 0;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        for (int num : nums) {
            int subsequenceLength = getLongestSequenceLength(numSet, num);
            answer = subsequenceLength > answer ? subsequenceLength : answer;
        }
        return answer;
    }

    private int getLongestSequenceLength(Set numSet, int num) {
        int setLength = 1;
        if (numSet.contains( num - 1)) {
            return 1;
        }
        while(numSet.contains(++num)) {
            setLength++;
        }
        return  setLength;
    }

    /**
     * Searching in rotated array
     *
     * @see https://leetcode.com/problems/search-in-rotated-sorted-array
     *
     * We can still use binary search however with addtional checks.
     *
     * 1. First we have to identify if mid is in left sorted array or right sorted array
     *  e.g. in [4,5,6,7,0,1,2] 4,5,6,7 is left sorted array and 0,1,2 is right sorted array
     *
     *  How to identity??
     *  If number on left is smaller than mid -> we are in left sorted array
     *  else we are in right sorted array
     *
     *  If we are in left sorted array
     *   If target is larger than mid OR target is smaller than left
     *      Go LEFT
     *   Else
     *      Go RIGHT
     *
     * Else (If we are in right sorted array)
     *   If target is smaller than mid OR target is larger than right
     *      Go LEFT
     *   Else
     *      Go RIGHT
     *
     *
     * @see https://www.youtube.com/watch?v=U8XENwh8Oy8 for video explanation
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int mid = 0;
        int right = nums.length - 1;

        while (left <= right) {
            mid = (left + right)/ 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                // We are in left sorted array
                if (target > nums[mid] || target < nums[left]) {
                    // Search in right part
                    left = mid + 1;
                } else {
                    // Search in left part
                    right = mid - 1;
                }
            } else {
                // We are in right sorted array
                if (target < nums[mid] || target > nums[right]) {
                    // Search in left part
                    right = mid - 1;
                } else {
                    // Search in left part
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
