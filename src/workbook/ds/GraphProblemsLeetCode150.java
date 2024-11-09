package workbook.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphProblemsLeetCode150 {
    public static void main(String[] args) {
        // Problem 1: Number of Islands
        char[][] grid1 = {
                {'0', '1', '1', '1', '0'},
                {'0', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println("Number of Islands: " + numIslands(grid1)); // Output: 1

        char[][] grid2 = {
                {'1', '1', '0', '0', '1'},
                {'1', '1', '0', '0', '1'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println("Number of Islands: " + numIslands(grid2)); // Output: 4

        // Problem 2: Maximum Area of Island
        int[][] grid3 = {
                {0, 1, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {0, 1, 1, 0, 1},
                {0, 1, 0, 0, 1}
        };
        System.out.println("Maximum Area of Island: " + maxAreaOfIsland(grid3)); // Output: 6

        // Problem 3: Clone Graph
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        Node clonedGraph = cloneGraph(node1);
        System.out.println("Cloned Graph: " + clonedGraph);

        // Problem 4: Walls and Gates
        int[][] rooms = {
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}
        };
        wallsAndGates(rooms);
        System.out.println("Rooms after wallsAndGates: " + Arrays.deepToString(rooms));

        // Problem 5: Rotten Oranges
        int[][] grid4 = {{1,1,0},{0,1,1},{0,1,2}};
        System.out.println("Minimum time to rot all oranges: " + orangesRotting(grid4)); // Output: 4

        // Problem 6: Pacific Atlantic Water Flow
        int[][] heights = {
                {4, 2, 7, 3, 4},
                {7, 4, 6, 4, 7},
                {6, 3, 5, 3, 6}
        };
        System.out.println("Pacific Atlantic Water Flow: " + pacificAtlantic(heights));

        // Problem 7: Surrounded Regions
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'X', 'O'}
        };
        solve(board);
        System.out.println("Board after solving: " + Arrays.deepToString(board));

        // Problem 8: Course Schedule
        int numCourses1 = 2;
        int[][] prerequisites1 = {{0, 1}};
        System.out.println("Can finish all courses: " + canFinish(numCourses1, prerequisites1)); // Output: true

        // Problem 9: Course Schedule II
        int numCourses2 = 3;
        int[][] prerequisites2 = {{1, 0}};
        System.out.println("Course order: " + Arrays.toString(findOrder(numCourses2, prerequisites2))); // Output: [0, 1, 2]

        // Problem 10: Graph Valid Tree
        int n1 = 5;
        int[][] edges1 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println("Is valid tree: " + validTree(n1, edges1)); // Output: true

        // Problem 11: Redundant Connection
        int[][] edges2 = {{1, 2}, {1, 3}, {3, 4}, {2, 4}};
        System.out.println("Redundant edge: " + Arrays.toString(findRedundantConnection(edges2))); // Output: [2, 4]
    }

    // Implementations of the methods for the above problems go here...

    // Example: numIslands
    public static int numIslands(char[][] grid) {
        // Implementation here...
        return -1;
    }

    // Example: maxAreaOfIsland
    public static int maxAreaOfIsland(int[][] grid) {
        // Implementation here...
        return -1;
    }

    // Example: cloneGraph
    public static Node cloneGraph(Node node) {
        // Implementation here...
        return null;
    }

    // Example: wallsAndGates
    public static void wallsAndGates(int[][] rooms) {
        // Implementation here...
    }

    // Example: orangesRotting
    public static int orangesRotting(int[][] grid) {
        // Implementation here...
        return -1;
    }

    // Example: pacificAtlantic
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        // Implementation here...
        return null;
    }

    // Example: solve
    public static void solve(char[][] board) {
        // Implementation here...
    }

    // Example: canFinish
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // Implementation here...
        return false;
    }

    // Example: findOrder
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        return new int[1];
    }

    // Example: validTree
    public static boolean validTree(int n, int[][] edges) {
        // Implementation here...
        return false;
    }

    // Example: findRedundantConnection
    public static int[] findRedundantConnection(int[][] edges) {
        // Implementation here...
        return new int[1];
    }


    // Helper class for Problem 3: Clone Graph
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

}
