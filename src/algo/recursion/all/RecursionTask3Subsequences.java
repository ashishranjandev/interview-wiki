package algo.recursion.all;

import java.util.ArrayList;
import java.util.List;

public class RecursionTask3Subsequences {
	
	public static void main(String[] args) {
		List<Integer> originalList = new ArrayList<>();
		originalList.add(3);
		originalList.add(1);
		originalList.add(2);

		System.out.println("Print the subsequences of list ; [3, 1, 2]");
		printSubsequences(0, originalList, new ArrayList<>());

		System.out.println("Print the subsequences of list ; [3, 1, 2] with sum : 2");
		printSubsequencesWithGivenSum(0, originalList, new ArrayList<>(), 0, 2);

		System.out.println("Print any subsequences of list ; [3, 1, 2] with sum : 2");
		printAnySubsequencesWithGivenSum(0, originalList, new ArrayList<>(), 0, 2);

		System.out.println("Count of subsequences of list ; [3, 1, 2] with sum : 2 is " +
								   getCountOfSubsequencesWithGivenSum(0, originalList, new ArrayList<>(), 0, 2));


		originalList = new ArrayList<>();
		originalList.add(1);
		originalList.add(2);
		originalList.add(1);

		System.out.println("Print the subsequences of list ; [1, 2, 1]");
		printSubsequences(0, originalList, new ArrayList<>());

		System.out.println("Print the subsequences of list ; [1, 2, 1] with sum : 2");
		printSubsequencesWithGivenSum(0, originalList, new ArrayList<>(), 0, 2);

		System.out.println("Print any subsequences of list ; [1, 2, 1] with sum : 2");
		printAnySubsequencesWithGivenSum(0, originalList, new ArrayList<>(), 0, 2);

		System.out.println("Count of subsequences of list ; [1, 2, 1] with sum : 2 is " +
								   getCountOfSubsequencesWithGivenSum(0, originalList, new ArrayList<>(), 0, 2));
	}
	
	/**
	 * All subsequences are like branching by either picking or not picking an item as we go 
	 * 
	 * @param start
	 * @param originalList
	 * @param tempList
	 */
	static void printSubsequences(int start, List<Integer> originalList, List<Integer> tempList) {
		if (start >= originalList.size()) {
			System.out.println(tempList.toString());
			return;
		}
		// take or pick the particular index in the subsequence
		tempList.add(originalList.get(start));
		printSubsequences(start + 1, originalList, tempList);
		
		// don't take or pick the particular index in the subsequence
		tempList.remove(tempList.size() - 1);
		printSubsequences(start + 1, originalList, tempList);
	}

	static void printSubsequencesWithGivenSum(int start, List<Integer> originalList, List<Integer> tempList, int sum,
										  int finalSum) {
		if (sum == finalSum) {
			System.out.println(tempList.toString());
			return;
		}
		if (start >= originalList.size()) {
			return;
		}

		tempList.add(originalList.get(start));
		sum += originalList.get(start);
		printSubsequencesWithGivenSum(start + 1, originalList, tempList, sum, finalSum);

		tempList.remove(tempList.size() - 1);
		sum -= originalList.get(start);
		printSubsequencesWithGivenSum(start + 1, originalList, tempList, sum, finalSum);
	}

	static boolean printAnySubsequencesWithGivenSum(int start, List<Integer> originalList, List<Integer> tempList,
												  int sum, int finalSum) {
		// condition not satisfied
		// to be done if we are sure array contains positives
		if (sum > finalSum) {
			return false;
		}
		if (sum == finalSum) {
			System.out.println(tempList.toString());
			return true;
		}
		if (start >= originalList.size()) {
			return false;
		}

		tempList.add(originalList.get(start));
		sum += originalList.get(start);
		if (printAnySubsequencesWithGivenSum(start + 1, originalList, tempList, sum, finalSum)) {
			return true;
		}

		tempList.remove(tempList.size() - 1);
		sum -= originalList.get(start);
		if (printAnySubsequencesWithGivenSum(start + 1, originalList, tempList, sum, finalSum)) {
			return true;
		}
		return false;
	}

	static int getCountOfSubsequencesWithGivenSum(int start, List<Integer> originalList, List<Integer> tempList,
													int sum, int finalSum) {
		// condition not satisfied
		// to be done if we are sure array contains positives
		if (sum > finalSum) {
			return 0;
		}
		if (sum == finalSum) {
			return 1;
		}
		if (start >= originalList.size()) {
			return 0;
		}

		tempList.add(originalList.get(start));
		sum += originalList.get(start);
		int l = getCountOfSubsequencesWithGivenSum(start + 1, originalList, tempList, sum, finalSum);

		tempList.remove(tempList.size() - 1);
		sum -= originalList.get(start);
		int r = getCountOfSubsequencesWithGivenSum(start + 1, originalList, tempList, sum, finalSum);
		return l + r;
	}

}
