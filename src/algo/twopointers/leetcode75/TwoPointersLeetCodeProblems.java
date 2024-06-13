package algo.twopointers.leetcode75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointersLeetCodeProblems {

    public static void main(String[] args) {

        TwoPointersLeetCodeProblems twoPointersLeetCodeProblems = new TwoPointersLeetCodeProblems();
        System.out.println("Is this string pallindrone - " + "A man, a plan, a canal: Panama" + " - " +
                                   twoPointersLeetCodeProblems.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println("Is this string pallindrone - " + "race a car" + " - " +
                                   twoPointersLeetCodeProblems.isPalindrome("race a car"));
        System.out.println("Is this string pallindrone - " + " " + " - " +
                                   twoPointersLeetCodeProblems.isPalindrome(" "));

        System.out.println("Is this string pallindrone - " + "0P" + " - " +
                                   twoPointersLeetCodeProblems.isPalindrome("0P"));

        int[] nums = new int[4];
        nums[0] = 2;
        nums[1] = 7;
        nums[2] = 11;
        nums[3] = 15;
        System.out.println("Index of 2 sum is - ");
        for (int num : twoPointersLeetCodeProblems.twoSum(nums, 9)) {
            System.out.print(num + " ");
        }

        nums = new int[9];
        nums[0] = 1;
        nums[1] = 8;
        nums[2] = 6;
        nums[3] = 2;
        nums[4] = 5;
        nums[5] = 4;
        nums[6] = 8;
        nums[7] = 3;
        nums[8] = 7;

        System.out.println("Max area for array [1,8,6,2,5,4,8,3,7] is " + twoPointersLeetCodeProblems.maxArea(nums));

        nums = new int[6];
        nums[0] = -1;
        nums[1] = 0;
        nums[2] = 1;
        nums[3] = 2;
        nums[4] = -1;
        nums[5] = -4;
        System.out.println("Three sum for array [-1,0,1,2,-1,-4] is " + twoPointersLeetCodeProblems.threeSum(nums));

        nums = new int[5];
        nums[0] = -2;
        nums[1] = 0;
        nums[2] = 0;
        nums[3] = 2;
        nums[4] = 2;
        System.out.println("Three sum for array [-2,0,0,2,2] is " + twoPointersLeetCodeProblems.threeSum(nums));

        nums = new int[6];
        nums[0] = -1;
        nums[1] = 0;
        nums[2] = 1;
        nums[3] = 2;
        nums[4] = -1;
        nums[5] = -4;
        System.out.println("Three sum for array [-1,0,1,2,-1,-4] is " + twoPointersLeetCodeProblems.threeSum(nums));
    }


    public boolean isPalindrome(String s) {
        char[] charArray = s.toLowerCase().toCharArray();
        int k = charArray.length - 1;
        for (int i = 0; i <= k; i++) {
            if ( !((charArray[i] >= 'a' && charArray[i] <= 'z') || (charArray[i] >= '0' && charArray[i] <= '9'))) {
                continue;
            }
            while( !((charArray[k] >= 'a' && charArray[k] <= 'z') || (charArray[k] >= '0' && charArray[k] <= '9'))) {
                k--;
            }
            if (i > k) {
                break;
            }
            if (!(charArray[i] == charArray[k])) {
                return false;
            } else {
            }
            k--;
        }
        return true;
    }


    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int k = numbers.length - 1;
        while (i < k) {
            if (numbers[i] + numbers[k] > target) {
                k--;
            } else  if (numbers[i] + numbers[k] < target) {
                i++;
            } else {
                break;
            }
        }
        int[] answer = new int[2];
        answer[0] = i + 1;
        answer[1] = k + 1;
        return answer;
    }


    /**
     * As duplicate lists are not allowed, we will store the answer in set of lists
     *
     * Sort the array
     * Start iterating from the start and use 2 pointers
     * Basically check if 3sum exist for the index element nums[index]
     *
     * The first pointer is at the next element from index and the 2nd pointer at the end of array
     * There are 3 possibilities
     *  if the sum of all 3 elements is zero
     *      add the list nums[index], nums[first] and nums[last] to the set of answers
     *      Do both side movement - increment first and decrement last
     *  if sum is less than zero
     *      increment first
     *  if sum is more than zero
     *      decrement last
     *
     *  Repeat this for the index till the pointers crosses each other
     *
     *  Increment the index and repeat the inner loop of the two pointers
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        java.util.Set<List<Integer>> answer = new java.util.HashSet<>();
        java.util.Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    if (!answer.contains(Arrays.asList(nums[i], nums[j], nums[k]))) {
                        answer.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                    j++;
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return new ArrayList<>(answer);
    }

    public void sortArrayOf_0s_1s_and_2s(List<Integer> arrayOf0s1sAnd2s) {

    }

    public int[] getFlipsToGetLongestSeriesOf1s(List<Integer> arrayOf0s1sAnd2s) {

        return null;
    }

    public int maxArea(int[] height) {
        int i = 0;
        int k = height.length - 1;
        int maxArea = 0;
        while (i < k) {
            maxArea = getMax(maxArea, (k - i) * getLower(height[i], height[k]));
            if (height[i] > height[k]) {
                k--;
            } else {
                i++;
            }
        }
        return maxArea;
    }

    private int getMax(int a, int b) {
        return (a > b) ? a : b;
    }
    private int getLower(int a, int b) {
        return (a < b) ? a : b;
    }
}
