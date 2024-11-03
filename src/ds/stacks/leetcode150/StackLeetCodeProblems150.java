package ds.stacks.leetcode150;

import java.util.*;

public class StackLeetCodeProblems150 {
    public static void main(String[] args) {
        // Problem 1: Valid Parentheses
        System.out.println("Problem 1: Valid Parentheses");
        System.out.println("Input: \"[]\"");
        System.out.println("Expected Output: true");
        System.out.println("Actual Output: " + isValid("[]"));
        System.out.println();

        System.out.println("Input: \"([{}])\"");
        System.out.println("Expected Output: true");
        System.out.println("Actual Output: " + isValid("([{}])"));
        System.out.println();

        System.out.println("Input: \"[(])\"");
        System.out.println("Expected Output: false");
        System.out.println("Actual Output: " + isValid("[(])"));
        System.out.println();

        // Problem 2: Minimum Stack
        System.out.println("Problem 2: Minimum Stack");
        StackLeetCodeProblems150.MinStack minStack = new StackLeetCodeProblems150.MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(0);
        System.out.println("Operations: [\"MinStack\", \"push\", 1, \"push\", 2, \"push\", 0, \"getMin\", \"pop\", \"top\", \"getMin\"]");
        System.out.println("Expected Output: [null, null, null, null, 0, null, 2, 1]");
        System.out.println("Actual Output: ");
        System.out.println("getMin(): " + minStack.getMin()); // Expected output: 0
        minStack.pop();
        System.out.println("top(): " + minStack.top()); // Expected output: 2
        System.out.println("getMin(): " + minStack.getMin()); // Expected output: 1
        System.out.println();

        // Problem 3: Evaluate Reverse Polish Notation
        System.out.println("Problem 3: Evaluate Reverse Polish Notation");
        String[] tokens1 = {"1", "2", "+", "3", "*", "4", "-"};
        System.out.println("Input: [\"1\", \"2\", \"+\", \"3\", \"*\", \"4\", \"-\"]");
        System.out.println("Expected Output: 5");
        System.out.println("Actual Output: " + evalRPN(tokens1));
        System.out.println();

        // Problem 4: Generate Parentheses
        System.out.println("Problem 4: Generate Parentheses");
        System.out.println("Input: 1");
        System.out.println("Expected Output: [\"()\"]");
        System.out.println("Actual Output: " + generateParenthesis(1));
        System.out.println();

        System.out.println("Input: 3");
        System.out.println("Expected Output: [\"((()))\",\"(()())\",\"(())()\",\"()(())\",\"()()()\"]");
        System.out.println("Actual Output: " + generateParenthesis(3));
        System.out.println();

        // Problem 5: Daily Temperatures
        System.out.println("Problem 5: Daily Temperatures");
        int[] temperatures1 = {30, 38, 30, 36, 35, 40, 28};
        System.out.println("Input: [30, 38, 30, 36, 35, 40, 28]");
        System.out.println("Expected Output: [1, 4, 1, 2, 1, 0, 0]");
        System.out.println("Actual Output: " + Arrays.toString(dailyTemperatures(temperatures1)));
        System.out.println();

        int[] temperatures2 = {22, 21, 20};
        System.out.println("Input: [22, 21, 20]");
        System.out.println("Expected Output: [0, 0, 0]");
        System.out.println("Actual Output: " + Arrays.toString(dailyTemperatures(temperatures2)));
        System.out.println();

        // Problem 1: Car Fleet
        System.out.println("Problem 1: Car Fleet");
        int target1 = 10;
        int[] position1 = {1, 4};
        int[] speed1 = {3, 2};
        System.out.println("Input: target = 10, position = [1, 4], speed = [3, 2]");
        System.out.println("Expected Output: 1");
        System.out.println("Actual Output: " + carFleet(target1, position1, speed1));
        System.out.println();

        int target2 = 10;
        int[] position2 = {4, 1, 0, 7};
        int[] speed2 = {2, 2, 1, 1};
        System.out.println("Input: target = 10, position = [4, 1, 0, 7], speed = [2, 2, 1, 1]");
        System.out.println("Expected Output: 3");
        System.out.println("Actual Output: " + carFleet(target2, position2, speed2));
        System.out.println();

        // Problem 2: Largest Rectangle In Histogram
        System.out.println("Problem 2: Largest Rectangle In Histogram");
        int[] heights1 = {7, 1, 7, 2, 2, 4};
        System.out.println("Input: heights = [7, 1, 7, 2, 2, 4]");
        System.out.println("Expected Output: 8");
        System.out.println("Actual Output: " + largestRectangleArea(heights1));
        System.out.println();

        int[] heights2 = {1, 3, 7};
        System.out.println("Input: heights = [1, 3, 7]");
        System.out.println("Expected Output: 7");
        System.out.println("Actual Output: " + largestRectangleArea(heights2));
        System.out.println();
    }

    // Problem 1: Valid Parentheses

    /**
     * You are given a string s consisting of the following characters: '(', ')', '{', '}', '[' and ']'.
     *
     * The input string s is valid if and only if:
     *
     * Every open bracket is closed by the same type of close bracket.
     * Open brackets are closed in the correct order.
     * Every close bracket has a corresponding open bracket of the same type.
     * Return true if s is a valid string, and false otherwise.
     *
     * Example 1:
     *
     * Input: s = "[]"
     *
     * Output: true
     * Example 2:
     *
     * Input: s = "([{}])"
     *
     * Output: true
     * Example 3:
     *
     * Input: s = "[(])"
     *
     * Output: false
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // Problem 2: Minimum Stack
    /**
     * Minimum Stack
     * Design a stack class that supports the push, pop, top, and getMin operations.
     *
     * MinStack() initializes the stack object.
     * void push(int val) pushes the element val onto the stack.
     * void pop() removes the element on the top of the stack.
     * int top() gets the top element of the stack.
     * int getMin() retrieves the minimum element in the stack.
     * Each function should run in
     * O
     * (
     * 1
     * )
     * O(1) time.
     *
     * Example 1:
     *
     * Input: ["MinStack", "push", 1, "push", 2, "push", 0, "getMin", "pop", "top", "getMin"]
     *
     * Output: [null,null,null,null,0,null,2,1]
     *
     * Explanation:
     * MinStack minStack = new MinStack();
     * minStack.push(1);
     * minStack.push(2);
     * minStack.push(0);
     * minStack.getMin(); // return 0
     * minStack.pop();
     * minStack.top();    // return 2
     * minStack.getMin(); // return 1
     *
     */
    static class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
        }

        public void pop() {
            if (stack.pop().equals(minStack.peek())) {
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    // Problem 3: Evaluate Reverse Polish Notation
    /**
     * Evaluate Reverse Polish Notation
     * You are given an array of strings tokens that represents a valid arithmetic expression in Reverse Polish Notation.
     *
     * Return the integer that represents the evaluation of the expression.
     *
     * The operands may be integers or the results of other operations.
     * The operators include '+', '-', '*', and '/'.
     * Assume that division between integers always truncates toward zero.
     * Example 1:
     *
     * Input: tokens = ["1","2","+","3","*","4","-"]
     *
     * Output: 5
     *
     * Explanation: ((1 + 2) * 3) - 4 = 5
     *
     * @param tokens
     * @return
     */
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+-*/".contains(token)) {
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    // Problem 4: Generate Parentheses

    /**
     * Generate Parentheses
     * You are given an integer n. Return all well-formed parentheses strings that you can generate with n pairs of
     * parentheses.
     *
     * Example 1:
     *
     * Input: n = 1
     *
     * Output: ["()"]
     * Example 2:
     *
     * Input: n = 3
     *
     * Output: ["((()))","(()())","(())()","()(())","()()()"]
     * You may return the answer in any order.
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper(result, "", 0, 0, n);
        return result;
    }

    /**
     * Generate Parentheses
     * You are given an integer n. Return all well-formed parentheses strings that you can generate with n pairs of
     * parentheses.
     *
     * Example 1:
     *
     * Input: n = 1
     *
     * Output: ["()"]
     * Example 2:
     *
     * Input: n = 3
     *
     * Output: ["((()))","(()())","(())()","()(())","()()()"]
     * You may return the answer in any order.
     *
     * @param result
     * @param current
     * @param open
     * @param close
     * @param max
     */
    private static void generateParenthesisHelper(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        if (open < max) {
            generateParenthesisHelper(result, current + "(", open + 1, close, max);
        }
        if (close < open) {
            generateParenthesisHelper(result, current + ")", open, close + 1, max);
        }
    }

    // Problem 5: Daily Temperatures
    /**
     * Daily Temperatures
     * You are given an array of integers temperatures where temperatures[i] represents the daily temperatures on the ith
     * day.
     *
     * Return an array result where result[i] is the number of days after the ith day before a warmer temperature appears
     * on a future day. If there is no day in the future where a warmer temperature will appear for the ith day, set
     * result[i] to 0 instead.
     *
     * Example 1:
     *
     * Input: temperatures = [30,38,30,36,35,40,28]
     *
     * Output: [1,4,1,2,1,0,0]
     * Example 2:
     *
     * Input: temperatures = [22,21,20]
     *
     * Output: [0,0,0]
     *
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }

    /**
     * Car Fleet
     * There are n cars traveling to the same destination on a one-lane highway.
     *
     * You are given two arrays of integers position and speed, both of length n.
     *
     * position[i] is the position of the ith car (in miles)
     * speed[i] is the speed of the ith car (in miles per hour)
     * The destination is at position target miles.
     *
     * A car can not pass another car ahead of it. It can only catch up to another car and then drive at the same speed as
     * the car ahead of it.
     *
     * A car fleet is a non-empty set of cars driving at the same position and same speed. A single car is also considered
     * a car fleet.
     *
     * If a car catches up to a car fleet the moment the fleet reaches the destination, then the car is considered to be
     * part of the fleet.
     *
     * Return the number of different car fleets that will arrive at the destination.
     *
     * Example 1:
     *
     * Input: target = 10, position = [1,4], speed = [3,2]
     *
     * Output: 1
     * Explanation: The cars starting at 1 (speed 3) and 4 (speed 2) become a fleet, meeting each other at 10, the
     * destination.
     *
     * Example 2:
     *
     * Input: target = 10, position = [4,1,0,7], speed = [2,2,1,1]
     *
     * Output: 3
     * Explanation: The cars starting at 4 and 7 become a fleet at position 10. The cars starting at 1 and 0 never catch
     * up to the car ahead of them. Thus, there are 3 car fleets that will arrive at the destination.
     *
     * @param target
     * @param position
     * @param speed
     * @return
     */
    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }
        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));

        int fleets = 0;
        double time = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (cars[i][1] > time) {
                time = cars[i][1];
                fleets++;
            }
        }
        return fleets;
    }


    /**
     * Largest Rectangle In Histogram
     * You are given an array of integers heights where heights[i] represents the height of a bar. The width of each bar
     * is 1.
     *
     * Return the area of the largest rectangle that can be formed among the bars.
     *
     * Note: This chart is known as a histogram.
     *
     * Example 1:
     *
     * Input: heights = [7,1,7,2,2,4]
     *
     * Output: 8
     * Example 2:
     *
     * Input: heights = [1,3,7]
     *
     * Output: 7
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}

