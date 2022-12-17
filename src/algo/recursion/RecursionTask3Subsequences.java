package algo.recursion;

import java.util.ArrayList;
import java.util.List;

public class RecursionTask3Subsequences {
	
	public static void main(String[] args) {
		List<Integer> originalList = new ArrayList<>();
		originalList.add(3);
		originalList.add(1);
		originalList.add(2);
		printSubsequences(0, originalList, new ArrayList<>());
	}
	
	/**
	 * All subsequences are like branching by either picking or not picking an item as we go 
	 * 
	 * @param start
	 * @param originalList
	 * @param tempList
	 */
	public static void printSubsequences(int start, List<Integer> originalList, List<Integer> tempList) {
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

}
