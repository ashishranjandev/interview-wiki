package algo.recursion;

import java.util.ArrayList;
import java.util.List;

public class RecursionTask6Permutations {

    public static void main(String...args) {
        int[] nums = new int[3];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        System.out.println(new RecursionTask6Permutations().permute(nums));

        System.out.println(new RecursionTask6Permutations().permute2(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] booleanArray = new boolean[nums.length];
        getPermutations(nums, new ArrayList<>(), booleanArray, answer);
        return answer;
    }

    private void getPermutations(int[] nums, List<Integer> tempList, boolean[] booleanArray,
                                 List<List<Integer>> answer) {
        // After the recursion tree is over. The size of tempList would be equal to nums size
        if (tempList.size() == nums.length) {
            answer.add(new ArrayList<>(tempList));
        }

        // We will iterate over every elements and pick the ones that have not been picked using boolean array
        // After recursion call .. remove the element from temp array and reset the boolean array
        for (int i = 0; i < nums.length; i++) {
            if (!booleanArray[i]) {
                tempList.add(nums[i]);
                booleanArray[i] = true;
                getPermutations(nums, tempList, booleanArray, answer);
                booleanArray[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        getPermutationsBySwapping(0, nums, answer);
        return answer;
    }

    private void getPermutationsBySwapping(int start, int[] nums, List<List<Integer>> answer) {
        if (start == nums.length) {
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                tempList.add(nums[i]);
            }
            answer.add(tempList);
        }

        for (int k = start; k < nums.length; k++) {
            swap(k, start, nums);
            getPermutationsBySwapping(k + 1, nums, answer);
            swap(k, start, nums);
        }

    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
