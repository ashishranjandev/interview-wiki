package ds.arrays.binarysearch.leetcode;

/**
 *
 * Type 1 (Some ad-hoc Binary Search Problems)
 * <ul>
 *  <li>https://www.geeksforgeeks.org/order-agnostic-binary-search/</li>
 *  <li>https://leetcode.com/problems/search-insert-position/</li>
 *  <li>https://leetcode.com/problems/search-a-2d-matrix/</li>
 *  <li>https://leetcode.com/problems/sqrtx/</li>
 *  <li>https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/ (IMP)</li>
 *  <li>https://leetcode.com/problems/two-sum-less-than-k/</li>
 *  <li>https://www.geeksforgeeks.org/count-numbers-difference-number-digit-sum-greater-specific-value/ (Google Question)</li>
 *  <li>https://leetcode.com/problems/median-of-two-sorted-arrays/ (HARD)</li>
 * </ul>
 *
 * Type 2 (Understanding Lower Bound and Upper Bound)
 * Implement lower_bound and upper_bound functions of C++ on your own.
 * <ul>
 *  <li>https://leetcode.com/problems/first-bad-version/</li>
 *  <li>https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/</li>
 *  <li>https://www.geeksforgeeks.org/ceiling-in-a-sorted-array/</li>
 *  <li>https://leetcode.com/problems/h-index-ii/</li>
 * </ul>
 *
 * Type 3 (Find the pivot first , and then search)
 *
 * N.B - Whenever there is a rotated or a mountain array and we need to search in that array. First find the
 * inflection point i.e the peak element in case of mountain array or min element or pivot in case of rotated array.
 * This makes our search much easier though we have to do two binary searches.
 *
 * https://leetcode.com/problems/find-peak-element/
 * https://leetcode.com/problems/find-in-mountain-array/
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/ (Also similar to finding the pivot point where
 * the array was rotated)
 *  https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * Type 4 (Binary Search on a row wise sorted Matrix)
 *
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 * https://www.geeksforgeeks.org/find-median-row-wise-sorted-matrix/
 *
 *
 * Type 5  (Minimizing the Maximum or maximizing the minimum)
 * (Doesn’t directly look like a binary search problem)
 *
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 * https://leetcode.com/problems/split-array-largest-sum/
 * https://leetcode.com/problems/divide-chocolate/
 * https://www.interviewbit.com/problems/painters-partition-problem/
 * https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1/
 * https://www.spoj.com/problems/AGGRCOW/
 * https://leetcode.com/problems/minimize-max-distance-to-gas-station/
 * https://leetcode.com/problems/path-with-minimum-effort/
 * https://leetcode.com/problems/koko-eating-bananas/
 *
 * @author Ashish Ranjan
 */
public class BinarySearchLeetCodeProblems {

    public static void main(String...args) {
        BinarySearchLeetCodeProblems binarySearchLeetCodeProblems = new BinarySearchLeetCodeProblems();
        int[] nums = null;

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
        int answerInt = binarySearchLeetCodeProblems.search(nums, 0);
        System.out.print("Solution for Search in rotated array for [4,5,6,7,0,1,2] with target 0 is - " + answerInt);

        System.out.println();
        // Input: nums = [4,5,6,7,0,1,2], target = 0
        // Output: 4
        nums = new int[3];
        nums[0] = 5;
        nums[1] = 1;
        nums[2] = 3;
        answerInt = binarySearchLeetCodeProblems.search(nums, 5);
        System.out.print("Solution for Search in rotated array for [5,1,3] with target 5 is - " + answerInt);


        System.out.println();
        // Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
        // Output: true
        int[][] matrix = new int[3][4];
        matrix[0][0] = 1;
        matrix[0][1] = 3;
        matrix[0][2] = 5;
        matrix[0][3] = 7;

        matrix[1][0] = 10;
        matrix[1][1] = 11;
        matrix[1][2] = 16;
        matrix[1][3] = 20;

        matrix[2][0] = 23;
        matrix[2][1] = 30;
        matrix[2][2] = 34;
        matrix[2][3] = 60;
        boolean answerBool = binarySearchLeetCodeProblems.searchMatrix(matrix, 3);
        System.out.print("Solution for Matrix [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3 is - " + answerBool);



        System.out.println();
        // Input: nums = [3,4,5,1,2]
        // Output: 1
        // Explanation: The original array was [1,2,3,4,5] rotated 3 times.
        nums = new int[5];
        nums[0] = 3;
        nums[1] = 4;
        nums[2] = 5;
        nums[3] = 1;
        nums[4] = 2;
        answerInt = binarySearchLeetCodeProblems.findMin(nums);
        System.out.print("Solution for min in rotated array [3,4,5,1,2] is - " + answerInt);


        System.out.println();
        // Input: nums = [11,13,15,17]
        // Output: 11
        // Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
        nums = new int[4];
        nums[0] = 11;
        nums[1] = 13;
        nums[2] = 15;
        nums[3] = 17;
        answerInt = binarySearchLeetCodeProblems.findMin(nums);
        System.out.print("Solution for min in rotated array [11,13,15,17] is - " + answerInt);
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


    /**
     * Since the entire matrix is sorted we can try binary search.
     * First we need to find which row the number can belong to so we can apply binary search there.
     *
     * We get row count and go to mid to find out if the target is between first element of mid row and last element
     * of mid row
     * If yes
     *   we return the mid as the row where binary search can be applied.
     * if no and target is less than first element
     *    search in left rowset by moving right to mid -1
     * if no and target is greater than first element
     *     search in right rowset by moving left to mid +1
     *
     * If row is not found
     *   return false
     * else
     *   If row is found
     *     Apply binary search to the row
     *     return true if target is found
     *
     * return false
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int totalRows = matrix.length;
        int totalColumns = matrix[0].length;

        int left =0;
        int mid = -1;
        int right = totalRows - 1;
        int rowToSearch = -1;

        while (left <= right) {
            mid = (left + right)/2;
            if (matrix[mid][0] <= target && target <= matrix[mid][totalColumns - 1]) {
                rowToSearch = mid;
                break;
            } else if (target < matrix[mid][0]) {
                right = mid - 1;
            } else if (target > matrix[mid][totalColumns - 1]) {
                left = mid + 1;
            }
        }


        if (rowToSearch == -1) {
            return false;
        }

        left = 0;
        right = totalColumns - 1;
        while (left <= right) {
            mid = (left + right)/2;
            if (matrix[rowToSearch][mid] == target) {
                return true;
            } else if (target < matrix[rowToSearch][mid]) {
                right = mid - 1;
            } else if (target > matrix[rowToSearch][mid]) {
                left = mid + 1;
            }
        }
        return false;
    }

    /**
     * Implement Binary Search
     *
     * Keep a variable for min
     *
     * Start Binary Search
     *
     * if the array is sorted
     *  check for left of array with min and replace with lower value
     * else
     *  check for mid of array with min and replace with lower value
     *
     * return min
     *
     * @param arr
     * @return
     */
    public int findMin(int[] arr) {
        int left = 0;
        int mid = -1;
        int right = arr.length - 1;
        int min = arr[0];

        while (left <= right) {
            if (arr[left] <= arr[right]) {
                min = min < arr[left] ? min : arr[left];
            }

            mid = (left + right) / 2;
            min = min < arr[mid] ? min : arr[mid];
            if (arr[mid] >= arr[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return min;
    }
}
