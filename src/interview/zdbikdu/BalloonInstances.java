package interview.zdbikdu;

import java.util.HashMap;
import java.util.Map;

public class BalloonInstances {

    public static int maxNumberOfBalloons(String text) {
        // Create a map to store the frequency of each character in the text
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : text.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Calculate the number of instances of "balloon" that can be formed
        int bCount = charCount.getOrDefault('b', 0);
        int aCount = charCount.getOrDefault('a', 0);
        int lCount = charCount.getOrDefault('l', 0) / 2; // 'l' appears twice in "balloon"
        int oCount = charCount.getOrDefault('o', 0) / 2; // 'o' appears twice in "balloon"
        int nCount = charCount.getOrDefault('n', 0);

        // Return the minimum of these counts, which determines the max instances of "balloon"
        return Math.min(Math.min(Math.min(bCount, aCount), lCount), Math.min(oCount, nCount));
    }

    public static void main(String[] args) {
        // Test cases
        String text1 = "nlaebolko";
        String text2 = "loonbalxballpoon";
        String text3 = "leetcode";

        System.out.println(maxNumberOfBalloons(text1)); // Output: 1
        System.out.println(maxNumberOfBalloons(text2)); // Output: 2
        System.out.println(maxNumberOfBalloons(text3)); // Output: 0
    }
}
