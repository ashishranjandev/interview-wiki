package algo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RecursionTask5Subset {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(3);
        arrayList.add(1);
        arrayList.add(2);

        RecursionTask5Subset recursionTask5SubsetSum = new RecursionTask5Subset();
        System.out.println(recursionTask5SubsetSum.subsetSums(arrayList, arrayList.size()));

        int[] nums = new int[3];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 2;
        System.out.println(recursionTask5SubsetSum.subsetsWithDup(nums));

    }

    /**
     * Given a list arr of N integers, print sums of all subsets in it.
     *
     * @see https://practice.geeksforgeeks.org/problems/subset-sums2234/1
     *
     * @param arr
     * @param N
     * @return
     */
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> arrayListOfSums = new ArrayList<>();
        getSubsetSums(0, arr, 0, arrayListOfSums);
        Collections.sort(arrayListOfSums);
        return arrayListOfSums;
    }

    void getSubsetSums(int start, ArrayList<Integer> originalArray, int sum, ArrayList<Integer> arr) {
        if (start == originalArray.size()) {
            arr.add(sum);
            return;
        }

        getSubsetSums(start + 1, originalArray, sum + originalArray.get(start), arr);

        getSubsetSums(start + 1, originalArray, sum, arr);
    }


    /**
     * Given an integer array nums that may contain duplicates, return all possible
     * subsets
     *  (the power set).
     *
     * The solution set must not contain duplicate subsets. Return the solution in any order.
     *
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        getSubsets(0, nums, new ArrayList<>(), subsets);
        return subsets;
    }


    void getSubsets(int start, int[] originalArray, List<Integer> tempList, List<List<Integer>> answer) {
        answer.add(new ArrayList<>(tempList));
        for (int i = start; i < originalArray.length; i++) {

            // Do not pick if the elements are same
            if (i > start && originalArray[i] == originalArray[i - 1]) {
                continue;
            }
            tempList.add(originalArray[i]);
            getSubsets(i + 1, originalArray, tempList, answer);
            tempList.remove(tempList.size() - 1);
        }
    }
}
