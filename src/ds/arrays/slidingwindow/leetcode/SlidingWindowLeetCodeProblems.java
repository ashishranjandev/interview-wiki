package ds.arrays.slidingwindow.leetcode;

public class SlidingWindowLeetCodeProblems {
    
    public static void main(String...args) {
        SlidingWindowLeetCodeProblems slidingWindowLeetCodeProblems = new SlidingWindowLeetCodeProblems();

        System.out.println("");
        //System.out.println("Does permutation of adc exists in dcda " + slidingWindowLeetCodeProblems.checkInclusion(
        //        "adc", "dcda"));
        System.out.println("Does permutation of ab exists in eidboaoo " + slidingWindowLeetCodeProblems.checkInclusion("ab", "eidboaoo"));

        // Trap Water - [0,1,0,2,1,0,1,3,2,1,2,1] - Output - 6

        // characterReplacement - "ABAB" , 2 Output - 4
    }


    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        for (int i = 0; i < s1.length() ; i++) {
            s1Map[s1.charAt(i) - 97]++;
            s2Map[s2.charAt(i) - 97]++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Map[i] == s2Map[i]) {
                matches++;
            }
        }

        System.out.println("Initial Matches - " + matches);
        if (matches == 26) {
            return true;
        }

        //adc in dcda
        for (int i = 1; i <= s2.length() - s1.length(); i++) {

            System.out.println("For new character In s1Map is " + s2.charAt(i - 1+ s1.length() ) + " is true ?");
            if(s1Map[s2.charAt(i - 1+ s1.length()) - 97 ] == 1 && s2Map[s2.charAt(i - 1+ s1.length()) - 97 ] == 0) {
                matches++;
            } else {
                matches--;
            }
            System.out.println("For leaving character - In s1Map is " + s2.charAt(i - 1) + " is true ?");
            if(s1Map[s2.charAt(i - 1) - 97] == 1 && s2Map[s2.charAt(i - 1) - 97] == 0) {
                matches--;
            } else {
                matches++;
            }
            if (matches == 26) {
                return true;
            }
            s2Map[s2.charAt(i - 1) - 97] = 0;
            s2Map[s2.charAt(i - 1 + s1.length()) - 97 ] = 1;
            System.out.println("Matches - " + matches);
        }
        return false;
    }

    private void printArray(int[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] >=  1) {
                System.out.print((char) (i + 97));
                System.out.print("(" + arr[i] + ")");
            } else {
                System.out.print(arr[i]);
            }
            System.out.print(",");
        }
        System.out.println();
    }

    /**
     * Rainwater trapped at every level = min of (max of left till now - max of right till now) - height[i]
     *
     * Create 2 arrays and
     * keep the info of max of left till index i
     * keep the info of max of right till index i
     *
     * Create an array now to
     *
     *
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int sum = 0;
        int[] maxLeftArr = new int[height.length];
        int[] maxRightArr = new int[height.length];

        int maxLeft = 0;
        int maxRight = 0;
        for (int i = 0; i < height.length; i++) {
            maxLeftArr[i] = maxLeft = Math.max(maxLeft, height[i]);
        }

        for (int i = height.length - 1; i >= 0; i--) {
            maxRightArr[i] = maxRight = Math.max(maxRight, height[i]);
        }

        for (int i = 0; i < height.length; i++) {
            int capacity = Math.min(maxLeftArr[i], maxRightArr[i]) - height[i];
            if (capacity > 0) {
                sum += capacity;
            }
        }

        return sum;
    }

    /**
     * Create a dictionay of all uppercase characters for keeping track of majority characters in substring
     *
     * Implement two pointers starting at left and calculate the number of characters to be replaced
     *  No. of CharactersTo Be Replaced = Size of Substring(i.e. right - left + 1) - max of any element of dictionary
     *  if  No. Of Characters to be Replaced > input k
     *      increment left (reduce the substring) -> Update the Dictionary
     *  else
     *      Replace the maxSubStringSize with current Size (if greater)
     *      increment right (increase the substring) -> Update the dictionary
     *
     * return maxSubsetSize
     *
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        int left = 1;
        int right = 1;
        int maxSubsetSize = 0;
        int occurence[] = new int[26];

        occurence[s.charAt(0) - 65]++;

        while(right < s.length()) {
            int sizeOfWindow = right - left + 1;
            int maxOccurence = getMaxOccurence(occurence);
            maxSubsetSize = (maxSubsetSize > sizeOfWindow) ? maxSubsetSize : sizeOfWindow;
            if (sizeOfWindow - maxOccurence <= k) {
                right++;
                if (right <= s.length() - 1) {
                    occurence[s.charAt(right) - 65]++;
                }
            } else {
                occurence[s.charAt(left) - 65]--;
                left++;
            }
        }
        return maxSubsetSize;
    }

    private int getMaxOccurence(int[] occurence) {
        int max = 0;
        for (int i = 0; i < occurence.length; i++) {
            max = (occurence[i] > max) ? occurence[i] : max;
        }
        return max;
    }
}
