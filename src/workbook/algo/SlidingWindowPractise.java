package workbook.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SlidingWindowPractise {

    public static void main(String[] args) {
        SlidingWindowPractise twoPointers = new SlidingWindowPractise();

        System.out.println("Longest Substring Without Repeating Characters");
        String[] testStrings = {"abcabcbb", "bbbbb", "pwwkew", " "};
        int[] expected = {3, 1, 3, 1};
        for (int i = 0; i < testStrings.length; i++) {
            String s = testStrings[i];
            int expectedResult = expected[i];
            int actualResult = twoPointers.lengthOfLongestSubstring(s);
            System.out.println("Input: " + s);
            System.out.println("Expected: " + expectedResult);
            System.out.println("Actual: " + actualResult);
            System.out.println();
        }

        System.out.println("Longest Repeating Character Replacement");
        testStrings = new String[]{"ABAB", "AABABBA"};
        int[] kValues = {2, 1};
        expected = new int[]{4, 4};
        for (int i = 0; i < testStrings.length; i++) {
            String s = testStrings[i];
            int k = kValues[i];
            int expectedResult = expected[i];
            int actualResult = twoPointers.characterReplacement(s, k);
            System.out.println("Input: " + s + ", k = " + k);
            System.out.println("Expected: " + expectedResult);
            System.out.println("Actual: " + actualResult);
            System.out.println();
        }

        System.out.println("Subarray Product Less Than K");
        int[][] testArrays = {{10, 5, 2, 6}, {1, 2, 3}};
        kValues = new int[]{100, 0};
        expected = new int[]{8, 0};
        for (int i = 0; i < testArrays.length; i++) {
            int[] nums = testArrays[i];
            int k = kValues[i];
            int expectedResult = expected[i];
            int actualResult = twoPointers.numSubarrayProductLessThanK(nums, k);
            System.out.println("Input: nums = " + java.util.Arrays.toString(nums) + ", k = " + k);
            System.out.println("Expected: " + expectedResult);
            System.out.println("Actual: " + actualResult);
            System.out.println();
        }

        System.out.println(
                "Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if " +
                        "you can flip at most k 0's.");
        testArrays = new int[][]{{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}};
        kValues = new int[]{2, 3};
        expected = new int[]{6, 10};
        for (int i = 0; i < testArrays.length; i++) {
            int[] nums = testArrays[i];
            int k = kValues[i];
            int expectedResult = expected[i];
            int actualResult = twoPointers.longestOnes(nums, k);
            System.out.println("Input: nums = " + java.util.Arrays.toString(nums) + ", k = " + k);
            System.out.println("Expected: " + expectedResult);
            System.out.println("Actual: " + actualResult);
            System.out.println();
        }

        System.out.println("Get Equal Substrings Within Budget");
        String[] sValues = {"abcd", "abcd", "abcd"};
        String[] tValues = {"bcdf", "cdef", "acde"};
        int[] maxCostValues = {3, 3, 0};
        expected = new int[]{3, 1, 1};
        for (int i = 0; i < sValues.length; i++) {
            String s = sValues[i];
            String t = tValues[i];
            int maxCost = maxCostValues[i];
            int expectedResult = expected[i];
            int actualResult = twoPointers.equalSubstring(s, t, maxCost);
            System.out.println("Input: s = " + s + ", t = " + t + ", maxCost = " + maxCost);
            System.out.println("Expected: " + expectedResult);
            System.out.println("Actual: " + actualResult);
            System.out.println();
        }

        System.out.println("Longest Subarray of 1's After Deleting One Element");
        testArrays = new int[][]{{1, 1, 0, 1}, {0, 1, 1, 1, 0, 1, 1, 0, 1}, {1, 1, 1}};
        expected = new int[]{3, 5, 2};
        for (int i = 0; i < testArrays.length; i++) {
            int[] nums = testArrays[i];
            int expectedResult = expected[i];
            int actualResult = longestSubarray(nums);
            System.out.println("Input: nums = " + java.util.Arrays.toString(nums));
            System.out.println("Expected: " + expectedResult);
            System.out.println("Actual: " + actualResult);
            System.out.println();
        }

        System.out.println("Maximum Erasure Value");
        testArrays = new int[][]{{4, 2, 4, 5, 6}, {5, 2, 1, 2, 5, 2, 1, 2, 5}};
        expected = new int[]{17, 8};
        for (int i = 0; i < testArrays.length; i++) {
            int[] nums = testArrays[i];
            int expectedResult = expected[i];
            int actualResult = twoPointers.maximumUniqueSubarray(nums);
            System.out.println("Input: nums = " + java.util.Arrays.toString(nums));
            System.out.println("Expected: " + expectedResult);
            System.out.println("Actual: " + actualResult);
            System.out.println();
        }

        System.out.println("Frequency of the Most Frequent Element");
        testArrays = new int[][]{{1, 2, 4}, {1, 4, 8, 13}, {3, 9, 6}, {100000}};
        kValues = new int[]{5, 5, 2, 100000};
        expected = new int[]{3, 2, 1, 1};
        for (int i = 0; i < testArrays.length; i++) {
            int[] nums = testArrays[i];
            int k = kValues[i];
            int expectedResult = expected[i];
            int actualResult = twoPointers.maxFrequency(nums, k);
            System.out.println("Input: nums = " + java.util.Arrays.toString(nums) + ", k = " + k);
            System.out.println("Expected: " + expectedResult);
            System.out.println("Actual: " + actualResult);
            System.out.println();
        }

        testArrays = new int[][]{{4, 2, 5, 3}, {1, 2, 3, 5, 6}, {1, 10, 100, 1000}};
        expected = new int[]{0, 1, 3};

        System.out.println("Minimum Number of Operations to Make Array Continuous");
        for (int i = 0; i < testArrays.length; i++) {
            int[] nums = testArrays[i];
            int expectedResult = expected[i];
            int actualResult = twoPointers.minOperations(nums);
            System.out.println("Input: nums = " + java.util.Arrays.toString(nums));
            System.out.println("Expected: " + expectedResult);
            System.out.println("Actual: " + actualResult);
            System.out.println();
        }

        String[] answerKeys = {"TTFF", "TFFT", "TTFTTFTT"};
        kValues = new int[]{2, 1, 1};
        expected = new int[]{4, 3, 5};

        System.out.println("Maximize the Confusion of an Exam");
        for (int i = 0; i < answerKeys.length; i++) {
            String answerKey = answerKeys[i];
            int k = kValues[i];
            int expectedResult = expected[i];
            int actualResult = maxConsecutiveAnswers(answerKey, k);
            System.out.println("Input: answerKey = " + answerKey + ", k = " + k);
            System.out.println("Expected: " + expectedResult);
            System.out.println("Actual: " + actualResult);
            System.out.println();
        }
    }



    /**
     * Longest Substring Without Repeating Characters
     *
     * Given a string s, find the length of the longest
     * substring
     *  without repeating characters.
     *
     *  Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int start = 0, max =0, end = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        for (; end < s.length(); end++) {
            char charAtEnd = s.charAt(end);
            if (charMap.containsKey(charAtEnd)) {
                start = Math.max(start, charMap.get(charAtEnd) + 1);
            }
            charMap.put(charAtEnd, end);
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

    /**
     * Longest Repeating Character Replacement
     *
     * You are given a string s and an integer k. You can choose any character of the string and change it to any other
     * uppercase English character. You can perform this operation at most k times.
     *
     * Return the length of the longest substring containing the same letter you can get after performing the above
     * operations.
     *
     * Example 1:
     *
     * Input: s = "ABAB", k = 2
     * Output: 4
     * Explanation: Replace the two 'A's with two 'B's or vice versa.
     * Example 2:
     *
     * Input: s = "AABABBA", k = 1
     * Output: 4
     * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
     * The substring "BBBB" has the longest repeating letters, which is 4.
     * There may exists other ways to achieve this answer too.
     *
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        int i = 0, j = 0;
        int[] cnt = new int[26];
        while (j < s.length()) {
            cnt[s.charAt(j) - 'A']++;
            j++;
            if (j - i - Arrays.stream(cnt).max().getAsInt() > k)
                cnt[s.charAt(i) - 'A']--;
                i++;
        }
        return j - i;
    }

    /**
     * Subarray Product Less Than K
     *
     * Given an array of integers nums and an integer k,
     * return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
     *
     * Example 1:
     *
     * Input: nums = [10,5,2,6], k = 100
     * Output: 8
     * Explanation: The 8 subarrays that have product less than 100 are:
     * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
     * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
     * Example 2:
     *
     * Input: nums = [1,2,3], k = 0
     * Output: 0
     *
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int end = 0, start = 0, answer = 0;
        int product = 1;
        for (; end < nums.length; ++end) {
            product *= nums[end];
            while (start <= end && product >= k) {
                product /= nums[start];
                start++;
            }
            answer += (end - start + 1);
        }
        return answer;
    }

    /**
     * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
     *
     * Example 1:
     *
     * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
     * Output: 6
     * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
     * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
     * Example 2:
     *
     * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
     * Output: 10
     * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
     * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
     *
     * @param nums
     * @param k
     * @return
     */
    public int longestOnes(int[] nums, int k) {
        int end = 0, start = 0, max = 0, zeroCount = 0;
        for (; end < nums.length; end++) {
            if (nums[end] == 0) {
                zeroCount++;
            }
            while (zeroCount > k && start <= end) {
                if (nums[start] == 0) {
                    zeroCount--;
                }
                start++;
            }

            max = Math.max(max, end - start + 1);
        }
        return max;
    }

    /**
     * Get Equal Substrings Within Budget
     *
     * You are given two strings s and t of the same length and an integer maxCost.
     *
     * You want to change s to t. Changing the ith character of s to ith character of t costs |s[i] - t[i]| (i.e., the
     * absolute difference between the ASCII values of the characters).
     *
     * Return the maximum length of a substring of s that can be changed to be the same as the corresponding substring of
     * t with a cost less than or equal to maxCost. If there is no substring from s that can be changed to its
     * corresponding substring from t, return 0.
     *
     * Example 1:
     *
     * Input: s = "abcd", t = "bcdf", maxCost = 3
     * Output: 3
     * Explanation: "abc" of s can change to "bcd".
     * That costs 3, so the maximum length is 3.
     * Example 2:
     *
     * Input: s = "abcd", t = "cdef", maxCost = 3
     * Output: 1
     * Explanation: Each character in s costs 2 to change to character in t,  so the maximum length is 1.
     * Example 3:
     *
     * Input: s = "abcd", t = "acde", maxCost = 0
     * Output: 1
     * Explanation: You cannot make any change, so the maximum length is 1.
     *
     * @param s
     * @param t
     * @param maxCost
     * @return
     */
    public int equalSubstring(String s, String t, int maxCost) {
        int start = 0, end = 0, N = s.length(), cost = 0, ans = 0;
        for (; end < N; ++end) {
            cost += Math.abs(s.charAt(end) - t.charAt(end));
            for (; cost > maxCost; ++start) {
                cost -= Math.abs(s.charAt(start) - t.charAt(start));
            }
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }

    /**
     * Longest Subarray of 1's After Deleting One Element
     *
     * Given a binary array nums, you should delete one element from it.
     *
     * Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is
     * no such subarray.
     *
     * Example 1:
     *
     * Input: nums = [1,1,0,1]
     * Output: 3
     * Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
     * Example 2:
     *
     * Input: nums = [0,1,1,1,0,1,1,0,1]
     * Output: 5
     * Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,
     * 1,1,1].
     * Example 3:
     *
     * Input: nums = [1,1,1]
     * Output: 2
     * Explanation: You must delete one element.
     *
     * @param nums
     * @return
     */
    public static int longestSubarray(int[] nums) {
        int end = 0, start = 0, max = 0, zeroCount = 0;
        for (; end < nums.length; end++) {
            if (nums[end] == 0) {
                zeroCount++;
            }
            while (zeroCount > 1 && start <= end) {
                if (nums[start] == 0) {
                    zeroCount--;
                }
                start++;
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

    /**
     * Maximum Erasure Value
     *
     * You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score
     * you get by erasing the subarray is equal to the sum of its elements.
     *
     * Return the maximum score you can get by erasing exactly one subarray.
     *
     * An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to
     * a[l],a[l+1],...,a[r] for some (l,r).
     *
     * Example 1:
     *
     * Input: nums = [4,2,4,5,6]
     * Output: 17
     * Explanation: The optimal subarray here is [2,4,5,6].
     * Example 2:
     *
     * Input: nums = [5,2,1,2,5,2,1,2,5]
     * Output: 8
     * Explanation: The optimal subarray here is [5,2,1] or [1,2,5].
     *
     * @param nums
     * @return
     */
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int left = 0, right = 0;
        int maxSum = 0, currentSum = 0;

        while (right < nums.length) {
            if (!set.contains(nums[right])) {
                set.add(nums[right]);
                currentSum += nums[right];
                maxSum = Math.max(maxSum, currentSum);
                right++;
            } else {
                set.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }
        }

        return maxSum;
    }

    /**
     * Frequency of the Most Frequent Element
     *
     * The frequency of an element is the number of times it occurs in an array.
     *
     * You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and
     * increment the element at that index by 1.
     *
     * Return the maximum possible frequency of an element after performing at most k operations.
     *
     * Example 1:
     *
     * Input: nums = [1,2,4], k = 5
     * Output: 3
     * Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
     * 4 has a frequency of 3.
     * Example 2:
     *
     * Input: nums = [1,4,8,13], k = 5
     * Output: 2
     * Explanation: There are multiple optimal solutions:
     * - Increment the first element three times to make nums = [4,4,8,13]. 4 has a frequency of 2.
     * - Increment the second element four times to make nums = [1,8,8,13]. 8 has a frequency of 2.
     * - Increment the third element five times to make nums = [1,4,13,13]. 13 has a frequency of 2.
     * Example 3:
     *
     * Input: nums = [3,9,6], k = 2
     * Output: 1
     *
     * @param nums
     * @param k
     * @return
     */
    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int maxFreq = 0;
        int totalOps = 0;

        for (int right = 0; right < nums.length; right++) {
            totalOps += nums[right];

            while (nums[right] * (right - left + 1) > totalOps + k) {
                totalOps -= nums[left];
                left++;
            }

            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
    }

    /**
     * Minimum Number of Operations to Make Array Continuous
     *
     * nums is considered continuous if both of the following conditions are fulfilled:
     *
     * All elements in nums are unique.
     * The difference between the maximum element and the minimum element in nums equals nums.length - 1.
     * For example, nums = [4, 2, 5, 3] is continuous, but nums = [1, 2, 3, 5, 6] is not continuous.
     *
     * Return the minimum number of operations to make nums continuous.
     *
     * Example 1:
     *
     * Input: nums = [4,2,5,3]
     * Output: 0
     * Explanation: nums is already continuous.
     * Example 2:
     *
     * Input: nums = [1,2,3,5,6]
     * Output: 1
     * Explanation: One possible solution is to change the last element to 4.
     * The resulting array is [1,2,3,5,4], which is continuous.
     * Example 3:
     *
     * Input: nums = [1,10,100,1000]
     * Output: 3
     * Explanation: One possible solution is to:
     * - Change the second element to 2.
     * - Change the third element to 3.
     * - Change the fourth element to 4.
     * The resulting array is [1,2,3,4], which is continuous.
     *
     * @param nums
     * @return
     */
    public static int minOperations(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int minOps = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            while (nums[right] - nums[left] > n - 1) {
                left++;
            }
            int opsNeeded = n - (right - left + 1);
            minOps = Math.min(minOps, opsNeeded);
        }

        return minOps;
    }

    /**
     * Maximize the Confusion of an Exam
     *
     * A teacher is writing a test with n true/false questions, with 'T' denoting true and 'F' denoting false. He wants to
     * confuse the students by maximizing the number of consecutive questions with the same answer (multiple trues or
     * multiple falses in a row).
     *
     * You are given a string answerKey, where answerKey[i] is the original answer to the ith question. In addition, you
     * are given an integer k, the maximum number of times you may perform the following operation:
     *
     * Change the answer key for any question to 'T' or 'F' (i.e., set answerKey[i] to 'T' or 'F').
     * Return the maximum number of consecutive 'T's or 'F's in the answer key after performing the operation at most k
     * times.
     *
     * Example 1:
     *
     * Input: answerKey = "TTFF", k = 2
     * Output: 4
     * Explanation: We can replace both the 'F's with 'T's to make answerKey = "TTTT".
     * There are four consecutive 'T's.
     * Example 2:
     *
     * Input: answerKey = "TFFT", k = 1
     * Output: 3
     * Explanation: We can replace the first 'T' with an 'F' to make answerKey = "FFFT".
     * Alternatively, we can replace the second 'T' with an 'F' to make answerKey = "TFFF".
     * In both cases, there are three consecutive 'F's.
     *
     * @param answerKey
     * @param k
     * @return
     */
    public static int maxConsecutiveAnswers(String answerKey, int k) {
        return -1;
    }
}
