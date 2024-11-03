package ds.trees.leetcode150.workbook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeProblemsLeetCode150 {
    public static void main(String[] args) {
        // Problem 1: Invert Binary Tree
        TreeNode root1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                                      new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        System.out.println("Inverted Tree: " + levelOrderTraversal(invertTree(root1)));

        // Problem 2: Binary Tree Depth
        TreeNode root2 = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), null));
        System.out.println("Depth of Tree: " + maxDepth(root2));

        // Problem 3: Diameter of Binary Tree
        TreeNode root3 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), new TreeNode(4, new TreeNode(5), null)));
        System.out.println("Diameter of Tree: " + diameterOfBinaryTree(root3));

        // Problem 4: Height Balanced Binary Tree
        TreeNode root4 = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), null));
        System.out.println("Is Height Balanced: " + isBalanced(root4));

        // Problem 5: Equivalent Binary Trees
        TreeNode root5a = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), null));
        TreeNode root5b = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), null));
        System.out.println("Are Trees Equivalent: " + isSameTree(root5a, root5b));

        // Problem 6: Subtree of Another Tree
        TreeNode root6 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        TreeNode subRoot6 = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        System.out.println("Is Subtree: " + isSubtree(root6, subRoot6));

        // Problem 7: Lowest Common Ancestor in BST
        TreeNode root7 = new TreeNode(5, new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4)),
                                      new TreeNode(8, new TreeNode(7), new TreeNode(9)));
        TreeNode p7 = root7.left; // Node 3
        TreeNode q7 = root7.right; // Node 8
        System.out.println("LCA: " + lowestCommonAncestor(root7, p7, q7).val);

        // Problem 8: Level Order Traversal
        TreeNode root8 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                                      new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        System.out.println("Level Order Traversal: " + levelOrderTraversal(root8));

        // Problem 9: Right Side View
        TreeNode root9 = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5)));
        System.out.println("Right Side View: " + rightSideView(root9));

        // Problem 10: Valid Binary Search Tree
        TreeNode root10 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println("Is Valid BST: " + isValidBST(root10));

        // Problem 11: Kth Smallest Element in BST
        TreeNode root11 = new TreeNode(4, new TreeNode(3, new TreeNode(2), null), new TreeNode(5));
        System.out.println("Kth Smallest: " + kthSmallest(root11, 3));

        // Problem 12: Construct Binary Tree from Preorder and Inorder Traversal
        int[] preorder = {1, 2, 3, 4};
        int[] inorder = {2, 1, 3, 4};
        TreeNode root12 = buildTree(preorder, inorder);
        System.out.println("Constructed Tree: " + levelOrderTraversal(root12));
    }

    // TreeNode class definition
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode left, TreeNode right) {
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }

    // Problem 1: Invert a Binary Tree
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    // Problem 2: Maximum Depth of Binary Tree
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // Problem 3: Diameter of Binary Tree
    static int diameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        depth(root);
        return diameter;
    }

    private static int depth(TreeNode node) {
        if (node == null) return 0;
        int left = depth(node.left);
        int right = depth(node.right);
        diameter = Math.max(diameter, left + right);
        return 1 + Math.max(left, right);
    }

    // Problem 4: Height Balanced Binary Tree
    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private static int checkHeight(TreeNode root) {
        if (root == null) return 0;
        int left = checkHeight(root.left);
        int right = checkHeight(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }

    // Problem 5: Equivalent Binary Trees
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // Problem 6: Subtree of Another Tree
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Problem 7: Lowest Common Ancestor of a Binary Search Tree
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    // Problem 8: Level Order Traversal
    public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(level);
        }
        return result;
    }

    // Problem 9: Right Side View of Binary Tree
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) result.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return result;
    }

    // Problem 10: Validate Binary Search Tree
    public static boolean isValidBST(TreeNode root) {
        return false;
    }

    public static int kthSmallest(TreeNode root, int k) {
        return -1;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return null;
    }

    public static int maxPathSum(TreeNode root) {
        return -1;
    }

}