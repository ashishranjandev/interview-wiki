package ds.graphs.leetcode;

import java.util.HashSet;
import java.util.Set;

public class AdvancedGraphLeetCodeProblems {

    public static void main(String...args) {
        AdvancedGraphLeetCodeProblems advancedGraphLeetCodeProblems = new AdvancedGraphLeetCodeProblems();

        int[][] grid = new int[][]{{0, 2}, {1, 3}};
        System.out.println();
        System.out.println("Input is ");
        System.out.println("{0, 2}");
        System.out.println("{1, 3}");
        System.out.println("Expected output is 4");
        System.out.println("Actual output is " + advancedGraphLeetCodeProblems.swimInWater(grid));
    }

    public int swimInWater(int[][] grid) {
        int lengthOfGrid = grid.length;
        Set<Coordinate> visited = new HashSet<>();
        return 0;
    }

    class Coordinate {
        int row;
        int col;

        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
