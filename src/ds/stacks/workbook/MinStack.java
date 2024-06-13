package ds.stacks.workbook;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 *
 */
public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
    }

    public void push(int val) {
    }

    public void pop() {
    }

    public int top() {
        return -1;
    }

    public int getMin() {
        return -1;
    }

    public static void main(String[] args) {
        // Create a new MinStack object
        MinStack minStack = new MinStack();

        // Perform the sequence of operations
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        // Expected output for getMin(): -3
        int min1 = minStack.getMin();
        System.out.println("getMin() after pushes: " + min1 + " (Expected: -3)");

        // Pop the top element
        minStack.pop();

        // Expected output for top(): 0
        int top = minStack.top();
        System.out.println("top() after pop: " + top + " (Expected: 0)");

        // Expected output for getMin(): -2
        int min2 = minStack.getMin();
        System.out.println("getMin() after pop: " + min2 + " (Expected: -2)");

        // Additional test cases
        // Test case 1: Push a single element and check min
        minStack = new MinStack();
        minStack.push(1);
        int min3 = minStack.getMin();
        System.out.println("getMin() after single push: " + min3 + " (Expected: 1)");

        // Test case 2: Push multiple elements and get min
        minStack.push(-1);
        minStack.push(2);
        int min4 = minStack.getMin();
        System.out.println("getMin() after multiple pushes: " + min4 + " (Expected: -1)");

        // Test case 3: Push and pop, then get top and min
        minStack.pop();
        int top2 = minStack.top();
        System.out.println("top() after push/pop: " + top2 + " (Expected: -1)");
        int min5 = minStack.getMin();
        System.out.println("getMin() after push/pop: " + min5 + " (Expected: -1)");


    }
}
