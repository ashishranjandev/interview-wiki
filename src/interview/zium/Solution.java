package interview.zium;


/**
 *
 * Stack
 *
 *            Implement PUSH, POP, TOP in O(1)
 *
 *            Implement getMin() in O(1)

 */
public class Solution {

    public static void main(String[] args) {
        NewStack<Integer> stack = new NewStack<>();
        stack.push(5);
        stack.push(3);
        stack.push(6);
        stack.push(2);

        System.out.println("Minimum element: " + stack.getMin()); // Output: 2

        stack.pop();
        System.out.println("Top element: " + stack.top()); // Output: 6
        System.out.println("Minimum element: " + stack.getMin()); // Output: 3
    }
}
