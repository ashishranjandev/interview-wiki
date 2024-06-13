package ds.linkedlists.leetcode75;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class LinkedListLeetCodeProblems {

    public static void main(String...args) {
        LinkedListLeetCodeProblems linkedListLeetCodeProblems = new LinkedListLeetCodeProblems();
        //[2,4,3]
        //[5,6,4]
        ListNode nodeLinkedList1 = new ListNode(2, null);
        nodeLinkedList1.next = new ListNode(4, null);
        nodeLinkedList1.next.next = new ListNode(3, null);

        ListNode nodeLinkedList2 = new ListNode(5, null);
        nodeLinkedList2.next = new ListNode(6, null);
        nodeLinkedList2.next.next = new ListNode(4, null);

        System.out.println(linkedListLeetCodeProblems.addTwoNumbers(nodeLinkedList1, nodeLinkedList2));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;

        ListNode curr = headA;
        while (curr != null) {
            lenA++;
            curr = curr.next;
        }

        curr = headB;
        while (curr != null) {
            lenB++;
            curr = curr.next;
        }

        ListNode currA = headA;
        ListNode currB = headB;

        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                currA = currA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                currB = currB.next;
            }
        }

        while (currA != null && currB != null) {
            if (currA == currB) {
                return currA;
            }
            currA = currA.next;
            currB = currB.next;
        }

        return null;
    }

    /**
     * Initialize two pointers, slow and fast, to the first element of the array nums.
     *
     * Move the slow pointer one step at a time and the fast pointer two steps at a time.
     * slow = nums[slow];
     * fast = nums[nums[fast]];
     *
     * Continue moving the pointers until they meet at the same index.
     *
     * Once the pointers meet, reset the slow pointer to the first element of nums.
     *
     * Move both the slow and fast pointers one step at a time until they meet again.
     * The point at which they meet is the index of the repeated number.
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Move slow and fast pointers
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Reset one pointer to the start
        slow = nums[0];

        // Move both pointers at the same pace until they meet
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; // or fast (they are at the same index)
    }

    /**
     * There are 2 passes needed
     *
     * In 1st pass just create copies of the nodes
     * and put them in HashMap -> Key = Current Node, Value =  Copied Node
     *
     * In 2nd pass through original array
     * .. start creating links to next and random by getting appropriate nodes from HashMap
     *
     * @param head
     * @return
     */
    public NodeWithRandomPointer copyRandomList(NodeWithRandomPointer head) {
        Map<NodeWithRandomPointer, NodeWithRandomPointer> nodeMap = new HashMap<>();
        NodeWithRandomPointer curr = head;
        while (curr != null) {
            NodeWithRandomPointer newNode = new NodeWithRandomPointer(curr.val);
            nodeMap.put(curr, newNode);
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            NodeWithRandomPointer newNode = nodeMap.get(curr);
            if (curr.next != null) {
                newNode.next = nodeMap.get(curr.next);
            }
            if (curr.random != null) {
                newNode.random = nodeMap.get(curr.random);
            }
            curr = curr.next;
        }

        return nodeMap.get(head);
    }



    /**
     * Choose Two Pointers Fast and Slow
     * Increment fast n times so that it is n ahead of slow
     *
     * Now run the loop till fast becomes null
     * Increment slow but keep a prev to keep track of previous node.
     *
     * Once loop completes make prev.next to slow.next .. thus skipping node being pointed by slow
     *
     * Edge Case: What if we are at 1st node only?
     * Check for this condition and return the slow.next as head of linked list
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;


        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        ListNode prev = slow;
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        if (prev == head) {
            return prev.next;
        }
        prev.next = slow.next;
        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr = l1;
        Stack<Integer> nodeStack1 = new Stack<>();
        while (curr != null) {
            nodeStack1.push(curr.val);
            curr = curr.next;
        }

        Stack<Integer> nodeStack2 = new Stack<>();
        curr = l2;
        while (curr != null) {
            nodeStack2.push(curr.val);
            curr = curr.next;
        }

        boolean isCarry = false;
        Queue<Integer> resultQueue = new LinkedList<>();
        while (!nodeStack1.isEmpty() && !nodeStack2.isEmpty()) {
            Integer result = nodeStack1.pop() + nodeStack2.pop() + ((isCarry) ? 1 : 0);
            if (result >= 10) {
                isCarry = true;
                result = result - 10;
            } else {
                isCarry = false;
            }
            resultQueue.add(result);
        }

        ListNode resultLinkedList = new ListNode(resultQueue.poll(), null);
        curr = resultLinkedList;
        while (!resultQueue.isEmpty()) {
            curr.next = new ListNode(resultQueue.poll(), null);
            curr = curr.next;
        }

        return resultLinkedList;
    }


}
