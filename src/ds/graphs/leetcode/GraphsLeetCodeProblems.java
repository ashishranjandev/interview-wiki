package ds.graphs.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class GraphsLeetCodeProblems {

    public static void main(String...args) {
        GraphsLeetCodeProblems graphsLeetCodeProblems = new GraphsLeetCodeProblems();

        System.out.println();
        char[][] charGrid = new char[][]
                {{'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}};
        System.out.println("Input is ");
        System.out.println("{1, 1, 1, 1, 0}");
        System.out.println("{1, 1, 0, 1, 0}");
        System.out.println("{1, 1, 0, 0, 0}");
        System.out.println("{0, 1, 0, 0, 0}");
        System.out.println("Expected output is 1");
        System.out.println("Actual output is " + graphsLeetCodeProblems.numIslands(charGrid));

        System.out.println();
        charGrid = new char[][]
                {{'1', '1', '0', '0', '0'},
                 {'1', '1', '0', '0', '0'},
                 {'0', '0', '1', '0', '0'},
                 {'0', '0', '0', '1', '1'}};
        System.out.println("Input is ");
        System.out.println("{1, 1, 0, 0, 0}");
        System.out.println("{1, 1, 0, 0, 0}");
        System.out.println("{0, 0, 1, 0, 0}");
        System.out.println("{0, 0, 0, 1, 1}");
        System.out.println("Expected output is 3");
        System.out.println("Actual output is " + graphsLeetCodeProblems.numIslands(charGrid));

        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1,0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0,0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println();
        System.out.println("Input is ");
        System.out.println("{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}");
        System.out.println("{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}");
        System.out.println("{0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}");
        System.out.println("{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}");
        System.out.println("{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}");
        System.out.println("{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}");
        System.out.println("{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}");
        System.out.println("{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}");
        System.out.println("Expected output is 6");
        System.out.println("Actual output is " + graphsLeetCodeProblems.maxAreaOfIsland(grid));


        grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println();
        System.out.println("Input is ");
        System.out.println("{2, 1, 1}");
        System.out.println("{1, 1, 0}");
        System.out.println("{0, 1, 1}");
        System.out.println("Expected output is 4");
        System.out.println("Actual output is " + graphsLeetCodeProblems.orangesRotting(grid));

        System.out.println();
        charGrid = new char[][]
                {{'X','X','X','X'},
                 {'X','O','O','X'},
                 {'X','X','O','X'},
                 {'X','O','X','X'}};
        System.out.println("Input is ");
        System.out.println("{'X','X','X','X'}");
        System.out.println("{'X','O','O','X'}");
        System.out.println("{'X','X','O','X'}");
        System.out.println("{'X','O','X','X'}");
        System.out.println("Expected output is ");
        System.out.println("{'X','X','X','X'}");
        System.out.println("{'X','X','X','X'}");
        System.out.println("{'X','X','X','X'}");
        System.out.println("{'X','O','X','X'}");
        System.out.println("Actual output is ");
        graphsLeetCodeProblems.solve(charGrid);
        System.out.println(charGrid);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> answer = new ArrayList<>();
        return answer;
    }

    /**
     * We have to use BFS with multi-source queue <br/>
     * The rotten oranges would become the sources and <br/>
     * every iteration would become the time elapsed
     *
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        int time = 0;
        int freshOranges = 0;
        Queue<Node> queue = new LinkedList<>();

        int totalRows = grid.length;
        int totalCols = grid[0].length;

        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                if (grid[row][col] == 1) {
                    freshOranges++;
                }
                if (grid[row][col] == 2) {
                    queue.add(new Node(row, col));
                }
            }
        }

        List<Node> directions = new ArrayList<>(4);
        directions.add(new Node(1,0));
        directions.add(new Node(-1,0));
        directions.add(new Node(0,1));
        directions.add(new Node(0,-1));

        while (!queue.isEmpty() && freshOranges > 0) {
            int size = queue.size();
            for (int index = 0; index < size; index++) {
                Node currentIndex = queue.poll();
                for (Node direction : directions) {
                    int newRow = currentIndex.row + direction.row;
                    int newCol = currentIndex.col + direction.col;
                    if (newRow >= 0 && newRow < totalRows && newCol >= 0 && newCol < totalCols &&
                            grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.add(new Node(newRow, newCol));
                        freshOranges--;
                    }
                }
            }
            time++;
        }

        return (freshOranges == 0) ? time : -1;
    }

    private static String TEMP_STRING = "T";

    /**
     * 1. (DFS) Capture unsurrounded regions (O -> T)
     * 2. Capture surrounded regions (O -> X)
     * 3. Uncapture unsurrounded regions (T -> O)
     *
     * @param board
     */
    public void solve(char[][] board) {
        int totalRows = board.length;
        int totalCols = board[0].length;

        // 1. (DFS) Capture unsurrounded regions (O -> T)
        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                if (board[row][col] == 'O' && (row == 0 || row == totalRows - 1 || col == 0 || col == totalCols - 1)) {
                    dfsToSolveGrid(row, col, board);
                }
            }
        }

        // 2. Capture surrounded regions (O -> X)
        // 3. Uncapture unsurrounded regions (T -> O)
        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
                if (board[row][col] == 'T') {
                    board[row][col] = 'O';
                }
            }
        }
    }

    private void dfsToSolveGrid(int row, int col, char[][] board) {
        if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1 || board[row][col] != 'O') {
            return;
        }
        board[row][col] = 'T';
        dfsToSolveGrid(row + 1, col, board);
        dfsToSolveGrid(row - 1, col, board);
        dfsToSolveGrid(row, col + 1, board);
        dfsToSolveGrid(row, col - 1, board);
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        Set<Node> visitedNodes = new HashSet<>();
        int totalRows = grid.length;
        int totalColumns = grid[0].length;
        int maxAreaOfIslands = 0;

        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalColumns; col++) {
                if (grid[row][col] == 1) {
                    int sizeOfIsland = dfsForMaxAreaOfIsland(row, col, grid, visitedNodes);
                    maxAreaOfIslands = Math.max(sizeOfIsland, maxAreaOfIslands);
                }
            }
        }

        return maxAreaOfIslands;
    }

    public int dfsForMaxAreaOfIsland(int row, int col, int[][] grid, Set<Node> visitedNodes) {
        if (row < 0 ||
                row == grid.length ||
                col < 0 ||
                col == grid[0].length ||
                grid[row][col] == 0 ||
                visitedNodes.contains(new Node(row,col))) {
            return 0;
        }

        visitedNodes.add(new Node(row, col));
        return 1 + dfsForMaxAreaOfIsland(row + 1, col, grid, visitedNodes) +
                dfsForMaxAreaOfIsland(row - 1, col, grid, visitedNodes) +
                dfsForMaxAreaOfIsland(row, col + 1, grid, visitedNodes) +
                dfsForMaxAreaOfIsland(row, col - 1, grid, visitedNodes);
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        Set<Node> visitedNodes = new HashSet<>();
        int totalRows = grid.length;
        int totalColumns = grid[0].length;
        int numberOfIslands = 0;

        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalColumns; col++) {
                if (grid[row][col] == '1' && !visitedNodes.contains(new Node(row,col))) {
                    numberOfIslands++;
                    bfsForNumOfIslands(row, col, grid, visitedNodes);
                }
            }
        }

        return numberOfIslands;
    }

    public void bfsForNumOfIslands(int row, int col, char[][] grid, Set<Node> visitedNodes) {
        Queue<Node> nodeQueue = new LinkedList<>();
        visitedNodes.add(new Node(row, col));
        nodeQueue.add(new Node(row, col));

        List<Node> directions = new ArrayList<>(4);
        directions.add(new Node(1,0));
        directions.add(new Node(-1,0));
        directions.add(new Node(0,1));
        directions.add(new Node(0,-1));

        while (!nodeQueue.isEmpty()) {
            Node currentNode = nodeQueue.poll();
            for (Node direction : directions) {
                Node nextNode = new Node(currentNode.row + direction.row, currentNode.col + direction.col);
                if (nextNode.row >= 0 && nextNode.row < grid.length &&
                        nextNode.col >= 0 && nextNode.col < grid[0].length &&
                            grid[nextNode.row][nextNode.col] == '1' &&
                                !visitedNodes.contains(nextNode)) {
                    bfsForNumOfIslands(nextNode.row, nextNode.col, grid, visitedNodes);
                }
            }
        }
    }

    static class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return row == node.row && col == node.col;
        }

        @Override public int hashCode() {
            return Objects.hash(row, col);
        }

        @Override public String toString() {
            return "Node{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }
}
