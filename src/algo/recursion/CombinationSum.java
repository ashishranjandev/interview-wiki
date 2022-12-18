package algo.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main (String[] args) {
        int[] candidates = new int[3];
        candidates[0] = 2;
        candidates[1] = 3;
        candidates[2] = 5;

        CombinationSum cs = new CombinationSum();
        System.out.println(cs.combinationSum(candidates, 8).toString());
    }

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

        findCombinations(start + 1, target, originalArr, tempList, answer);
    }


}
