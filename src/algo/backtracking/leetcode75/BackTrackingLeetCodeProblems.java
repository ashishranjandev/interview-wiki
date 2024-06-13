package algo.backtracking.leetcode75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class BackTrackingLeetCodeProblems {

    public static void main(String...args) {
        BackTrackingLeetCodeProblems backTrackingLeetCodeProblems = new BackTrackingLeetCodeProblems();

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
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        Set<Integer> columnsSet = new HashSet<>();
        Set<Integer> positiveDiag = new HashSet<>();
        Set<Integer> negativeDiag = new HashSet<>();

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        getNQueenSolution(0, board, columnsSet, positiveDiag, negativeDiag, result);

        return result;
    }

    private void getNQueenSolution(int rowNum, char[][] board, Set<Integer> columnsSet, Set<Integer> positiveDiag,
                                   Set<Integer> negativeDiag, List<List<String>> result) {
        if (rowNum == board.length) {
            List<String> resultCopy = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                resultCopy.add(String.valueOf(board[i]));
            }
            result.add(resultCopy);
        }

        for (int col = 0; col < board[0].length; col++) {
            if (!columnsSet.contains(col) && !positiveDiag.contains(rowNum + col) && !negativeDiag.contains(rowNum - col)) {
                columnsSet.add(col);
                positiveDiag.add(rowNum + col);
                negativeDiag.add(rowNum - col);
                board[rowNum][col] = 'Q';

                getNQueenSolution(rowNum + 1, board, columnsSet, positiveDiag, negativeDiag, result);

                columnsSet.remove(col);
                positiveDiag.remove(rowNum + col);
                negativeDiag.remove(rowNum - col);
                board[rowNum][col] = '.';
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if("".equals(digits)) {
            return new ArrayList<>(0);
        }

        List<String> answer = new ArrayList<>();
        Map<Character, String> values = new HashMap<>();
        values.put('2', "abc");
        values.put('3', "def");
        values.put('4', "ghi");
        values.put('5', "jkl");
        values.put('6', "mno");
        values.put('7', "pqrs");
        values.put('8', "tuv");
        values.put('9', "wxyz");

        getLetterCombinations(0, digits, values, "", answer);
        return answer;
    }

    public void getLetterCombinations(int i, String digits, Map<Character, String> values,
                                      String tempString, List<String> answer) {
        if (tempString.length() == digits.length()) {
            answer.add(tempString);
            return;
        }
        System.out.println(digits);
        for (char c : values.get(digits.charAt(i)).toCharArray()) {
            getLetterCombinations(i + 1, digits, values, tempString + c, answer);
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> answerArray = new ArrayList<>();
        getPartitions(s, 0, new ArrayList<>(), answerArray);
        return answerArray;
    }

    public void getPartitions(String s, int i, List<String> tempList, List<List<String>> answer) {
        if (i >= s.length()) {
            answer.add(new ArrayList<>(tempList));
        }
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(i, j, s)) {
                tempList.add(s.substring(i, j + 1));
                getPartitions(s, j + 1, tempList, answer);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(int i, int j, String A) {
        // comparing the two pointers
        if (i >= j) {
            return true;
        }
        // comparing the characters on those pointers
        if (A.charAt(i) != A.charAt(j)) {
            return false;
        }
        // checking everything again recursively
        return isPalindrome(i + 1, j - 1, A);
    }

    public boolean exist(char[][] board, String word) {
        Set<BoardPosition> boardPositionSet = new HashSet<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (wordExists(row, col, 0, boardPositionSet, board, word.toCharArray())) {
                    return true;
                }
            }
        }
        return wordExists(0,0, 0, boardPositionSet, board, word.toCharArray());
    }

    public boolean wordExists(int row, int column, int indexInWord, Set<BoardPosition> boardPositionSet,
                              char[][] board, char[] word) {
        if (indexInWord >= word.length) {
            return true;
        }
        if (row < 0
                || column < 0
                || row >= board.length
                || column >= board[0].length
                || board[row][column] != word[indexInWord]
                || boardPositionSet.contains(new BoardPosition(row, column))) {
            return  false;
        }
        boardPositionSet.add(new BoardPosition(row, column));
        boolean response = wordExists(row + 1, column, indexInWord + 1, boardPositionSet, board, word)
                            || wordExists(row - 1, column, indexInWord + 1, boardPositionSet, board, word)
                            || wordExists(row, column + 1, indexInWord + 1, boardPositionSet, board, word)
                            || wordExists(row, column - 1, indexInWord + 1, boardPositionSet, board, word);
        boardPositionSet.remove(new BoardPosition(row, column));
        return response;
    }

    class BoardPosition {
        int rowNum;
        int colNum;

        BoardPosition(int rowNum, int colNum) {
            this.rowNum = rowNum;
            this.colNum = colNum;
        }

        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            BoardPosition that = (BoardPosition) o;
            return rowNum == that.rowNum && colNum == that.colNum;
        }

        @Override public int hashCode() {
            return Objects.hash(rowNum, colNum);
        }
    }

    /**
     * Proper approach is to go to every element and make 2 decision branches.
     * * To include the current value
     * * Not include the current value
     *
     * If the current element is same as previous element we should skip it to avoid duplicates.
     * So if 1st 2 is picked, 2nd 2 will also be picked.
     * However if the 1st 2 is skipped the 2nd 2 will also be skipped.
     *
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        getSubsetsWithDup(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void getSubsetsWithDup(int index, int[] nums, List<Integer> intNums, List<List<Integer>> result) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(intNums));
            return;
        }
        intNums.add(nums[index]);
        getSubsetsWithDup(index + 1, nums, intNums, result);
        intNums.remove(intNums.size() - 1);

        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }
        getSubsetsWithDup(index + 1, nums, intNums, result);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numsList = new ArrayList<>(nums.length);
        for (int num : nums) {
            numsList.add(num);
        }
        return getPermutations(numsList, result);
    }

    public List<List<Integer>> getPermutations(List<Integer> nums, List<List<Integer>> result) {
        System.out.println("Getting Permutations for " + nums);
        if (nums.size() == 1) {
            List<List<Integer>> resultArrayList = new ArrayList<>();
            List<Integer> newArrayList = new ArrayList<>();
            newArrayList.add(nums.get(0));
            resultArrayList.add(newArrayList);
            return resultArrayList;
        }

        for (int i = 0; i < nums.size(); i++ ) {
            Integer poppedNum = nums.remove(0);
            List<List<Integer>> permutations = getPermutations(nums, result);
            for (List<Integer> permutation : permutations) {
                permutation.add(poppedNum);
            }
            result.addAll(permutations);
            nums.add(poppedNum);
        }

        return result;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(0, 0, target, candidates, new ArrayList<>(), result);
        return result;
    }

    private void findCombinations(int i, int total, int target, int[] candidates, List<Integer> tempList,
                             List<List<Integer>> result) {
        if (total == target) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        if (total > target || i >= candidates.length) {
            return;
        }
        tempList.add(candidates[i]);
        findCombinations(i, total + candidates[i], target, candidates, tempList, result);

        tempList.remove(tempList.size() - 1);
        findCombinations(i + 1, total, target, candidates, tempList, result);
    }

    /**
     * BackTracking -
     *
     * Add the arr[i] to temp list and then call from i+1
     * remove the arr[i] to temp list and then call from i+1
     *
     * Start from 0 index
     * if i becomes out of bound add temp list to answer list
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        getSubsets(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private void getSubsets(int ar[], int i, List<Integer> newList, List<List<Integer>> result) {
        if (i >= ar.length) {
            result.add(new ArrayList<>(newList));
            return;
        }
        newList.add(ar[i]);
        getSubsets(ar, i + 1, newList, result);

        newList.remove(newList.size() - 1);
        getSubsets(ar, i + 1, newList, result);
    }
}
