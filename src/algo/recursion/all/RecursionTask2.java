package algo.recursion.all;

public class RecursionTask2 {
	
	/**
	 * Reverse an array
	 * Check if a string is pallindrone
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 3, 4, 5};
		System.out.println("Print Array before reversal");
		printArray(arr);
		reverseArray(0, arr);
		System.out.println("Print Array after reversal");
		printArray(arr);
		
		String str = "amanda";
		System.out.println("Is " + str + " Pallindrone ? " + isPallindrone(0, str));
		str = "madam";
		System.out.println("Is " + str + " Pallindrone ? " + isPallindrone(0, str));
		str = "malayalam";
		System.out.println("Is " + str + " Pallindrone ? " + isPallindrone(0, str));
	}
	
	public static boolean isPallindrone(int i, String str) {
		if (i > str.length() / 2) {
			return true;
		}
		if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
			return false;
		}
		return isPallindrone(i + 1, str);
	}
	
	public static void reverseArray(int i, int[] arr) {
		if (i >= arr.length / 2) {
			return;
		}
		swap(arr, i, arr.length - 1 - i);
		reverseArray(i + 1, arr);
	}
	
	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	private static void printArray(int[] arr) {
		for (int num : arr) {
			System.out.println(num);
		}
	}

}
