package algo.recursion;

public class RecursionTasks1 {

	/**
	 * Print name 5 times
	 * Print linearly from 1 to N
	 * Print from N to 1
	 * Print from 1 to N using Backtracking
	 * Print from N to 1 using Backtracking
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("print name 5 times");
		printNameNTimes(5);
		System.out.println("print linearly from 1 to N");
		printFrom1toN(1, 5);
		System.out.println("print from N to 1");
		printFromNto1(5);
		System.out.println("print from 1 to N using Backtracking");
		printFrom1toNUsingBacktracking(5);
		System.out.println("print from N to 1 using Backtracking");
		printFromNto1UsingBacktracking(1, 5);
	}
	
	public static void printNameNTimes(int n) {
		// Base condition
		if (n  == 0) {
			return;
		}
		System.out.println("Ashish");
		// As Recursive call is made after the print 
		// the first function call will print first
		printNameNTimes(n - 1);
	}
	
	public static void printFrom1toN(int counter, int n) {
		// Base condition
		if (counter > n) {
			return;
		}
		System.out.println(counter);
		// As Recursive call is made after the print 
		// the first function call will print first
		printFrom1toN(counter + 1, n);
	}
	
	public static void printFromNto1(int n) {
		// Base condition
		if (n == 0) {
			return;
		}
		System.out.println(n);
		// As Recursive call is made after the print 
		// the first function call will print first
		printFromNto1(n - 1);
	}
	
	public static void printFrom1toNUsingBacktracking(int n) {
		if (n == 0) {
			return;
		}
		printFrom1toNUsingBacktracking(n - 1);
		System.out.println(n);
	}
	
	public static void printFromNto1UsingBacktracking(int counter, int n) {
		if (counter > n) {
			return;
		}
		printFromNto1UsingBacktracking(counter + 1, n);
		System.out.println(counter);
	}
}
