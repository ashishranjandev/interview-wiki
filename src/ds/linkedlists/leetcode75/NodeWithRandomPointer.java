package ds.linkedlists.leetcode75;

public class NodeWithRandomPointer {

    int val;
    NodeWithRandomPointer next;
    NodeWithRandomPointer random;

    public NodeWithRandomPointer(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
