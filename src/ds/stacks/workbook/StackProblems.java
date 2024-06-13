package ds.stacks.workbook;

public class StackProblems {

    public static void main(String[] args) {
        StackProblems solution = new StackProblems();

        // Test case 1: "()"
        String testCase1 = "()";
        boolean result1 = solution.isValid(testCase1);
        System.out.println("Test case 1 (" + testCase1 + "): " + result1 + " (Expected: true)");

        // Test case 2: "()[]{}"
        String testCase2 = "()[]{}";
        boolean result2 = solution.isValid(testCase2);
        System.out.println("Test case 2 (" + testCase2 + "): " + result2 + " (Expected: true)");

        // Test case 3: "(]"
        String testCase3 = "(]";
        boolean result3 = solution.isValid(testCase3);
        System.out.println("Test case 3 (" + testCase3 + "): " + result3 + " (Expected: false)");

        // Test case 4: "([)]"
        String testCase4 = "([)]";
        boolean result4 = solution.isValid(testCase4);
        System.out.println("Test case 4 (" + testCase4 + "): " + result4 + " (Expected: false)");

        // Test case 5: "{[]}"
        String testCase5 = "{[]}";
        boolean result5 = solution.isValid(testCase5);
        System.out.println("Test case 5 (" + testCase5 + "): " + result5 + " (Expected: true)");

        // Test case 6: "((((((("
        String testCase6 = "(((((((";
        boolean result6 = solution.isValid(testCase6);
        System.out.println("Test case 6 (" + testCase6 + "): " + result6 + " (Expected: false)");

        // Test case 7: "" (empty string)
        String testCase7 = "";
        boolean result7 = solution.isValid(testCase7);
        System.out.println("Test case 7 (" + testCase7 + "): " + result7 + " (Expected: true)");

        // Test case 8: "]"
        String testCase8 = "]";
        boolean result8 = solution.isValid(testCase8);
        System.out.println("Test case 8 (" + testCase8 + "): " + result8 + " (Expected: false)");


        // Test case 1: "/home/"
        String path1 = "/home/";
        String result1Str = solution.simplifyPath(path1);
        System.out.println("Test case 1 (" + path1 + "): " + result1Str + " (Expected: /home)");

        // Test case 2: "/home//foo/"
        String path2 = "/home//foo/";
        String result2Str = solution.simplifyPath(path2);
        System.out.println("Test case 2 (" + path2 + "): " + result2Str + " (Expected: /home/foo)");

        // Test case 3: "/home/user/Documents/../Pictures"
        String path3 = "/home/user/Documents/../Pictures";
        String result3Str = solution.simplifyPath(path3);
        System.out.println("Test case 3 (" + path3 + "): " + result3Str + " (Expected: /home/user/Pictures)");

        // Test case 4: "/../"
        String path4 = "/../";
        String result4Str = solution.simplifyPath(path4);
        System.out.println("Test case 4 (" + path4 + "): " + result4Str + " (Expected: /)");

        // Test case 5: "/.../a/../b/c/../d/./"
        String path5 = "/.../a/../b/c/../d/./";
        String result5Str = solution.simplifyPath(path5);
        System.out.println("Test case 5 (" + path5 + "): " + result5Str + " (Expected: /.../b/d)");

        // Additional test case 6: "/a/./b/../../c/"
        String path6 = "/a/./b/../../c/";
        String result6Str = solution.simplifyPath(path6);
        System.out.println("Test case 6 (" + path6 + "): " + result6Str + " (Expected: /c)");

        // Additional test case 7: "/a//b////c/d//././/.."
        String path7 = "/a//b////c/d//././/..";
        String result7Str = solution.simplifyPath(path7);
        System.out.println("Test case 7 (" + path7 + "): " + result7Str + " (Expected: /a/b/c)");


        // Test case 1: ["2","1","+","3","*"]
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        int result1Int = solution.evalRPN(tokens1);
        System.out.println("Test case 1 (tokens1): " + result1Int + " (Expected: 9)");

        // Test case 2: ["4","13","5","/","+"]
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        int result2Int = solution.evalRPN(tokens2);
        System.out.println("Test case 2 (tokens2): " + result2Int + " (Expected: 6)");

        // Test case 3: ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int result3Int = solution.evalRPN(tokens3);
        System.out.println("Test case 3 (tokens3): " + result3Int + " (Expected: 22)");

        // Additional test cases

        // Test case 4: ["3","4","+","2","*","7","/"]
        String[] tokens4 = {"3", "4", "+", "2", "*", "7", "/"};
        int result4Int = solution.evalRPN(tokens4);
        System.out.println("Test case 4 (tokens4): " + result4Int + " (Expected: 2)");

        // Test case 5: ["5","1","2","+","4","*","+","3","-"]
        String[] tokens5 = {"5", "1", "2", "+", "4", "*", "+", "3", "-"};
        int result5Int = solution.evalRPN(tokens5);
        System.out.println("Test case 5 (tokens5): " + result5Int + " (Expected: 14)");

        // Test case 6: ["2","3","*","5","4","*","+"]
        String[] tokens6 = {"2", "3", "*", "5", "4", "*", "+"};
        int result6Int= solution.evalRPN(tokens6);
        System.out.println("Test case 6 (tokens6): " + result6Int + " (Expected: 26)");

        // Test case 7: ["10","6","9","3","+","11","*","/","*","17","+","5","+"]
        String[] tokens7 = {"10", "6", "9", "3", "+", "11", "*", "/", "*", "17", "+", "5", "+"};
        int result7Int = solution.evalRPN(tokens7);
        System.out.println("Test case 7 (tokens7): " + result7Int + " (Expected: 3)");

        String expression1 = "1 + 1";
        result1Int = solution.calculate(expression1);
        System.out.println("Expression: " + expression1 + " = " + result1Int + " (Expected: 2)");

        // Test case 2
        String expression2 = " 2-1 + 2 ";
        result2Int = solution.calculate(expression2);
        System.out.println("Expression: " + expression2 + " = " + result2Int + " (Expected: 3)");

        // Test case 3
        String expression3 = "(1+(4+5+2)-3)+(6+8)";
        result3Int = solution.calculate(expression3);
        System.out.println("Expression: " + expression3 + " = " + result3Int + " (Expected: 23)");

        // Additional Test case 4
        String expression4 = "(2+6-3) + (5-2+(8-4))";
        result4Int = solution.calculate(expression4);
        System.out.println("Expression: " + expression4 + " = " + result4Int + " (Expected: 12)");

        // Additional Test case 5
        String expression5 = "10 + (2 - 3 + (5 + 3))";
        result5Int = solution.calculate(expression5);
        System.out.println("Expression: " + expression5 + " = " + result5Int + " (Expected: 17)");

        // Additional Test case 6
        String expression6 = "2 - (3 + (4 - 5))";
        result6Int = solution.calculate(expression6);
        System.out.println("Expression: " + expression6 + " = " + result6Int + " (Expected: 0)");
    }

    public boolean isValid(String s) {

        return false;
    }

    /**
     * Given an absolute path for a Unix-style file system, which begins with a slash '/', transform this path into its
     * simplified canonical path.
     *
     * In Unix-style file system context, a single period '.' signifies the current directory, a double period ".."
     * denotes moving up one directory level, and multiple slashes such as "//" are interpreted as a single slash. In this
     * problem, treat sequences of periods not covered by the previous rules (like "...") as valid names for files or
     * directories.
     *
     * The simplified canonical path should adhere to the following rules:
     *
     * It must start with a single slash '/'.
     * Directories within the path should be separated by only one slash '/'.
     * It should not end with a slash '/', unless it's the root directory.
     * It should exclude any single or double periods used to denote current or parent directories.
     * Return the new path.
     *
     * Example 1:
     *
     * Input: path = "/home/"
     *
     * Output: "/home"
     *
     * Explanation:
     *
     * The trailing slash should be removed.
     *
     *
     * Example 2:
     *
     * Input: path = "/home//foo/"
     *
     * Output: "/home/foo"
     *
     * Explanation:
     *
     * Multiple consecutive slashes are replaced by a single one.
     *
     * Example 3:
     *
     * Input: path = "/home/user/Documents/../Pictures"
     *
     * Output: "/home/user/Pictures"
     *
     * Explanation:
     *
     * A double period ".." refers to the directory up a level.
     *
     * Example 4:
     *
     * Input: path = "/../"
     *
     * Output: "/"
     *
     * Explanation:
     *
     * Going one level up from the root directory is not possible.
     *
     * Example 5:
     *
     * Input: path = "/.../a/../b/c/../d/./"
     *
     * Output: "/.../b/d"
     *
     * Explanation:
     *
     * "..." is a valid name for a directory in this problem.
     */
    public String simplifyPath(String path) {
        return null;
    }


    /**
     * The valid operators are '+', '-', '*', and '/'.
     * Each operand may be an integer or another expression.
     * The division between two integers always truncates toward zero.
     * There will not be any division by zero.
     * The input represents a valid arithmetic expression in a reverse polish notation.
     * The answer and all the intermediate calculations can be represented in a 32-bit integer.
     *
     *
     * Example 1:
     *
     * Input: tokens = ["2","1","+","3","*"]
     * Output: 9
     * Explanation: ((2 + 1) * 3) = 9
     * Example 2:
     *
     * Input: tokens = ["4","13","5","/","+"]
     * Output: 6
     * Explanation: (4 + (13 / 5)) = 6
     * Example 3:
     *
     * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
     * Output: 22
     * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
     * = ((10 * (6 / (12 * -11))) + 17) + 5
     * = ((10 * (6 / -132)) + 17) + 5
     * = ((10 * 0) + 17) + 5
     * = (0 + 17) + 5
     * = 17 + 5
     * = 22
     *
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        return -1;
    }

    /**
     * Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the
     * result of the evaluation.
     *
     * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as
     * eval().
     *
     *
     *
     * Example 1:
     *
     * Input: s = "1 + 1"
     * Output: 2
     * Example 2:
     *
     * Input: s = " 2-1 + 2 "
     * Output: 3
     * Example 3:
     *
     * Input: s = "(1+(4+5+2)-3)+(6+8)"
     * Output: 23
     *
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        return -1;
    }
}
