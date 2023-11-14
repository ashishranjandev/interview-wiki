package interview.zdbikdu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WInterview {

    public static void main(String...args) {

        List<String> words = new ArrayList<>();
        words.add("dule");
        words.add("duel");
        words.add("speed");
        words.add("cars");

        List<String> queries = new ArrayList<>();
        queries.add("spede");
        queries.add("duel");
        System.out.println(getSearchResults(words, queries));

        words.clear();
        queries.clear();
        words.add("allot");
        words.add("cat");
        words.add("peach");
        words.add("dusty");
        words.add("act");
        words.add("cheap");

        queries.add("tac");
        queries.add("study");
        queries.add("peache");
        System.out.println(getSearchResults(words, queries));

    }

    public static List<List<String>> getSearchResults(List<String> words, List<String> queries) {
        // Write your code here
        List<List<String>> answer = new ArrayList<>();
        Map<String, int[]> wordLettersMap = new HashMap<>();
        for (String word : words) {
            wordLettersMap.put(word, getWordArray(word));
        }
        for (String query : queries) {
            answer.add(getSearchResults(wordLettersMap, query));
        }
        return answer;
    }

    public static List<String> getSearchResults(Map<String, int[]> wordLettersMap, String query) {
        // Write your code here
        List<String> answer = new ArrayList<>();
        for (Map.Entry<String, int[]> wordLettersMapEntry : wordLettersMap.entrySet()) {
            if (isWordArraySame(wordLettersMapEntry.getValue(), getWordArray(query))) {
                answer.add(wordLettersMapEntry.getKey());
            }
        }
        return answer;
    }

    public static int[] getWordArray(String word) {
        int[] wordArray = new int[128];
        for (char ch : word.toCharArray()) {
            wordArray[ch] = 1;
        }
        return wordArray;
    }

    public static boolean isWordArraySame(int[] wordArray1, int[] wordArray2) {
        for (int i = 0; i < wordArray1.length; i++) {
            if (wordArray1[i] != wordArray2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int minMovesToReach(List<List<Integer>> maze, int k) {
        int n = maze.size();
        int m = maze.get(0).size();

        if (maze.get(0).get(0) == 1 || maze.get(n - 1).get(m - 1) == 1) {
            return -1; // Impossible to reach
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0}); // {x, y, moves}
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int moves = current[2];

            if (x == n - 1 && y == m - 1) {
                return moves;
            }

            for (int[] dir : directions) {
                for (int i = 1; i <= k; i++) {
                    int newX = x + dir[0] * i;
                    int newY = y + dir[1] * i;

                    if (newX >= 0 && newX < n && newY >= 0 && newY < m && maze.get(newX).get(newY) == 0 && !visited[newX][newY]) {
                        queue.add(new int[]{newX, newY, moves + 1});
                        visited[newX][newY] = true;
                    }
                }
            }
        }

        return -1; // Cannot reach (n-1, m-1)
    }

    public static void fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
