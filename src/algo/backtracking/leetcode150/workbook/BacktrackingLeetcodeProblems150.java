package algo.backtracking.leetcode150.workbook;

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

    public List<List<Integer>> subsets(int[] nums) {

        return null;
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {

        return null;
    }

    public List<List<Integer>> permute(int[] nums) {

        return null;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        return null;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        return null;
    }

    public boolean exist(char[][] board, String word) {

        return false;
    }

    public List<List<String>> partition(String s) {

        return null;
    }

    public List<String> letterCombinations(String digits) {

        return null;
    }

    public List<List<String>> solveNQueens(int n) {

        return null;
    }
}
