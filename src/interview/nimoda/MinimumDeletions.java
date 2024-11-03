package interview.nimoda;

public class MinimumDeletions {

    public static void main(String[] args) {
        String s1 = "abbbbcdb";
        int expectedOutput1 = 2;
        int actualOutput1 = minDeletions(s1);
        System.out.println("Test Case 1");
        System.out.println("Expected Output: " + expectedOutput1);
        System.out.println("Actual Output: " + actualOutput1);
        System.out.println();

        String s2 = "aabbcc";
        int expectedOutput2 = 3;
        int actualOutput2 = minDeletions(s2);
        System.out.println("Test Case 2");
        System.out.println("Expected Output: " + expectedOutput2);
        System.out.println("Actual Output: " + actualOutput2);
        System.out.println();

        String s3 = "abcde";
        int expectedOutput3 = 0;
        int actualOutput3 = minDeletions(s3);
        System.out.println("Test Case 3");
        System.out.println("Expected Output: " + expectedOutput3);
        System.out.println("Actual Output: " + actualOutput3);
        System.out.println();
    }

    /**
     * Finds the minimum number of deletions required to ensure no two adjacent characters in the string are the same.
     *
     * @param s the input string
     * @return the minimum number of deletions required
     */
    public static int minDeletions(String s) {
        int deletions = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                deletions++;
            }
        }
        return deletions;
    }
}

