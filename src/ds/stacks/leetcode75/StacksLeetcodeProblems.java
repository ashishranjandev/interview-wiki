package ds.stacks.leetcode75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class StacksLeetcodeProblems {

    public static void main(String[] args) {
        StacksLeetcodeProblems stacksLeetcodeProblems = new StacksLeetcodeProblems();
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] output = stacksLeetcodeProblems.dailyTemperatures(temperatures);
        System.out.println(" For temperatures " + Arrays.toString(temperatures) + " Output is " + Arrays.toString(output));

        System.out.println("\n Car Fleet Question \n");
        int[] positions = {6,8};
        int[] speed = {3,2};
        int target = 10;
        System.out.println("Position Array - " + Arrays.toString(positions));
        System.out.println("Speed Array -    " + Arrays.toString(speed));
        System.out.println("No of fleets for target "+ target +" are " + stacksLeetcodeProblems.carFleet(target, positions, speed));

        System.out.println("\n Largest Rectangle in Histogram Question \n");
        int[] heights1 = {2,1,5,6,2,3};
        System.out.println("Area of Largest Rectangle in a histogram of {2,1,5,6,2,3} is " + stacksLeetcodeProblems.largestRectangleArea(heights1));
        int[] heights2 = {2,4};
        System.out.println("Area of Largest Rectangle in a histogram of {2,1,5,6,2,3} is " + stacksLeetcodeProblems.largestRectangleArea(heights2));
    }

    /**
     * Monotonic Stack Problem
     *
     * Since we have to find the distance at every index to the next larger element.
     * We create a monotonic stack.
     *
     * We iterate over the temperature array.
     *     If stack is empty
     *         Just push the index of the element
     *     If stack is not empty
     *         Keep popping the elements where the temperature value is lower than the current element or the stack
     *         becomes empty
     *         If the stack is not empty
     *             update output value at that position as different of current index - the index of the element
     *         else
     *             just push the index on the stack
     *
     * return the output array
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] output = new int[temperatures.length];
        Stack<Integer> temperatureStack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!temperatureStack.empty() && temperatures[temperatureStack.peek()] < temperatures[i]) {
                output[temperatureStack.peek()] = i - temperatureStack.pop();
            }
            temperatureStack.push(i);
        }
        return output;
    }

    /**
     * Since it is a one lane road the faster car would just eventually start moving with the speed of car ahead of it.
     * If time taken for it to reach target < time taken to reach target for the one ahead of it
     *
     * We sort the array .. descending using position
     * We create a stack from the largest position
     * While iterating if the time taken for current element is lower than the element on top of stack
     *     Just Ignore It .. Since it will just get merged with previous element
     * If time taken is more push it on top of stack
     *
     * After the iteration is over .. return the size of stack as number of fleet
     *
     * @param target
     * @param position
     * @param speed
     * @return
     */
    public int carFleet(int target, int[] position, int[] speed) {
        Comparator<PostitionSpeedPair> postitionComparator
                = Comparator.comparing(PostitionSpeedPair::getPosition);
        Comparator<PostitionSpeedPair> postitionComparatorReversed
                = postitionComparator.reversed();

        List<PostitionSpeedPair> postitionSpeedPairList = new ArrayList<>(position.length);
        for (int i = 0; i < position.length; i++) {
            postitionSpeedPairList.add(new PostitionSpeedPair(position[i], speed[i]));
        }
        Collections.sort(postitionSpeedPairList, postitionComparatorReversed);
        Stack<PostitionSpeedPair> postitionSpeedPairStack = new Stack<>();
        for (int i = 0; i < position.length; i++) {
            if (!postitionSpeedPairStack.isEmpty()) {
                float timeTakenByStackTop = getTimeTaken(target, postitionSpeedPairStack.peek().position,
                                                       postitionSpeedPairStack.peek().speed);
                float timeTakenByCurrentElement = getTimeTaken(target, postitionSpeedPairList.get(i).position,
                                                       postitionSpeedPairList.get(i).speed);
                if (timeTakenByCurrentElement > timeTakenByStackTop) {
                    postitionSpeedPairStack.push(postitionSpeedPairList.get(i));
                }
            } else {
                postitionSpeedPairStack.push(postitionSpeedPairList.get(i));
            }
        }
        return postitionSpeedPairStack.size();

    }

    private float getTimeTaken(int target, int position, int speed) {
        return ((float) target - (float) position) / (float) speed;
    }

    private class PostitionSpeedPair {
        int position;
        int speed;
        PostitionSpeedPair(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }

        public int getPosition() {
            return position;
        }

        public int getSpeed() {
            return speed;
        }
    }

    /**
     * A bar can only create an area till the next ones are larger than it.
     * As soon as we get a bar lower than the current height the bar's rectangle creating capacity is lost.
     * We should keep track of the area it would have covered till now and then discard it
     * and compare this area with the maxArea till now and replace (if greater)
     *
     * Initialize maxArea = height[0] * 1;
     * Iterate over the array
     *  If stack is Empty
     *    Push the current index, height[index]
     *  else
     *    while stack is not empty
     *      Pop all elements where their height is more than current height (Since they are not valid any more)
     *      Calculate their area = (current index - popped index) * popped height
     *       if area > maxArea -> Update maxArea
     *    Push the current height[i] with index = (index of last Popped element)
     *    If no elements were popped
     *     Push the current height[i] with index = currentIndex
     *
     * If stack is empty
     *  return maxArea
     * If stack is not empty
     *  calculate area for every element in stack
     *   area = (heights.length - element.index) * element.height
     *   if area > maxArea -> Update maxArea
     *
     * return maxArea
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int maxArea = heights[0];
        Stack<IndexHeightPair> indexHeightPairStack = new Stack<>();
        IndexHeightPair poppedIndexHeightPair = null;
        for (int i = 0; i < heights.length; i++) {
            int indexToBeInserted = i;
            if (!indexHeightPairStack.isEmpty()) {
               while (!indexHeightPairStack.isEmpty() && indexHeightPairStack.peek().height > heights[i]) {
                    poppedIndexHeightPair = indexHeightPairStack.pop();
                    int area =  (i - poppedIndexHeightPair.index) * poppedIndexHeightPair.height;
                    maxArea = (area > maxArea) ? area : maxArea;
                    indexToBeInserted = poppedIndexHeightPair.index;
               }
            }
            IndexHeightPair indexHeightPairToBePushed = new IndexHeightPair(indexToBeInserted, heights[i]);
            indexHeightPairStack.push(new IndexHeightPair(indexToBeInserted, heights[i]));
        }

        while (!indexHeightPairStack.isEmpty()) {
            poppedIndexHeightPair = indexHeightPairStack.pop();
            int area = ((heights.length) - poppedIndexHeightPair.index ) * poppedIndexHeightPair.height;
            maxArea = (area > maxArea) ? area : maxArea;
        }
        return maxArea;
    }

    private class IndexHeightPair {
        int index;
        int height;

        public IndexHeightPair(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }


    /**
     * If token is no operation i.e. one of [+, /, *, -]
     *   Add every token as an integer in the stack
     * Else if token is an opeartion
     *   In that case, Pop two elements from the stack and then save the result back to it.
     *
     * After all operations are done through, the remaining element in the stack will be the result.
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        int a,b;
        Stack<Integer> operationStack = new Stack<>();
        for (String s : tokens) {
            if(s.equals("+")) {
                operationStack.add(operationStack.pop()+operationStack.pop());
            }
            else if(s.equals("/")) {
                b = operationStack.pop();
                a = operationStack.pop();
                operationStack.add(a / b);
            }
            else if(s.equals("*")) {
                operationStack.add(operationStack.pop() * operationStack.pop());
            }
            else if(s.equals("-")) {
                b = operationStack.pop();
                a = operationStack.pop();
                operationStack.add(a - b);
            }
            else {
                operationStack.add(Integer.parseInt(s));
            }
        }
        return operationStack.pop();
    }

}
