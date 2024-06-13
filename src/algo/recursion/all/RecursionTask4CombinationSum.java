package algo.recursion.all;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursionTask4CombinationSum {

    public static void main (String[] args) {
        int[] candidates = new int[3];
        candidates[0] = 2;
        candidates[1] = 3;
        candidates[2] = 5;

        RecursionTask4CombinationSum cs = new RecursionTask4CombinationSum();
        System.out.println(cs.combinationSum(candidates, 8).toString());

        candidates = new int[5];
        candidates[0] = 1;
        candidates[1] = 1;
        candidates[2] = 1;
        candidates[3] = 2;
        candidates[4] = 2;

        System.out.println(cs.combinationSum2(candidates, 4).toString());
    }


    /**
     *
     * Given an array of distinct integers candidates and a target integer target, return a list of all unique
     * combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
     *
     * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
     * frequency of at least one of the chosen numbers is different.
     *
     * @param candidates
     * @param target
     * @return
     *
     * @see https://leetcode.com/problems/combination-sum/
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        findCombinations(0, target, candidates, new ArrayList<>(), answer);
        return answer;
    }


    public void findCombinations(int start, int target, int[] originalArr, List<Integer> tempList,
                                                List<List<Integer>> answer) {
        if (target == 0) {
            answer.add(new ArrayList<>(tempList));
            return;
        }
        if (start == originalArr.length) {
            return;
        }

        if (originalArr[start] <= target) {
            // Pick
            tempList.add(originalArr[start]);

            // We are not incrementing the index
            // and keep trying the same index till adding new element will take sum higher or equal to target
            // i.e. originalArr[start] <= target
            findCombinations(start, target - originalArr[start], originalArr, tempList, answer);

            // Not Pick
            tempList.remove(tempList.size() - 1);
        }

        // After exhausting all possibilities with start
        // Now try with next index - start + 1
        findCombinations(start + 1, target, originalArr, tempList, answer);
    }


    /**
     * Given a collection of candidate numbers (candidates) and a target number (target), find all unique
     * combinations in candidates where the candidate numbers sum to target.
     *
     * Each number in candidates may only be used once in the combination.
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }


    private void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            // If the element is same as previous element the result
            // result would be same. Hence skipping
            if (i > ind && arr[i] == arr[i - 1]) continue;

            // If the element is already greater than target
            // No need to continue the queue
            if (arr[i] > target) break;

            ds.add(arr[i]);
            findCombinations(i + 1, arr, target - arr[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
    }


    public List<List<Integer>> combinationSum2NotWorking(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations2NotWorking(0, target, candidates, new ArrayList<>(), answer);
        return answer;
    }

    public void findCombinations2NotWorking(int start, int target, int[] originalArr, List<Integer> tempList,
                                            List<List<Integer>> answer) {
        if (target == 0) {
            answer.add(new ArrayList<>(tempList));
            return;
        }

        if (start == originalArr.length) {
            return;
        }

        for (int i = start; i < originalArr.length; i++) {
            if (originalArr[i] > target) {
                break;
            }
            if (i > start && originalArr[i] == originalArr[i - 1]) {
                continue;
            }

            tempList.add(originalArr[i]);
            findCombinations2NotWorking(start + 1, target - originalArr[i], originalArr, tempList, answer);
            tempList.remove(tempList.size() - 1);
        }
    }
}
