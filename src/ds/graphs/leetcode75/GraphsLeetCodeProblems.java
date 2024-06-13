package ds.graphs.leetcode75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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

        grid = new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println();
        System.out.println("Input is ");
        System.out.println("{1,2,2,3,5}");
        System.out.println("{3,2,3,4,4}");
        System.out.println("{2,4,5,3,1}");
        System.out.println("{6,7,1,4,5}");
        System.out.println("{5,1,1,2,4}");
        System.out.println("Expected output is {{0,4},{1,3},{1,4},{2,2},{3,0},{3,1},{4,0}}");
        System.out.println("Actual output is " + graphsLeetCodeProblems.pacificAtlantic(grid));

        int numberOfCourses = 2;
        int[][] prerequisites = new int[][]{{1, 0}};
        System.out.println();
        System.out.println("Input is ");
        System.out.println("number of courses - 2");
        System.out.println("Prerequisites are ");
        System.out.println("{1, 0}");
        System.out.println("Expected output is true");
        System.out.println("Actual output is " + graphsLeetCodeProblems.canFinish(numberOfCourses, prerequisites));

        numberOfCourses = 2;
        prerequisites = new int[][]{{1, 0}};
        System.out.println();
        System.out.println("Input is ");
        System.out.println("number of courses - 2");
        System.out.println("Prerequisites are ");
        System.out.println("{1, 0}");
        System.out.println("Expected output is [0, 1]");
        System.out.println("Actual output is " + Arrays.toString(graphsLeetCodeProblems.findOrder(numberOfCourses,
                                                                                                prerequisites)));

        numberOfCourses = 4;
        prerequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        System.out.println();
        System.out.println("Input is ");
        System.out.println("number of courses - 4");
        System.out.println("Prerequisites are ");
        System.out.println("{1, 0}");
        System.out.println("{2, 0}");
        System.out.println("{3, 1}");
        System.out.println("{3, 2}");
        System.out.println("Expected output is [0, 1, 2, 3]");
        System.out.println("Actual output is " + Arrays.toString(graphsLeetCodeProblems.findOrder(numberOfCourses,
                                                                                                prerequisites)));

        numberOfCourses = 1;
        prerequisites = new int[][]{};
        System.out.println();
        System.out.println("Input is ");
        System.out.println("number of courses - 1");
        System.out.println("Prerequisites are []");
        System.out.println("Expected output is [0]");
        System.out.println("Actual output is " + Arrays.toString(graphsLeetCodeProblems.findOrder(numberOfCourses,
                                                                                                prerequisites)));

        int[][] edges = new int[][]{{1,2},{1,3},{2,3}};
        System.out.println();
        System.out.println("Input is ");
        System.out.println("Edges are ");
        System.out.println("Edges are {1, 2}");
        System.out.println("Edges are {1, 3}");
        System.out.println("Edges are {2, 3}");
        System.out.println("Expected output is {2, 3}");
        System.out.println("Actual output is " + Arrays.toString(graphsLeetCodeProblems.findRedundantConnection(edges)));

        edges = new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}};
        System.out.println();
        System.out.println("Input is ");
        System.out.println("Edges are ");
        System.out.println("Edges are {1, 2}");
        System.out.println("Edges are {2, 3}");
        System.out.println("Edges are {3, 4}");
        System.out.println("Edges are {1, 4}");
        System.out.println("Edges are {1, 5}");
        System.out.println("Expected output is {1, 4}");
        System.out.println("Actual output is " + Arrays.toString(graphsLeetCodeProblems.findRedundantConnection(edges)));

        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        System.out.println();
        System.out.println("Input is 1, 2, 3, 4");
        System.out.println("Edges are ");
        System.out.println("Edges are {1, 2}");
        System.out.println("Edges are {2, 3}");
        System.out.println("Edges are {3, 4}");
        System.out.println("Edges are {1, 4}");
        GraphNode cloneGraph = graphsLeetCodeProblems.cloneGraph(node1);
        System.out.println(cloneGraph.val);
        System.out.println(cloneGraph.neighbors);

        System.out.println();
        System.out.println("beginWord = \"hit\"");
        System.out.println("endWord = \"cog\"");
        System.out.println("Input word list is [\"hot\",\"dot\",\"dog\",\"lot\",\"log\",\"cog\"]");
        System.out.println("Expected output is 5");
        System.out.println("Actual output is " + graphsLeetCodeProblems.ladderLength("hit", "cog", Arrays.asList(
                new String[]{"hot", "dot", "dog", "lot", "log", "cog"})));

        System.out.println();
        System.out.println("beginWord = \"hit\"");
        System.out.println("endWord = \"cog\"");
        System.out.println("Input word list is [\"hot\",\"dot\",\"dog\",\"lot\",\"log\"]");
        System.out.println("Expected output is 0");
        System.out.println("Actual output is " + graphsLeetCodeProblems.ladderLength("hit", "cog", Arrays.asList(
                new String[]{"hot","dot","dog","lot","log"})));

        System.out.println();
        System.out.println("beginWord = \"hot\"");
        System.out.println("endWord = \"dog\"");
        System.out.println("Input word list is [\"hot\",\"dog\"]");
        System.out.println("Expected output is 0");
        System.out.println("Actual output is " + graphsLeetCodeProblems.ladderLength("hot", "dog", Arrays.asList(
                new String[]{"hot","dog"})));

        System.out.println();
        System.out.println("beginWord = \"hit\"");
        System.out.println("endWord = \"cog\"");
        System.out.println("Input word list is [\"hot\",\"cog\",\"dot\",\"dog\",\"hit\",\"lot\",\"log\"]");
        System.out.println("Expected output is 5");
        System.out.println("Actual output is " + graphsLeetCodeProblems.ladderLength("hit", "cog", Arrays.asList(
                new String[]{"hot","cog","dot","dog","hit","lot","log"})));

        System.out.println();
        System.out.println("beginWord = \"a\"");
        System.out.println("endWord = \"c\"");
        System.out.println("Input word list is [\"a\",\"b\",\"c\"]");
        System.out.println("Expected output is 2");
        System.out.println("Actual output is " + graphsLeetCodeProblems.ladderLength("a", "b", Arrays.asList(
                new String[]{"a","b","c"})));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> adjacenyList = new HashMap<>();
        String wordToStart = null;
        for (String word : wordList) {
            adjacenyList.put(word, new ArrayList<>());
            for (String wordToCheck : wordList) {
                if (!wordToCheck.equals(word) && areNeighbours(word, wordToCheck)) {
                    List<String> neighbours = adjacenyList.get(word);
                    neighbours.add(wordToCheck);
                    adjacenyList.put(word, neighbours);
                }
            }
            if (areNeighbours(word, beginWord) && !beginWord.equals(wordToStart)) {
                wordToStart = word;
            }
        }
        System.out.println("Start word " + wordToStart);
        System.out.println("Adjancy list "+ adjacenyList);

        int result = beginWord.equals(wordToStart) ? 0 : 1;
        Set<String> visited = new HashSet<>();
        Queue<String> bfsQueue = new LinkedList<>();
        bfsQueue.add(wordToStart);
        visited.add(wordToStart);

        while (!bfsQueue.isEmpty()) {
            result++;
            int queueLength = bfsQueue.size();
            for (int i = 0; i < queueLength; i++) {
                String word = bfsQueue.poll();
                if (endWord.equals(word)) {
                    return result;
                }
                visited.add(word);
                for (String neighbour : adjacenyList.get(word)) {
                    if (!visited.contains(neighbour)) {
                        bfsQueue.add(neighbour);
                    }
                }
            }
        }

        return 0;
    }

    private boolean areNeighbours(String word1, String word2) {
        int difference = 0;
        for (int index = 0; index < word1.length(); index++) {
            if (word1.charAt(index) != word2.charAt(index)) {
                difference++;
            }
        }
        return (difference <= 1);
    }

    public int[] findRedundantConnection(int[][] edges) {
        int[] parents = new int[edges.length + 1];
        int[] ranks = new int[edges.length + 1];

        for (int i = 0; i < edges.length; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1], parents, ranks)) {
                return edge;
            }
        }
        return new int[]{};
    }

    private int find(int n, int[] parents) {
        int parentOfN = parents[n];
        while (parentOfN != parents[parentOfN]) {
            parents[parentOfN] = parents[parents[parentOfN]];
            parentOfN = parents[parentOfN];
        }
        return parentOfN;
    }

    // return false if we cannot complete the union
    private boolean union(int n1, int n2, int[] parents, int[] ranks) {
        int parent1 = find(n1, parents);
        int parent2 = find(n2, parents);

        if (parent1 == parent2) {
            return false;
        }
        if (ranks[parent1] > ranks[parent2]) {
            parents[parent2] = parent1;
            ranks[parent1] += ranks[parent2];
        } else {
            parents[parent1] = parent2;
            ranks[parent2] += ranks[parent1];
        }
        return true;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjancenyList = new HashMap<>();
        List<Integer> answer = new ArrayList<>();

        // map each course to : prereq list
        for (int i = 0; i < numCourses; i++) {
            adjancenyList.put(i, new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> existingPreq = adjancenyList.get(prerequisites[i][0]);
            existingPreq.add(prerequisites[i][1]);
            adjancenyList.put(prerequisites[i][0], existingPreq);
        }

        Set<Integer> visitedSets = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();

        for (int index = 0; index < numCourses; index++) {
            if (!isTraversePossible(index, adjancenyList, visitedSets, cycle, answer)) {
                return new int[]{};
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean isTraversePossible(int course, Map<Integer, List<Integer>> adjancenyList, Set<Integer> visitedSets,
                                       Set<Integer> cycle, List<Integer> answer) {
        if (cycle.contains(course)) {
            return false;
        }
        if (visitedSets.contains(course)) {
            return true;
        }

        cycle.add(course);
        for (Integer preReq : adjancenyList.get(course)) {
            if (!isTraversePossible(preReq, adjancenyList, visitedSets, cycle, answer)) {
                return false;
            }
        }

        cycle.remove(course);
        answer.add(course);
        visitedSets.add(course);
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjancenyList = new HashMap<>();

        // map each course to : prereq list
        for (int i = 0; i < numCourses; i++) {
            adjancenyList.put(i, new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> existingPreq = adjancenyList.get(prerequisites[i][0]);
            existingPreq.add(prerequisites[i][1]);
            adjancenyList.put(prerequisites[i][0], existingPreq);
        }

        // Visited Course is a set containing all courses along the current DFS Path
        // This is to detect cycle
        Set<Integer> cycle = new HashSet<>();
        for (Integer course : adjancenyList.keySet()) {
            // If 1 is false the result would be false, else true
            if (!isCoursePossibleToFinish(course, adjancenyList, cycle)) {
                return false;
            }
        }

        return true;
    }

    private boolean isCoursePossibleToFinish(Integer course, Map<Integer, List<Integer>> adjancenyList, Set<Integer> cycle) {
        // Base Case for false - Cycle Detection
        if (cycle.contains(course)) {
            return false;
        }
        // Base Case for true - No Prerequisites
        if (adjancenyList.get(course).size() == 0) {
            return true;
        }

        cycle.add(course);
        for (Integer preqCourse : adjancenyList.get(course)) {
            // If 1 is false the result would be false, else true
            if (!isCoursePossibleToFinish(preqCourse, adjancenyList, cycle)) {
                return false;
            }
        }

        // Important: Remove the current one from the set
        cycle.remove(course);
        adjancenyList.put(course, new ArrayList<>());
        return true;
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> answer = new ArrayList<>();
        int totalRows = heights.length;
        int totalColumns = heights[0].length;

        Set<Node> pacific = new HashSet<>();
        Set<Node> atlantic = new HashSet<>();

        //
        for (int col = 0; col < totalColumns; col++) {
            dfsForOcean(0, col, heights[0][col], pacific, heights);
            dfsForOcean(totalRows - 1, col, heights[totalRows - 1][col], atlantic, heights);
        }

        for (int row = 0; row < totalRows; row++) {
            dfsForOcean(row, 0, heights[row][0], pacific, heights);
            dfsForOcean(row, totalColumns - 1, heights[row][totalColumns - 1], atlantic, heights);
        }

        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalColumns; col++) {
                Node newNode = new Node(row, col);
                if (pacific.contains(newNode) && atlantic.contains(newNode)) {
                    answer.add(getNodeAsArray(row, col));
                }
            }
        }

        return answer;
    }

    private List<Integer> getNodeAsArray(int row, int col) {
        List<Integer> nodeAsArray = new ArrayList<>(2);
        nodeAsArray.add(row);
        nodeAsArray.add(col);
        return nodeAsArray;
    }

    private void dfsForOcean(int row, int col, int prevHeight, Set<Node> visitedSet, int[][] heights) {
        if (visitedSet.contains(new Node(row, col)) || row < 0 || row >= heights.length || col < 0 ||
                col >= heights[0].length || heights[row][col] < prevHeight) {
            return;
        }
        visitedSet.add(new Node(row, col));
        dfsForOcean(row + 1, col, heights[row][col], visitedSet, heights);
        dfsForOcean(row - 1, col, heights[row][col], visitedSet, heights);
        dfsForOcean(row, col + 1, heights[row][col], visitedSet, heights);
        dfsForOcean(row, col - 1, heights[row][col], visitedSet, heights);
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

    public GraphNode cloneGraph(GraphNode node) {
        Map<GraphNode, GraphNode> oldNewMapping = new HashMap<>();
        dfsToCloneGraph(node, oldNewMapping);

        return oldNewMapping.get(node);
    }

    private GraphNode dfsToCloneGraph(GraphNode node, Map<GraphNode, GraphNode> oldNewMapping) {
        if (oldNewMapping.containsKey(node)) {
            return oldNewMapping.get(node);
        }
        if (node == null) {
            return null;
        }
        GraphNode newNode = new GraphNode(node.val);
        oldNewMapping.put(node, newNode);
        for (GraphNode neighbour : node.neighbors) {
            if (neighbour != null) {
                if (oldNewMapping.containsKey(neighbour)) {
                    newNode.neighbors.add(oldNewMapping.get(neighbour));
                } else {
                    newNode.neighbors.add(dfsToCloneGraph(neighbour, oldNewMapping));
                }
            }
        }

        return newNode;
    }

    static class GraphNode {
        public int val;
        public List<GraphNode> neighbors;

        public GraphNode() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public GraphNode(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public GraphNode(int _val, List<GraphNode> _neighbors) {
            val = _val;
            neighbors = _neighbors;
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
