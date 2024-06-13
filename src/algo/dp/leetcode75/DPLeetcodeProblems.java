package algo.dp.leetcode75;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DPLeetcodeProblems {
    public static void main(String[] args) {
        DPLeetcodeProblems dpLeetcodeProblems = new DPLeetcodeProblems();
        System.out.println();
        System.out.println("Finding Longest Pallindromic Substring");
        System.out.println("Input is \"babad\"");
        System.out.println("Expected output is \"bab\"");
        System.out.println(dpLeetcodeProblems.longestPalindrome("bab"));

        System.out.println();
        System.out.println("Finding Longest Pallindromic Substring");
        System.out.println("Input is \"cbbd\"");
        System.out.println("Expected output is \"bb\"");
        System.out.println(dpLeetcodeProblems.longestPalindrome("cbbd"));

        System.out.println();
        System.out.println("Finding Longest Pallindromic Substring");
        System.out.println("Input is \"cbbd\"");
        System.out.println("Expected output is \"bb\"");
        System.out.println(dpLeetcodeProblems.longestPalindrome("cbbd"));

        System.out.println();
        System.out.println("Number of palindromic substrings");
        System.out.println("Input is \"abc\"");
        System.out.println("Expected output is \"a\", \"b\", \"c\"");
        System.out.println(dpLeetcodeProblems.countSubstrings("abc"));

        System.out.println();
        System.out.println("Number of palindromic substrings");
        System.out.println("Input is \"aaa\"");
        System.out.println("Expected output is \"a\", \"a\", \"a\", \"aa\", \"aa\", \"aaa\"");
        System.out.println(dpLeetcodeProblems.countSubstrings("aaa"));

        int[] coins = {1,2,5};
        System.out.println();
        System.out.println("Finding fewest number of coins that you need to make up that amount");
        System.out.println("Input is [1,2,5] and target = 11");
        System.out.println("Expected output is \"3\"");
        System.out.println(dpLeetcodeProblems.coinChange(coins, 11));

        coins = new int[]{2};
        System.out.println();
        System.out.println("Finding fewest number of coins that you need to make up that amount");
        System.out.println("Input is [2] and target = 3");
        System.out.println("Expected output is \"-1\"");
        System.out.println(dpLeetcodeProblems.coinChange(coins, 3));

        coins = new int[]{1};
        System.out.println();
        System.out.println("Finding fewest number of coins that you need to make up that amount");
        System.out.println("Input is [1] and target = 0");
        System.out.println("Expected output is \"0\"");
        System.out.println(dpLeetcodeProblems.coinChange(coins, 0));

        coins = new int[]{1};
        System.out.println();
        System.out.println("Finding fewest number of coins that you need to make up that amount");
        System.out.println("Input is [1] and target = 2");
        System.out.println("Expected output is \"2\"");
        System.out.println(dpLeetcodeProblems.coinChange(coins, 2));

        int[] nums = new int[]{2, 3, -2, 4};
        System.out.println();
        System.out.println("Finding Maximum Product Subarray\n");
        System.out.println("Input is [2,3,-2,4]");
        System.out.println("Expected output is \"6\"");
        System.out.println(dpLeetcodeProblems.maxProduct(nums));

        nums = new int[]{-2,0,-1};
        System.out.println();
        System.out.println("Finding Maximum Product Subarray\n");
        System.out.println("Input is [-2,0,-1]");
        System.out.println("Expected output is \"0\"");
        System.out.println(dpLeetcodeProblems.maxProduct(nums));

        nums = new int[]{2,-5,-2,-4,3};
        System.out.println();
        System.out.println("Finding Maximum Product Subarray\n");
        System.out.println("Input is [2,-5,-2,-4,3]");
        System.out.println("Expected output is \"24\"");
        System.out.println(dpLeetcodeProblems.maxProduct(nums));

        String s = "leetcode";
        List<String> wordDictionary = Arrays.asList("leet", "code");
        System.out.println();
        System.out.println("Word Break\n");
        System.out.println("Input string is \"leetcode\" word dictionary is [\"leet\", \"code\"] ");
        System.out.println("Expected output is \"true\"");
        System.out.println(dpLeetcodeProblems.wordBreak(s, wordDictionary));

        s = "applepenapple";
        wordDictionary = Arrays.asList("apple","pen");
        System.out.println();
        System.out.println("Word Break\n");
        System.out.println("Input string is \"applepenapple\" word dictionary is [\"apple\",\"pen\"] ");
        System.out.println("Expected output is \"true\"");
        System.out.println(dpLeetcodeProblems.wordBreak(s, wordDictionary));

        s = "catsandog";
        wordDictionary = Arrays.asList("cats","dog","sand","and","cat");
        System.out.println();
        System.out.println("Word Break\n");
        System.out.println("Input string is \"catsandog\" word dictionary is [\"cats\",\"dog\",\"sand\",\"and\",\"cat\"] ");
        System.out.println("Expected output is \"false\"");
        System.out.println(dpLeetcodeProblems.wordBreak(s, wordDictionary));

        s = "cars";
        wordDictionary = Arrays.asList("car","ca","rs");
        System.out.println();
        System.out.println("Word Break\n");
        System.out.println("Input string is \"cars\" word dictionary is [\"car\",\"ca\",\"rs\"] ");
        System.out.println("Expected output is \"true\"");
        System.out.println(dpLeetcodeProblems.wordBreak(s, wordDictionary));

        nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println();
        System.out.println("Longest Increasing Subsequence\n\n");
        System.out.println("Input is [10,9,2,5,3,7,101,18] ");
        System.out.println("Expected output is 4. The longest increasing subsequence is [2,3,7,101]");
        System.out.println(dpLeetcodeProblems.lengthOfLIS(nums));

        nums = new int[]{1,5,11,5};
        System.out.println();
        System.out.println("Partition equal subset sum\n\n");
        System.out.println("Input is [1,5,11,5] ");
        System.out.println("Expected output is true. The array can be partitioned as [1, 5, 5] and [11]");
        System.out.println(dpLeetcodeProblems.canPartition(nums));

        nums = new int[]{1,2,5};
        System.out.println();
        System.out.println("Partition equal subset sum\n\n");
        System.out.println("Input is [1,2,5] ");
        System.out.println("Expected output is false.");
        System.out.println(dpLeetcodeProblems.canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }

        Set<Integer> possibleSums = new HashSet<>();
        possibleSums.add(0);

        for (int i = nums.length - 1; i >= 0; i--) {
            Set<Integer> setForItem = new HashSet<>();
            for (Integer possibleSum : possibleSums) {
                setForItem.add(possibleSum + nums[i]);
            }
            possibleSums.addAll(setForItem);
        }

        return possibleSums.contains(sum / 2);
    }

    public int lengthOfLIS(int[] nums) {
        int answer = 1;
        int[] lengthOfSubsequence = new int[nums.length];
        lengthOfSubsequence[nums.length - 1] = 1;
        for (int i = nums.length -2; i >=0; i--) {
            lengthOfSubsequence[i] = 1;
            for (int k = i + 1; k < nums.length; k++) {
                if (nums[i] < nums[k]) {
                    lengthOfSubsequence[i] = Math.max(lengthOfSubsequence[i], 1 + lengthOfSubsequence[k]);
                }
            }
            answer = Math.max(lengthOfSubsequence[i], answer);
        }

        return answer;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dpArray = new boolean[s.length() + 1];
        dpArray[s.length()] = true;

        for (int i = s.length() - 1; i >=0; i--) {
            for (String word : wordDict) {
                //System.out.println("Evaluating starting from " + s.charAt(i) + " and word " + word + " array is " +
                // getArrayAsString(dpArray));
                if (s.length() >= i + word.length() && s.substring(i, i + word.length()).equals(word)) {
                    dpArray[i] = dpArray[i + word.length()];
                    if (dpArray[i]) {
                        break;
                    }
                }
            }
        }
        return dpArray[0];
    }

    private String getArrayAsString(boolean[] flags) {
        StringBuilder stringBuilder = new StringBuilder();
        for (boolean flag : flags) {
            stringBuilder.append(flag);
            stringBuilder.append(",");
        }
        return stringBuilder.toString();
    }

    private String getArrayAsString(int[] flags) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int flag : flags) {
            stringBuilder.append(flag);
            stringBuilder.append(",");
        }
        return stringBuilder.toString();
    }

    public int maxProduct(int[] nums) {
        int answer = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > answer) {
                answer = num;
            }
        }
        int currentMax = 1;
        int currentMin = 1;

        for (int num : nums) {
            if (num == 0) {
                currentMax = 1;
                currentMin = 1;
            }
            int tempMax = currentMax;
            currentMax = Math.max(num * currentMax, Math.max(num * currentMin, num));
            currentMin = Math.min(num * tempMax, Math.min(num * currentMin, num));
            if (currentMax > answer) {
                answer = currentMax;
            }
        }

        return answer;
    }

    public int coinChange(int[] coins, int amount) {
        int[] solutionArray = new int[amount + 1];
        solutionArray[0] = 0;
        int defaultValue = amount + 1;

        for (int targetIndex = 1; targetIndex < amount + 1; targetIndex++) {
            int minForTarget = defaultValue;
            for (int coinIndex = 0; coinIndex< coins.length; coinIndex++) {
                if (coins[coinIndex] <= targetIndex) {
                    int coinUsingcoinAtCoinIndex = 1 + solutionArray[targetIndex - coins[coinIndex]];
                    if (coinUsingcoinAtCoinIndex < minForTarget) {
                        minForTarget = coinUsingcoinAtCoinIndex;
                    }
                }
            }
            solutionArray[targetIndex] = minForTarget;
        }
        return (solutionArray[amount] != defaultValue) ? solutionArray[amount] : -1;
    }

    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += getCountOfSubstringsAtPosition(i, i, s);
            if (i != s.length() - 1) {
                count += getCountOfSubstringsAtPosition(i, i + 1, s);
            }
        }
        return count;
    }

    private int getCountOfSubstringsAtPosition(int left, int right, String s) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }

    public String longestPalindrome(String s) {
        String[] result = new String[1];
        int[] longestPallindroneLength = new int[1];

        for (int i = 0; i < s.length(); i++) {
            getLongestPallindrome(s, longestPallindroneLength, i, i, result);
        }

        for (int i = 0; i < s.length(); i++) {
            getLongestPallindrome(s, longestPallindroneLength, i, i + 1, result);
        }

        return result[0];
    }

    public void getLongestPallindrome(String s, int[] longestPallindroneLength, int left, int right, String[] result) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if ((right - left + 1) > longestPallindroneLength[0]) {
                longestPallindroneLength[0] = right - left + 1;
                result[0] = s.substring(left, right + 1);
            }
            left--;
            right++;
        }
    }

}
