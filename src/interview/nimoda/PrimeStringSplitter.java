package interview.nimoda;

public class PrimeStringSplitter {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        // Test Case 1
        String s1 = "11375";
        int expectedOutput1 = 3;
        int actualOutput1 = countPrimeStrings(s1);
        System.out.println("Test Case 1");
        System.out.println("Expected Output: " + expectedOutput1);
        System.out.println("Actual Output: " + actualOutput1);
        System.out.println();

        // Test Case 2
        String s2 = "3175";
        int expectedOutput2 = 1;
        int actualOutput2 = countPrimeStrings(s2);
        System.out.println("Test Case 2");
        System.out.println("Expected Output: " + expectedOutput2);
        System.out.println("Actual Output: " + actualOutput2);
        System.out.println();

        // Test Case 3
        String s3 = "2337";
        int expectedOutput3 = 2;
        int actualOutput3 = countPrimeStrings(s3);
        System.out.println("Test Case 3");
        System.out.println("Expected Output: " + expectedOutput3);
        System.out.println("Actual Output: " + actualOutput3);
        System.out.println();
    }

    /**
     * Counts the number of ways the given string can be split into prime numbers.
     *
     * @param s the input string of digits
     * @return the number of ways to split the string into prime numbers, modulo 1000000007
     */
    public static int countPrimeStrings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                String substring = s.substring(j, i);
                if (isPrime(substring)) {
                    dp[i] = (dp[i] + dp[j]) % MOD;
                }
            }
        }

        return dp[n];
    }

    /**
     * Checks if the given string represents a prime number.
     *
     * @param s the string to check
     * @return true if the string represents a prime number, otherwise false
     */
    private static boolean isPrime(String s) {
        if (s.length() > 6 || s.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(s);
        if (num < 2) {
            return false;
        }
        if (num == 2 || num == 3) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}

