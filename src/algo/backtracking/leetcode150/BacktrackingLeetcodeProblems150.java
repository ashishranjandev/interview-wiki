package algo.backtracking.leetcode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BacktrackingLeetcodeProblems150 {

    public static void main(String...args) {
        BacktrackingLeetcodeProblems150 backTrackingLeetCodeProblems = new BacktrackingLeetcodeProblems150();

        int[] inputArray = new int[] {1, 2, 3};
        System.out.println();
        System.out.println("Input is [1,2,3]");
        System.out.println("Expected output is [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]");
        System.out.println("Actual output is " + backTrackingLeetCodeProblems.subsets(inputArray));


        inputArray = new int[] {2, 3, 6, 7};
        System.out.println();
        System.out.println("Input is [2,3,6,7] and target sum is 7");
        System.out.println("Expected output is [[2,2,3],[7]]");
        System.out.println("Actual output is " + backTrackingLeetCodeProblems.combinationSum(inputArray, 7));

        inputArray = new int[] {1, 2, 3};
        System.out.println();
        System.out.println("Input is [1,2,3");
        System.out.println("Expected output is [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]");
        System.out.println("Actual output is " + backTrackingLeetCodeProblems.permute(inputArray));

        inputArray = new int[] {1, 2, 2};
        System.out.println();
        System.out.println("Input is [1,2,2]");
        System.out.println("Expected output is [[],[1],[1,2],[1,2,2],[2],[2,2]]");
        System.out.println("Actual output is " + backTrackingLeetCodeProblems.subsetsWithDup(inputArray));

        char[][] charsArray = new char[4][4];
        charsArray[0] = "ABCE".toCharArray();
        charsArray[1] = "SFCS".toCharArray();
        charsArray[2] = "ADEE".toCharArray();
        System.out.println();
        System.out.println("Input is");
        System.out.println("Input is [A,B,C,E]");
        System.out.println("Input is [S,F,C,S]");
        System.out.println("Input is [A,D,E,E]");
        System.out.println("Input word is ABCB");
        System.out.println("Expected output is false");
        System.out.println("Actual output is " + backTrackingLeetCodeProblems.exist(charsArray, "ABCB"));

        String stringToBePartitioned = "aab";
        System.out.println();
        System.out.println("aab");
        System.out.println("Expected output is [[\"a\",\"a\",\"b\"],[\"aa\",\"b\"]]");
        System.out.println("Actual output is " + backTrackingLeetCodeProblems.partition(stringToBePartitioned));

        stringToBePartitioned = "a";
        System.out.println();
        System.out.println("a");
        System.out.println("Expected output is [[\"a\"]]");
        System.out.println("Actual output is " + backTrackingLeetCodeProblems.partition(stringToBePartitioned));

        String letterCombination = "23";
        System.out.println();
        System.out.println("Input is 23");
        System.out.println("Expected output is [\"ad\",\"ae\",\"af\",\"bd\",\"be\",\"bf\",\"cd\",\"ce\",\"cf\"]");
        System.out.println("Actual output is " + backTrackingLeetCodeProblems.letterCombinations(letterCombination));

        int n = 4;
        System.out.println();
        System.out.println("Input is Board of Size 4");
        System.out.println("Expected output is [[\".Q..\",\"...Q\",\"Q...\",\"..Q.\"],[\"..Q.\",\"Q...\",\"...Q\",\".Q..\"]]");
        System.out.println("Actual output is " + backTrackingLeetCodeProblems.solveNQueens(n));

        n = 1;
        System.out.println();
        System.out.println("Input is Board of Size 1");
        System.out.println("Expected output is [[\"Q\"]]]");
        System.out.println("Actual output is " + backTrackingLeetCodeProblems.solveNQueens(n));

        // Test Case 1
        int[] candidates1 = {9, 2, 2, 4, 6, 1, 5};
        int target1 = 8;
        List<List<Integer>> expectedOutput1 = Arrays.asList(
                Arrays.asList(1, 2, 5),
                Arrays.asList(2, 2, 4),
                Arrays.asList(2, 6)
        );
        List<List<Integer>> actualOutput1 = backTrackingLeetCodeProblems.combinationSum2(candidates1, target1);
        System.out.println("Test Case 1");
        System.out.println("Expected Output: " + expectedOutput1);
        System.out.println("Actual Output: " + actualOutput1);
        System.out.println();

        // Test Case 2
        int[] candidates2 = {1, 2, 3, 4, 5};
        int target2 = 7;
        List<List<Integer>> expectedOutput2 = Arrays.asList(
                Arrays.asList(1, 2, 4),
                Arrays.asList(2, 5),
                Arrays.asList(3, 4)
        );
        List<List<Integer>> actualOutput2 = backTrackingLeetCodeProblems.combinationSum2(candidates2, target2);
        System.out.println("Test Case 2");
        System.out.println("Expected Output: " + expectedOutput2);
        System.out.println("Actual Output: " + actualOutput2);
        System.out.println();

        // Test Case 3
        int[] candidates3 = {2, 3, 5, 7};
        int target3 = 10;
        List<List<Integer>> expectedOutput3 = Arrays.asList(
                Arrays.asList(3, 7),
                Arrays.asList(2, 3, 5)
        );
        List<List<Integer>> actualOutput3 = backTrackingLeetCodeProblems.combinationSum2(candidates3, target3);
        System.out.println("Test Case 3");
        System.out.println("Expected Output: " + expectedOutput3);
        System.out.println("Actual Output: " + actualOutput3);
        System.out.println();

        // Test Case 4
        int[] candidates4 = {2, 3, 6, 7};
        int target4 = 7;
        List<List<Integer>> expectedOutput4 = Arrays.asList(
                Arrays.asList(7)
        );
        List<List<Integer>> actualOutput4 = backTrackingLeetCodeProblems.combinationSum2(candidates4, target4);
        System.out.println("Test Case 4");
        System.out.println("Expected Output: " + expectedOutput4);
        System.out.println("Actual Output: " + actualOutput4);
        System.out.println();

        // Test Case 5
        int[] candidates5 = {2, 5, 2, 1, 2};
        int target5 = 5;
        List<List<Integer>> expectedOutput5 = Arrays.asList(
                Arrays.asList(1, 2, 2),
                Arrays.asList(5)
        );
        List<List<Integer>> actualOutput5 = backTrackingLeetCodeProblems.combinationSum2(candidates5, target5);
        System.out.println("Test Case 5");
        System.out.println("Expected Output: " + expectedOutput5);
        System.out.println("Actual Output: " + actualOutput5);
        System.out.println();

        // Test Case 6
        int[] candidates6 = {10, 1, 2, 7, 6, 1, 5};
        int target6 = 8;
        List<List<Integer>> expectedOutput6 = Arrays.asList(
                Arrays.asList(1, 1, 6),
                Arrays.asList(1, 2, 5),
                Arrays.asList(1, 7),
                Arrays.asList(2, 6)
        );
        List<List<Integer>> actualOutput6 = backTrackingLeetCodeProblems.combinationSum2(candidates6, target6);
        System.out.println("Test Case 6");
        System.out.println("Expected Output: " + expectedOutput6);
        System.out.println("Actual Output: " + actualOutput6);
        System.out.println();

        char[][] board1 = {
                {'A', 'B', 'C', 'D'},
                {'S', 'A', 'A', 'T'},
                {'A', 'C', 'A', 'E'}
        };
        String word1 = "CAT";
        System.out.println("Test Case 1");
        System.out.println("Expected Output: " + true);
        System.out.println("Actual Output: " + backTrackingLeetCodeProblems.exist(board1, word1));
        System.out.println();

        // Test Case 2
        char[][] board2 = {
                {'A', 'B', 'C', 'D'},
                {'S', 'A', 'A', 'T'},
                {'A', 'C', 'A', 'E'}
        };
        String word2 = "BAT";
        System.out.println("Test Case 2");
        System.out.println("Expected Output: " + false);
        System.out.println("Actual Output: " + backTrackingLeetCodeProblems.exist(board2, word2));
        System.out.println();

        // Additional Test Case 3
        char[][] board3 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word3 = "ABCCED";
        System.out.println("Test Case 3");
        System.out.println("Expected Output: " + true);
        System.out.println("Actual Output: " + backTrackingLeetCodeProblems.exist(board3, word3));
        System.out.println();

        // Additional Test Case 4
        char[][] board4 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word4 = "SEE";
        System.out.println("Test Case 4");
        System.out.println("Expected Output: " + true);
        System.out.println("Actual Output: " + backTrackingLeetCodeProblems.exist(board4, word4));
        System.out.println();

        // Additional Test Case 5
        char[][] board5 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word5 = "ABCB";
        System.out.println("Test Case 5");
        System.out.println("Expected Output: " + false);
        System.out.println("Actual Output: " + backTrackingLeetCodeProblems.exist(board5, word5));
        System.out.println();

        String s1 = "aab";
        System.out.println("Expected Output: [[\"a\",\"a\",\"b\"],[\"aa\",\"b\"]]");
        System.out.println(partition(s1));

        String s2 = "a";
        System.out.println("Expected Output: [[\"a\"]]");
        System.out.println(partition(s2));

        String digits1 = "34";
        System.out.println("Expected Output: [\"dg\",\"dh\",\"di\",\"eg\",\"eh\",\"ei\",\"fg\",\"fh\",\"fi\"]");
        System.out.println(letterCombinations(digits1));

        String digits2 = "";
        System.out.println("Expected Output: []");
        System.out.println(letterCombinations(digits2));

        int n1 = 4;
        System.out.println("Expected Output: [[\".Q..\",\"...Q\",\"Q...\",\"..Q.\"],[\"..Q.\",\"Q...\",\"...Q\",\".Q..\"]]");
        System.out.println("Actual Output: " + solveNQueens(n1)); //

        int n2 = 1;
        System.out.println("Expected Output: [[\"Q\"]]");
        System.out.println("Actual Output: " + solveNQueens(n2));
    }

    /**
     * Subsets
     * Given an array nums of unique integers, return all possible subsets of nums.
     *
     * The solution set must not contain duplicate subsets. You may return the solution in any order.
     *
     * Example 1:
     *
     * Input: nums = [1,2,3]
     *
     * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * Example 2:
     *
     * Input: nums = [7]
     *
     * Output: [[],[7]]
     *
     * To solve this problem, we can use a backtracking approach. The idea is to explore all possible subsets by including
     * or excluding each element in the array.
     *
     * Initialization:
     * Start with an empty list to store all subsets.
     * Use a helper function to generate subsets recursively.
     * Backtracking:
     * For each element in the array, decide whether to include it in the current subset or not.
     * Recursively generate subsets for the remaining elements.
     * Add the current subset to the list of all subsets.
     * Base Case:
     * When we have considered all elements, add the current subset to the result list.
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {

        return null;
    }

    /**
     * Combination Target Sum
     * You are given an array of distinct integers nums and a target integer target. Your task is to return a list of all
     * unique combinations of nums where the chosen numbers sum to target.
     *
     * The same number may be chosen from nums an unlimited number of times. Two combinations are the same if the
     * frequency of each of the chosen numbers is the same, otherwise they are different.
     *
     * You may return the combinations in any order and the order of the numbers in each combination can be in any order.
     *
     * Example 1:
     *
     * Input:
     * nums = [2,5,6,9]
     * target = 9
     *
     * Output: [[2,2,5],[9]]
     * Explanation:
     * 2 + 2 + 5 = 9. We use 2 twice, and 5 once.
     * 9 = 9. We use 9 once.
     *
     * Example 2:
     *
     * Input:
     * nums = [3,4,5]
     * target = 16
     *
     * Output: [[3,3,3,3,4],[3,3,5,5],[4,4,4,4],[3,4,4,5]]
     * Example 3:
     *
     * Input:
     * nums = [3]
     * target = 5
     *
     * Output: []
     *
     * To solve this problem, we can use a backtracking approach. The idea is to explore all possible combinations by
     * including each number multiple times until the sum reaches or exceeds the target.
     *
     * Initialization:
     * Start with an empty list to store all valid combinations.
     * Use a helper function to generate combinations recursively.
     * Backtracking:
     * For each number in the array, decide whether to include it in the current combination.
     * Recursively generate combinations for the remaining target after including the current number.
     * If the current combination’s sum equals the target, add it to the result list.
     * If the sum exceeds the target, backtrack and try the next number.
     * Base Case:
     * When the sum of the current combination equals the target, add the combination to the result list.
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        return null;
    }

    /**
     * Permutations
     * Given an array nums of unique integers, return all the possible permutations. You may return the answer in any order.
     *
     * Example 1:
     *
     * Input: nums = [1,2,3]
     *
     * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * Example 2:
     *
     * Input: nums = [7]
     *
     * Output: [[7]]
     *
     * To generate all permutations, we can use a backtracking approach.
     * We recursively build permutations by swapping elements and exploring all possible positions for each element.
     *
     * The time complexity is \(O(n \times n!)\), where \(n\) is the number of elements in the input array. This is
     * because there are \(n!\) permutations, and generating each permutation takes \(O(n)\) time.
     *
     * The space complexity is \(O(n)\) for the recursion stack and the temporary list used to store the current
     * permutation.
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue; // Element already exists, skip
                tempList.add(nums[i]);
                backtrack(result, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    /**
     * Subsets II
     * You are given an array nums of integers, which may contain duplicates. Return all possible subsets.
     *
     * The solution must not contain duplicate subsets. You may return the solution in any order.
     *
     * Example 1:
     *
     * Input: nums = [1,2,1]
     *
     * Output: [[],[1],[1,2],[1,1],[1,2,1],[2]]
     * Example 2:
     *
     * Input: nums = [7,7]
     *
     * Output: [[],[7], [7,7]]
     *
     * To generate all subsets while avoiding duplicates, we can use a backtracking approach with sorting.
     * Sorting the array helps to easily skip duplicates.
     *
     * The time complexity is \(O(2^n)\), where \(n\) is the number of elements in the input array.
     * This is because there are \(2^n\) possible subsets.
     * The space complexity is \(O(n)\) for the recursion stack and the temporary list used to store the current subset.
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue; // Skip duplicates
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    /**
     * Combination Target Sum II
     * You are given an array of integers candidates, which may contain duplicates, and a target integer target. Your task
     * is to return a list of all unique combinations of candidates where the chosen numbers sum to target.
     *
     * Each element from candidates may be chosen at most once within a combination. The solution set must not contain
     * duplicate combinations.
     *
     * You may return the combinations in any order and the order of the numbers in each combination can be in any order.
     *
     * Example 1:
     *
     * Input: candidates = [9,2,2,4,6,1,5], target = 8
     *
     * Output: [
     *   [1,2,5],
     *   [2,2,4],
     *   [2,6]
     * ]
     * Example 2:
     *
     * Input: candidates = [1,2,3,4,5], target = 7
     *
     * Output: [
     *   [1,2,4],
     *   [2,5],
     *   [3,4]
     * ]
     *
     *  To generate all unique combinations, we can use a backtracking approach with sorting.
     *  Sorting helps to easily skip duplicates and ensure combinations are unique.
     *
     *  The time complexity is \(O(2^n)\), where \(n\) is the number of elements in the input array.
     *  This is because each element can either be included or excluded, leading to \(2^n\) possible combinations.
     *
     *  The space complexity is \(O(n)\) for the recursion stack and the temporary list used to store the current combination.
     *
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
        if (remain < 0) {
            return; // If the remaining target is negative, no valid combination
        } else if (remain == 0) {
            result.add(new ArrayList<>(tempList)); // Found a valid combination
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) continue; // Skip duplicates
                tempList.add(candidates[i]);
                backtrack(result, tempList, candidates, remain - candidates[i], i + 1);
                tempList.remove(tempList.size() - 1); // Backtrack
            }
        }
    }

    /**
     * Search for Word
     * Given a 2-D grid of characters board and a string word, return true if the word is present in the grid, otherwise
     * return false.
     *
     * For the word to be present it must be possible to form it with a path in the board with horizontally or vertically
     * neighboring cells. The same cell may not be used more than once in a word.
     *
     * Example 1:
     *
     *
     *
     * Input:
     * board = [
     *   ["A","B","C","D"],
     *   ["S","A","A","T"],
     *   ["A","C","A","E"]
     * ],
     * word = "CAT"
     *
     * Output: true
     * Example 2:
     *
     *
     *
     * Input:
     * board = [
     *   ["A","B","C","D"],
     *   ["S","A","A","T"],
     *   ["A","C","A","E"]
     * ],
     * word = "BAT"
     *
     * Output: false
     *
     * This method iterates through each cell in the grid and starts a DFS from each cell to find the word.
     *
     * Solution Explanation: To search for the word in the grid, we can use a backtracking approach.
     * We start from each cell and explore all possible paths to find the word.
     *
     * The time complexity is \(O(m \times n \times 4^L)\), where \(m\) is the number of rows, \(n\) is the number of
     * columns, and \(L\) is the length of the word. This is because we start a DFS from each cell, and each cell has up
     * to 4 possible directions to explore.
     *
     * The space complexity is \(O(L)\) for the recursion stack, where \(L\) is the length of the word.
     *
     *
     *
     * @param board
     * @param word
     * @return
     */
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method performs the DFS. It checks if the current cell matches the current character of the word.
     * If all characters are matched (index == word.length()), it returns true.
     * If the current cell is out of bounds or does not match the current character, it returns false.
     * It marks the current cell as visited by setting it to # and then explores all four possible directions (up, down,
     * left, right).
     * After exploring, it unmarks the cell by restoring its original value.
     *
     * @param board
     * @param word
     * @param i
     * @param j
     * @param index
     * @return
     */
    private static boolean backtrack(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true; // All characters matched
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(index)) {
            return false; // Out of bounds or character mismatch
        }

        char temp = board[i][j];
        board[i][j] = '#'; // Mark the cell as visited

        boolean found = backtrack(board, word, i + 1, j, index + 1) ||
                backtrack(board, word, i - 1, j, index + 1) ||
                backtrack(board, word, i, j + 1, index + 1) ||
                backtrack(board, word, i, j - 1, index + 1);

        board[i][j] = temp; // Unmark the cell
        return found;
    }

    /**
     * Palindrome Partitioning
     * Given a string s, split s into substrings where every substring is a palindrome. Return all possible lists of
     * palindromic substrings.
     *
     * You may return the solution in any order.
     *
     * Example 1:
     *
     * Input: s = "aab"
     *
     * Output: [["a","a","b"],["aa","b"]]
     * Example 2:
     *
     * Input: s = "a"
     *
     * Output: [["a"]]
     *
     * This method initializes the result list and calls the backtrack method to generate all possible palindromic partitions.
     *
     * The time complexity is (O(n \times 2^n)), where (n) is the length of the input string.
     * This is because there are (2^n) possible partitions, and checking each partition takes (O(n)) time.
     * Space complexity is (O(n)) for the recursion stack and the temporary list used to store the current partition.
     *
     * @param s
     * @return
     */
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    /**
     * backtrack Method:
     * result: The list that stores all possible lists of palindromic substrings.
     * tempList: The current list of palindromic substrings being constructed.
     * s: The input string.
     * start: The starting index for the current partition.
     * The method checks if the starting index has reached the end of the string. If so, it adds the current list to the
     * result list.
     * It then iterates over the substring starting from the start index, checks if each substring is a palindrome, and
     * recursively generates partitions for the remaining substring.
     *
     * @param result
     * @param tempList
     * @param s
     * @param start
     */
    private static void backtrack(List<List<String>> result, List<String> tempList, String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    tempList.add(s.substring(start, i + 1));
                    backtrack(result, tempList, s, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    /**
     * This method checks if a given substring (from index low to high) is a palindrome by comparing characters from both
     * ends towards the center.
     *
     * @param s
     * @param low
     * @param high
     * @return
     */
    private static boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Combinations of a Phone Number
     * You are given a string digits made up of digits from 2 through 9 inclusive.
     *
     * Each digit (not including 1) is mapped to a set of characters as shown below:
     *
     * A digit could represent any one of the characters it maps to.
     *
     * Return all possible letter combinations that digits could represent. You may return the answer in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: digits = "34"
     *
     * Output: ["dg","dh","di","eg","eh","ei","fg","fh","fi"]
     * Example 2:
     *
     * Input: digits = ""
     *
     * Output: []
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result; // Return empty list if input is empty
        }
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    private static void backtrack(List<String> result, StringBuilder temp, String digits, int start) {
        // If the current combination is complete, add it to the result list
        if (start == digits.length()) {
            result.add(temp.toString());
            return;
        }
        // Get the characters that the current digit maps to
        String letters = KEYPAD[digits.charAt(start) - '0'];
        // Iterate over each character and append it to the current combination
        for (char c : letters.toCharArray()) {
            temp.append(c);
            // Recursively generate combinations for the next digit
            backtrack(result, temp, digits, start + 1);
            // Remove the last character to backtrack and explore other possibilities
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    // Mapping of digits to corresponding characters
    private static final String[] KEYPAD = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    /**
     * N-Queens
     * The n-queens puzzle is the problem of placing n queens on an n x n chessboard so that no two queens can attack each
     * other.
     *
     * A queen in a chessboard can attack horizontally, vertically, and diagonally.
     *
     * Given an integer n, return all distinct solutions to the n-queens puzzle.
     *
     * Each solution contains a unique board layout where the queen pieces are placed. 'Q' indicates a queen and '.'
     * indicates an empty space.
     *
     * You may return the answer in any order.
     *
     * Example 1:
     *
     *
     *
     * Input: n = 4
     *
     * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
     * Explanation: There are two different solutions to the 4-queens puzzle.
     *
     * Example 2:
     *
     * Input: n = 1
     *
     * Output: [["Q"]]
     *
     * @param n
     * @return
     */
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(result, board, 0);
        return result;
    }

    private static void backtrack(List<List<String>> result, char[][] board, int row) {
        if (row == board.length) {
            result.add(construct(board));
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(result, board, row + 1);
                board[row][col] = '.'; // Backtrack
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private static List<String> construct(char[][] board) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            path.add(new String(board[i]));
        }
        return path;
    }
}
