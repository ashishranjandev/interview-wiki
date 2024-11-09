package workbook.algo;

import java.util.Arrays;
import java.util.List;

public class BacktrackingLeetcodeProblems150 {

    public static void main(String...args) {
        algo.backtracking.leetcode150.BacktrackingLeetcodeProblems150 backTrackingLeetCodeProblems = new algo.backtracking.leetcode150.BacktrackingLeetcodeProblems150();

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
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {

        return null;
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
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        return null;
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
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        return null;
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
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {

        return false;
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
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {

        return null;
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
    public List<String> letterCombinations(String digits) {

        return null;
    }

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
    public List<List<String>> solveNQueens(int n) {

        return null;
    }
}
