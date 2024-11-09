package ds.linkedlists.workbook;

/**
 * Popular Linked list questions
 *
 * Reverse a Linked List
 * Middle of the Linked List
 * Delete Node in a Linked List
 * Merge Two Sorted Linked List
 * Remove duplicates from sorted list
 * Intersection of two linked list
 * Linked List Cycle
 * Palindrome Linked List
 * Swapping Nodes in a Linked List
 * Odd Even Linked List
 * Remove nth node from Linked List
 * Add Two Numbers
 * Swap Nodes in Pairs
 * Split Linked List in Parts
 * Insertion sort on Linked List
 * Merge sort on Linked List
 * Copy list with random pointers
 * Remove zero sum from consecutive nodes from linked list
 * Merge k sorted Linked List
 * Reverse nodes in k group
 * Doubly Linked List
 * Adding a node at the front, at the end, after a node or before a node
 * Deleting a node from the front, from the end, after a node or before a node
 * Circular Doubly Linked List
 * Adding a node at the front, at the end, after a node or before a node
 * Deleting a node from the front, from the end, after a node or before a node
 * LRU Cache
 * LFU Cache
 *
 */
public class LinkedList {
    public static void main(String[] args) {
        LinkedList solution = new LinkedList();

        // Test case 1: No cycle
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);
        System.out.println("Test case 1 (No cycle): " + solution.hasCycle(head1) + " (Expected: false)");

        // Test case 2: Cycle at node 1
        ListNode head2 = new ListNode(3);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(0);
        head2.next.next.next = new ListNode(-4);
        head2.next.next.next.next = head2.next; // Creating a cycle
        System.out.println("Test case 2 (Cycle at node 1): " + solution.hasCycle(head2) + " (Expected: true)");

        // Test case 3: Single node, no cycle
        ListNode head3 = new ListNode(1);
        System.out.println("Test case 3 (Single node, no cycle): " + solution.hasCycle(head3) + " (Expected: false)");

        // Test case 4: Single node, cycle
        ListNode head4 = new ListNode(1);
        head4.next = head4; // Creating a cycle
        System.out.println("Test case 4 (Single node, cycle): " + solution.hasCycle(head4) + " (Expected: true)");

        // Test case 5: Longer list, no cycle
        ListNode head5 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head5.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println("Test case 5 (Longer list, no cycle): " + solution.hasCycle(head5) + " (Expected: false)");

        // Test case 6: Longer list, cycle
        ListNode head6 = new ListNode(1);
        ListNode node6_2 = new ListNode(2);
        ListNode node6_3 = new ListNode(3);
        ListNode node6_4 = new ListNode(4);
        head6.next = node6_2;
        node6_2.next = node6_3;
        node6_3.next = node6_4;
        node6_4.next = node6_2; // Creating a cycle
        System.out.println("Test case 6 (Longer list, cycle): " + solution.hasCycle(head6) + " (Expected: true)");

        // Test case 1: Both lists are empty
        ListNode list1_1 = null;
        ListNode list1_2 = null;
        ListNode merged1 = solution.mergeTwoLists(list1_1, list1_2);
        System.out.print("Test case 1: ");
        printList(merged1); // Expected: null

        // Test case 2: One list is empty
        ListNode list2_1 = new ListNode(1);
        ListNode list2_2 = null;
        ListNode merged2 = solution.mergeTwoLists(list2_1, list2_2);
        System.out.print("Test case 2: ");
        printList(merged2); // Expected: 1 -> null

        // Test case 3: Both lists have one element
        ListNode list3_1 = new ListNode(1);
        ListNode list3_2 = new ListNode(2);
        ListNode merged3 = solution.mergeTwoLists(list3_1, list3_2);
        System.out.print("Test case 3: ");
        printList(merged3); // Expected: 1 -> 2 -> null

        // Test case 4: Lists have multiple elements
        ListNode list4_1 = new ListNode(1);
        list4_1.next = new ListNode(3);
        list4_1.next.next = new ListNode(5);

        ListNode list4_2 = new ListNode(2);
        list4_2.next = new ListNode(4);
        list4_2.next.next = new ListNode(6);

        ListNode merged4 = solution.mergeTwoLists(list4_1, list4_2);
        System.out.print("Test case 4: ");
        printList(merged4); // Expected: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null

        // Test case 5: Lists with interleaved elements
        ListNode list5_1 = new ListNode(1);
        list5_1.next = new ListNode(4);
        list5_1.next.next = new ListNode(7);

        ListNode list5_2 = new ListNode(2);
        list5_2.next = new ListNode(3);
        list5_2.next.next = new ListNode(6);

        ListNode merged5 = solution.mergeTwoLists(list5_1, list5_2);
        System.out.print("Test case 5: ");
        printList(merged5); // Expected: 1 -> 2 -> 3 -> 4 -> 6 -> 7 -> null

        // Test case 1: Remove 1st node from the end in a single node list
        ListNode list1 = new ListNode(1);
        ListNode result1 = solution.removeNthFromEnd(list1, 1);
        System.out.print("Test case 1: ");
        printList(result1); // Expected: null

        // Test case 2: Remove 2nd node from the end in a two node list
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(2);
        ListNode result2 = solution.removeNthFromEnd(list2, 2);
        System.out.print("Test case 2: ");
        printList(result2); // Expected: 2 -> null

        // Test case 3: Remove 1st node from the end in a two node list
        ListNode list3 = new ListNode(1);
        list3.next = new ListNode(2);
        ListNode result3 = solution.removeNthFromEnd(list3, 1);
        System.out.print("Test case 3: ");
        printList(result3); // Expected: 1 -> null

        // Test case 4: Remove 3rd node from the end in a five node list
        ListNode list4 = new ListNode(1);
        list4.next = new ListNode(2);
        list4.next.next = new ListNode(3);
        list4.next.next.next = new ListNode(4);
        list4.next.next.next.next = new ListNode(5);
        ListNode result4 = solution.removeNthFromEnd(list4, 3);
        System.out.print("Test case 4: ");
        printList(result4); // Expected: 1 -> 2 -> 4 -> 5 -> null

        // Test case 5: Remove 1st node from the end in a five node list
        ListNode list5 = new ListNode(1);
        list5.next = new ListNode(2);
        list5.next.next = new ListNode(3);
        list5.next.next.next = new ListNode(4);
        list5.next.next.next.next = new ListNode(5);
        ListNode result5 = solution.removeNthFromEnd(list5, 1);
        System.out.print("Test case 5: ");
        printList(result5); // Expected: 1 -> 2 -> 3 -> 4 -> null

        // Test case 6: Remove 5th node from the end in a five node list
        ListNode list6 = new ListNode(1);
        list6.next = new ListNode(2);
        list6.next.next = new ListNode(3);
        list6.next.next.next = new ListNode(4);
        list6.next.next.next.next = new ListNode(5);
        ListNode result6 = solution.removeNthFromEnd(list6, 5);
        System.out.print("Test case 6: ");
        printList(result6); // Expected: 2 -> 3 -> 4 -> 5 -> null

        // Test Case 1
        ListNode l1_1 = buildLinkedList(new int[]{2, 4, 3});
        ListNode l2_1 = buildLinkedList(new int[]{5, 6, 4});
        result1 = solution.addTwoNumbers(l1_1, l2_1);
        printList(result1); // Expected Output: 7 -> 0 -> 8

        // Test Case 2
        ListNode l1_2 = buildLinkedList(new int[]{0});
        ListNode l2_2 = buildLinkedList(new int[]{0});
        result2 = solution.addTwoNumbers(l1_2, l2_2);
        printList(result2); // Expected Output: 0

        // Test Case 3
        ListNode l1_3 = buildLinkedList(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2_3 = buildLinkedList(new int[]{9, 9, 9, 9});
        result3 = solution.addTwoNumbers(l1_3, l2_3);
        printList(result3); // Expected Output: 8 -> 9 -> 9 -> 9 -> 0 -> 0 -> 0 -> 1

        Node head1List = buildRandomLinkedList(new int[][]{{7, -1}});
        Node result1List = solution.copyRandomList(head1List);
        printRandomLinkedList(result1List); // Expected Output: [7, -1] (value and random pointer should be copied)

        // Test Case 2: Multiple nodes with random pointers
        Node head2List = buildRandomLinkedList(new int[][]{{1, 1}, {2, 1}, {3, 2}});
        Node result2List = solution.copyRandomList(head2List);
        printRandomLinkedList(result2List); // Expected Output: [1, 1] -> [2, 1] -> [3, 2] (-1 random pointers should be updated)

        // Test Case 3: Large list with random pointers
        Node head3List = buildRandomLinkedList(new int[][]{{3, 1}, {5, 0}, {7, 2}, {9, 3}, {2, 1}});
        Node result3List = solution.copyRandomList(head3List);
        printRandomLinkedList(result3List); // Expected Output: [3, 1] -> [5, 0] -> [7, 2] -> [9, 3] -> [2, 1] (-1 random pointers should be updated)

        // Test Case 1: Rotate by 2 places
        ListNode head1ListToBeRotated = buildLinkedList(new int[]{1, 2, 3, 4, 5});
        int k1 = 2;
        ListNode result1Rotated = solution.rotateRight(head1ListToBeRotated, k1);
        printList(result1Rotated); // Expected Output: 4 -> 5 -> 1 -> 2 -> 3

        // Test Case 2: Rotate by 4 places
        ListNode head2ListToBeRotated = buildLinkedList(new int[]{0, 1, 2});
        int k2 = 4;
        ListNode result2Rotated = solution.rotateRight(head2ListToBeRotated, k2);
        printList(result2Rotated); // Expected Output: 2 -> 0 -> 1

        // Test Case 3: Rotate by 0 places
        ListNode head3ListToBeRotated = buildLinkedList(new int[]{1, 2, 3});
        int k3 = 0;
        ListNode result3Rotated = solution.rotateRight(head3ListToBeRotated, k3);
        printList(result3Rotated); // Expected Output: 1 -> 2 -> 3

        // Test Case 4: Rotate by the length of the list
        ListNode head4ListToBeRotated = buildLinkedList(new int[]{1, 2, 3});
        int k4 = 3;
        ListNode result4Rotated = solution.rotateRight(head4ListToBeRotated, k4);
        printList(result4Rotated); // Expected Output: 1 -> 2 -> 3

        // Test Case 5: Empty list
        ListNode head5ListToBeRotated = null;
        int k5 = 2;
        ListNode result5Rotated = solution.rotateRight(head5ListToBeRotated, k5);
        printList(result5Rotated); // Expected Output: null
    }

    static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Helper function to build a linked list from an array
    static ListNode buildLinkedList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper function to build a linked list with random pointers
    public static Node buildRandomLinkedList(int[][] values) {
        Node dummy = new Node(0);
        Node current = dummy;
        Node[] nodes = new Node[values.length];
        for (int i = 0; i < values.length; i++) {
            current.next = new Node(values[i][0]);
            nodes[i] = current.next;
            current = current.next;
        }
        current = dummy.next;
        for (int i = 0; i < values.length; i++) {
            if (values[i][1] >= 0)
                current.random = nodes[values[i][1]];
            current = current.next;
        }
        return dummy.next;
    }

    // Helper function to print the linked list with random pointers
    public static void printRandomLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print("[" + current.val + ", ");
            if (current.random != null)
                System.out.print(current.random.val);
            else
                System.out.print("-1");
            System.out.print("] -> ");
            current = current.next;
        }
        System.out.println("null");
    }


    /**
     * Given the head of a singly linked list, reverse the list, and return the reversed list.
     *
     * Example 1:
     * Input: head = [1,2,3,4,5]
     * Output: [5,4,3,2,1]
     *
     * Example 2:
     * Input: head = [1,2]
     * Output: [2,1]
     *
     * Example 3:
     * Input: head = []
     * Output: []
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        return null;
    }

    /**
     * Given head, the head of a linked list, determine if the linked list has a cycle in it.
     *
     * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
     * following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is
     * connected to. Note that pos is not passed as a parameter.
     *
     * Return true if there is a cycle in the linked list. Otherwise, return false.
     *
     * Input: head = [3,2,0,-4], pos = 1
     * Output: true
     * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
     *
     * Input: head = [1,2], pos = 0
     * Output: true
     * Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
     *
     * Input: head = [1], pos = -1
     * Output: false
     * Explanation: There is no cycle in the linked list.
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        return false;
    }

    /**
     * You are given the heads of two sorted linked lists list1 and list2.
     *
     * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two
     * lists.
     *
     * Return the head of the merged linked list.
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return null;
    }

    /**
     * Given the head of a linked list, remove the nth node from the end of the list and return its head.
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return null;
    }

    /**
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
     * order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     * Input: l1 = [2,4,3], l2 = [5,6,4]
     * Output: [7,0,8]
     * Explanation: 342 + 465 = 807.
     * Example 2:
     *
     * Input: l1 = [0], l2 = [0]
     * Output: [0]
     * Example 3:
     *
     * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * Output: [8,9,9,9,0,0,0,1]
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return null;
    }

    /**
     * A linked list of length n is given such that each node contains an additional random pointer, which could point to
     * any node in the list, or null.
     *
     * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node
     * has its value set to the value of its corresponding original node. Both the next and random pointer of the new
     * nodes should point to new nodes in the copied list such that the pointers in the original list and copied list
     * represent the same list state. None of the pointers in the new list should point to nodes in the original list.
     *
     * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding
     * two nodes x and y in the copied list, x.random --> y.
     *
     * Return the head of the copied linked list.
     *
     * The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of
     * [val, random_index] where:
     *
     * val: an integer representing Node.val
     * random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not
     * point to any node.
     * Your code will only be given the head of the original linked list.
     *
     * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
     * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
     *
     * Input: head = [[1,1],[2,1]]
     * Output: [[1,1],[2,1]]
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        return null;
    }

    /**
     * Given the head of a linked list, rotate the list to the right by k places.
     *
     * Input: head = [1,2,3,4,5], k = 2
     * Output: [4,5,1,2,3]
     *
     * Input: head = [0,1,2], k = 4
     * Output: [2,0,1]
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        return null;
    }

    /**
     * Given the head of a linked list, return the list after sorting it in ascending order.
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        return null;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode random;

        ListNode(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
