package ds.linkedlists.leetcode150;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;
    ListNode random;

    ListNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class LinkedListLeetCode150 {

    public static void main(String[] args) {
        // Test Problem 1: Reverse Linked List
        ListNode head1 = createList(new int[]{0, 1, 2, 3});
        System.out.print("Expected Output: [3, 2, 1, 0] | Actual Output: ");
        head1 = reverseList(head1);
        printList(head1);

        // Test Problem 2: Merge Two Sorted Linked Lists
        ListNode list1 = createList(new int[]{1, 2, 4});
        ListNode list2 = createList(new int[]{1, 3, 5});
        System.out.print("Expected Output: [1, 1, 2, 3, 4, 5] | Actual Output: ");
        ListNode mergedList = mergeTwoLists(list1, list2);
        printList(mergedList);

        // Test Problem 3: Reorder Linked List
        ListNode head3 = createList(new int[]{2, 4, 6, 8});
        System.out.print("Expected Output: [2, 8, 4, 6] | Actual Output: ");
        reorderList(head3);
        printList(head3);

        // Test Problem 4: Remove Nth Node From End of List
        ListNode head4 = createList(new int[]{1, 2, 3, 4});
        System.out.print("Expected Output: [1, 2, 4] | Actual Output: ");
        head4 = removeNthFromEnd(head4, 2);
        printList(head4);

        // Test Problem 5: Copy List with Random Pointer
        ListNode head5 = createListWithRandom(new int[]{3, 7, 4, 5}, new int[]{-1, 3, 0, 1});
        System.out.print("Expected Output: [[3,null],[7,3],[4,0],[5,1]] | Actual Output: ");
        ListNode copiedList = copyRandomList(head5);
        printListWithRandom(copiedList);

        // Test Problem 6: Add Two Numbers
        ListNode l1 = createList(new int[]{1, 2, 3});
        ListNode l2 = createList(new int[]{4, 5, 6});
        System.out.print("Expected Output: [5, 7, 9] | Actual Output: ");
        ListNode sumList = addTwoNumbers(l1, l2);
        printList(sumList);

        // Test Problem 7: Linked List Cycle Detection
        ListNode head7 = createList(new int[]{1, 2, 3, 4});
        createCycle(head7, 1);
        System.out.print("Expected Output: true | Actual Output: ");
        System.out.println(hasCycle(head7));

        // Test cases for Problem 8
        System.out.println(findDuplicate(new int[]{1, 2, 3, 2, 2})); // Output: 2
        System.out.println(findDuplicate(new int[]{1, 2, 3, 4, 4})); // Output: 4

        // Test cases for Problem 9
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 10);
        System.out.println(lRUCache.get(1)); // Output: 10
        lRUCache.put(2, 20);
        lRUCache.put(3, 30);
        System.out.println(lRUCache.get(2)); // Output: 20
        System.out.println(lRUCache.get(1)); // Output: -1

        // Test cases for Problem 10
        ListNode[] lists = new ListNode[]{
                new ListNode(1) {{ next = new ListNode(2) {{ next = new ListNode(4); }}; }},
                new ListNode(1) {{ next = new ListNode(3) {{ next = new ListNode(5); }}; }},
                new ListNode(3) {{ next = new ListNode(6); }}
        };
        mergedList = mergeKLists(lists);
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
        System.out.println(); // Output: 1 1 2 3 3 4 5 6

        // Test cases for Problem 11
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode reversedList = reverseKGroup(head, 3);
        while (reversedList != null) {
            System.out.print(reversedList.val + " ");
            reversedList = reversedList.next;
        }
        System.out.println(); // Output: 3 2 1 6 5 4
    }

    // Helper methods for creating and printing lists
    private static ListNode createList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    private static ListNode createListWithRandom(int[] values, int[] randomIndices) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int i = 0; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            map.put(i, current.next);
            current = current.next;
        }
        current = dummy.next;
        for (int i = 0; i < randomIndices.length; i++) {
            if (randomIndices[i] != -1) {
                current.random = map.get(randomIndices[i]);
            }
            current = current.next;
        }
        return dummy.next;
    }

    private static void printListWithRandom(ListNode head) {
        while (head != null) {
            System.out.print("[" + head.val + "," + (head.random != null ? head.random.val : "null") + "] ");
            head = head.next;
        }
        System.out.println();
    }

    private static void createCycle(ListNode head, int pos) {
        if (pos == -1) return;
        ListNode tail = head;
        ListNode cycleNode = null;
        int index = 0;
        while (tail.next != null) {
            if (index == pos) {
                cycleNode = tail;
            }
            tail = tail.next;
            index++;
        }
        tail.next = cycleNode;
    }

    // Problem 1: Reverse Linked List

    /**
     * Reverse a Linked List
     *
     * Given the beginning of a singly linked list head, reverse the list, and return the new beginning of the list.
     *
     * Example 1:
     *
     * Input: head = [0,1,2,3]
     *
     * Output: [3,2,1,0]
     * Example 2:
     *
     * Input: head = []
     *
     * Output: []
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // Problem 2: Merge Two Sorted Linked Lists
    /**
     * Merge Two Sorted Linked Lists
     * You are given the heads of two sorted linked lists list1 and list2.
     *
     * Merge the two lists into one sorted linked list and return the head of the new sorted linked list.
     *
     * The new list should be made up of nodes from list1 and list2.
     *
     * Input: list1 = [1,2,4], list2 = [1,3,5]
     *
     * Output: [1,1,2,3,4,5]
     * Example 2:
     *
     * Input: list1 = [], list2 = [1,2]
     *
     * Output: [1,2]
     * Example 3:
     *
     * Input: list1 = [], list2 = []
     *
     * Output: []
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
        return dummy.next;
    }

    // Problem 3: Reorder Linked List

    /**
     * Reorder Linked List
     * You are given the head of a singly linked-list.
     *
     * The positions of a linked list of length = 7 for example, can intially be represented as:
     *
     * [0, 1, 2, 3, 4, 5, 6]
     *
     * Reorder the nodes of the linked list to be in the following order:
     *
     * [0, 6, 1, 5, 2, 4, 3]
     *
     * Notice that in the general case for a list of length = n the nodes are reordered to be in the following order:
     *
     * [0, n-1, 1, n-2, 2, n-3, ...]
     *
     * You may not modify the values in the list's nodes, but instead you must reorder the nodes themselves.
     *
     * Example 1:
     *
     * Input: head = [2,4,6,8]
     *
     * Output: [2,8,4,6]
     * Example 2:
     *
     * Input: head = [2,4,6,8,10]
     *
     * Output: [2,10,4,8,6]
     *
     * @param head
     */
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = reverseList(slow.next);
        slow.next = null;
        ListNode first = head;
        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }

    // Problem 4: Remove Nth Node From End of List
    /**
     * Remove Node From End of Linked List
     * You are given the beginning of a linked list head, and an integer n.
     *
     * Remove the nth node from the end of the list and return the beginning of the list.
     *
     * Example 1:
     *
     * Input: head = [1,2,3,4], n = 2
     *
     * Output: [1,2,4]
     * Example 2:
     *
     * Input: head = [5], n = 1
     *
     * Output: []
     * Example 3:
     *
     * Input: head = [1,2], n = 2
     *
     * Output: [2]
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    // Problem 5: Copy List with Random Pointer
    /**
     * Copy Linked List with Random Pointer
     * You are given the head of a linked list of length n. Unlike a singly linked list, each node contains an additional
     * pointer random, which may point to any node in the list, or null.
     *
     * Create a deep copy of the list.
     *
     * The deep copy should consist of exactly n new nodes, each including:
     *
     * The original value val of the copied node
     * A next pointer to the new node corresponding to the next pointer of the original node
     * A random pointer to the new node corresponding to the random pointer of the original node
     * Note: None of the pointers in the new list should point to nodes in the original list.
     *
     * Return the head of the copied linked list.
     *
     * In the examples, the linked list is represented as a list of n nodes. Each node is represented as a pair of [val,
     * random_index] where random_index is the index of the node (0-indexed) that the random pointer points to, or null if
     * it does not point to any node.
     *
     * Example 1:
     *
     *
     *
     * Input: head = [[3,null],[7,3],[4,0],[5,1]]
     *
     * Output: [[3,null],[7,3],[4,0],[5,1]]
     * Example 2:
     *
     *
     *
     * Input: head = [[1,null],[2,2],[3,2]]
     *
     * Output: [[1,null],[2,2],[3,2]]
     *
     * @param head
     * @return
     */
    public static ListNode copyRandomList(ListNode head) {
        if (head == null) return null;
        Map<ListNode, ListNode> map = new HashMap<>();
        ListNode current = head;
        while (current != null) {
            map.put(current, new ListNode(current.val));
            current = current.next;
        }
        current = head;
        while (current != null) {
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);
            current = current.next;
        }
        return map.get(head);
    }

    // Problem 6: Add Two Numbers
    /**
     * Add Two Numbers
     * You are given two non-empty linked lists, l1 and l2, where each represents a non-negative integer.
     *
     * The digits are stored in reverse order, e.g. the number 123 is represented as 3 -> 2 -> 1 -> in the linked list.
     *
     * Each of the nodes contains a single digit. You may assume the two numbers do not contain any leading zero, except
     * the number 0 itself.
     *
     * Return the sum of the two numbers as a linked list.
     *
     * Example 1:
     *
     *
     *
     * Input: l1 = [1,2,3], l2 = [4,5,6]
     *
     * Output: [5,7,9]
     *
     * Explanation: 321 + 654 = 975.
     * Example 2:
     *
     * Input: l1 = [9], l2 = [9]
     *
     * Output: [8,1]
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return dummy.next;
    }

    // Problem 7: Linked List Cycle Detection
    /**
     * Linked List Cycle Detection
     * Given the beginning of a linked list head, return true if there is a cycle in the linked list. Otherwise, return
     * false.
     *
     * There is a cycle in a linked list if at least one node in the list that can be visited again by following the next
     * pointer.
     *
     * Internally, index determines the index of the beginning of the cycle, if it exists. The tail node of the list will
     * set it's next pointer to the index-th node. If index = -1, then the tail node points to null and no cycle exists.
     *
     * Note: index is not given to you as a parameter.
     *
     * Example 1:
     *
     *
     *
     * Input: head = [1,2,3,4], index = 1
     *
     * Output: true
     * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
     *
     * Example 2:
     *
     *
     *
     * Input: head = [1,2], index = -1
     *
     * Output: false
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


    // Problem 1: Find Duplicate Integer
    /**
     * Find Duplicate Integer
     * You are given an array of integers nums containing n + 1 integers. Each integer in nums is in the range [1, n]
     * inclusive.
     *
     * Every integer appears exactly once, except for one integer which appears two or more times. Return the integer that
     * appears more than once.
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,2,2]
     *
     * Output: 2
     * Example 2:
     *
     * Input: nums = [1,2,3,4,4]
     *
     * Output: 4
     *
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }
        return -1; // Should never reach here if input is valid
    }

    // Problem 2: LRU Cache

    /**
     * LRU Cache
     * Implement the Least Recently Used (LRU) cache class LRUCache. The class should support the following operations
     *
     * LRUCache(int capacity) Initialize the LRU cache of size capacity.
     * int get(int key) Return the value cooresponding to the key if the key exists, otherwise return -1.
     * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to
     * the cache. If the introduction of the new pair causes the cache to exceed its capacity, remove the least recently
     * used key.
     * A key is considered used if a get or a put operation is called on it.
     *
     * Ensure that get and put each run in
     * O
     * (
     * 1
     * )
     * O(1) average time complexity.
     *
     * Example 1:
     *
     * Input:
     * ["LRUCache", [2], "put", [1, 10],  "get", [1], "put", [2, 20], "put", [3, 30], "get", [2], "get", [1]]
     *
     * Output:
     * [null, null, 10, null, null, 20, -1]
     *
     * Explanation:
     * LRUCache lRUCache = new LRUCache(2);
     * lRUCache.put(1, 10);  // cache: {1=10}
     * lRUCache.get(1);      // return 10
     * lRUCache.put(2, 20);  // cache: {1=10, 2=20}
     * lRUCache.put(3, 30);  // cache: {2=20, 3=30}, key=1 was evicted
     * lRUCache.get(2);      // returns 20
     * lRUCache.get(1);      // return -1 (not found)
     *
     */
    static class LRUCache {
        private final int capacity;
        private final Map<Integer, Integer> cache;
        private final LinkedHashMap<Integer, Integer> order;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new HashMap<>();
            this.order = new LinkedHashMap<>(capacity, 0.75f, true) {
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    return size() > capacity;
                }
            };
        }

        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }
            order.get(key); // Access to update order
            return cache.get(key);
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                order.get(key); // Access to update order
            } else if (cache.size() >= capacity) {
                int eldestKey = order.keySet().iterator().next();
                cache.remove(eldestKey);
                order.remove(eldestKey);
            }
            cache.put(key, value);
            order.put(key, value);
        }
    }

    /**
     * Merge K Sorted Linked Lists
     * You are given an array of k linked lists lists, where each list is sorted in ascending order.
     *
     * Return the sorted linked list that is the result of merging all of the individual linked lists.
     *
     * Example 1:
     *
     * Input: lists = [[1,2,4],[1,3,5],[3,6]]
     *
     * Output: [1,1,2,3,3,4,5,6]
     * Example 2:
     *
     * Input: lists = []
     *
     * Output: []
     * Example 3:
     *
     * Input: lists = [[]]
     *
     * Output: []
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (!queue.isEmpty()) {
            current.next = queue.poll();
            current = current.next;
            if (current.next != null) {
                queue.add(current.next);
            }
        }
        return dummy.next;
    }

    // Problem 4: Reverse Nodes in K-Group
    /**
     * Reverse Nodes in K-Group
     * You are given the head of a singly linked list head and a positive integer k.
     *
     * You must reverse the first k nodes in the linked list, and then reverse the next k nodes, and so on. If there are
     * fewer than k nodes left, leave the nodes as they are.
     *
     * Return the modified list after reversing the nodes in each group of k.
     *
     * You are only allowed to modify the nodes' next pointers, not the values of the nodes.
     *
     * Example 1:
     *
     *
     *
     * Input: head = [1,2,3,4,5,6], k = 3
     *
     * Output: [3,2,1,6,5,4]
     * Example 2:
     *
     *
     *
     * Input: head = [1,2,3,4,5], k = 3
     *
     * Output: [3,2,1,4,5]
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        int count = 0;
        while (current != null && count != k) {
            current = current.next;
            count++;
        }
        if (count == k) {
            current = reverseKGroup(current, k);
            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = current;
                current = head;
                head = temp;
            }
            head = current;
        }
        return head;
    }

}