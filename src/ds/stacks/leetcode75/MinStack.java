package ds.stacks.leetcode75;

import java.util.ArrayList;
import java.util.List;

class MinStack {

    public static void main(String[] args) {

    }

    private List<Integer> arrayList = null;
    private List<Integer> minStack = null;

    public MinStack() {
        arrayList = new ArrayList<>();
        minStack = new ArrayList<>();
    }

    public void push(int val) {
        arrayList.add(val);
        if (minStack.size() == 0) {
            minStack.add(val);
            return;
        } else {
            if (val < minStack.get(minStack.size() - 1)) {
                minStack.add(val);
            }
            return;
        }
    }

    public void pop() {
        int val = minStack.get(minStack.size() - 1);
        int valInStack = arrayList.get(arrayList.size() - 1);
        if (valInStack == val) {
            minStack.remove(minStack.size() - 1);
        }
        arrayList.remove(arrayList.size() - 1);
    }

    public int top() {
        return arrayList.get(arrayList.size() - 1);
    }

    public int getMin() {
        return minStack.get(minStack.size() - 1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
