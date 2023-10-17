package ds.trees.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeLeetCodeProblems {

    public static void main (String...args) {
        TreeLeetCodeProblems treeLeetCodeProblems = new TreeLeetCodeProblems();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2,  new TreeNode(4), new TreeNode(5));
        root.right = new TreeNode(3);

        System.out.println("Input is :");
        System.out.println("Input is :  1  ");
        System.out.println("Input is : 2 3  ");
        System.out.println("Input is :4 5   ");
        System.out.println("Expected Output is 3");
        System.out.println("Actual Output is " + treeLeetCodeProblems.diameterOfBinaryTree(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);

        System.out.println("Input is :  ");
        System.out.println("Input is :        1  ");
        System.out.println("Input is :    2     2  ");
        System.out.println("Input is :  3   3   ");
        System.out.println("Input is : 4 4   ");
        System.out.println("Expected Output is false");
        System.out.println("Actual Output is " + treeLeetCodeProblems.isBalanced(root));


        System.out.println("Actual right side view is " + treeLeetCodeProblems.rightSideView(root));

        root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println("Input is :");
        System.out.println("Input is :  2  ");
        System.out.println("Input is : 1 3  ");
        System.out.println("Expected Output is 2");
        System.out.println("Actual Output is " + treeLeetCodeProblems.lowestCommonAncestor(root, new TreeNode(3),
                                                                                           new TreeNode(1)).val);

        root = new TreeNode(2147483647);
        System.out.println("Input is :");
        System.out.println("Input is :  2147483647  ");
        System.out.println("Input is :  /         \\");
        System.out.println("Input is : null       null  ");
        System.out.println("Expected Output is true");
        System.out.println(treeLeetCodeProblems.isValidBST(root));

        root = new TreeNode(-2147483647);
        root.right = new TreeNode(2147483647);
        System.out.println("Input is :");
        System.out.println("Input is :  -2147483648  ");
        System.out.println("Input is :  /         \\");
        System.out.println("Input is : null       2147483647  ");
        System.out.println("Expected Output is true");
        System.out.println(treeLeetCodeProblems.isValidBST(root));

        root = new TreeNode(2147483647);
        root.right = new TreeNode(2147483647);
        System.out.println("Input is :");
        System.out.println("Input is :  2147483647  ");
        System.out.println("Input is :  /         \\");
        System.out.println("Input is : null       2147483647  ");
        System.out.println("Expected Output is false");
        System.out.println(treeLeetCodeProblems.isValidBST(root));

        root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        System.out.println("Input is :");
        System.out.println("Input is :   2  ");
        System.out.println("Input is :  /  \\");
        System.out.println("Input is : 2    2  ");
        System.out.println("Expected Output is false");
        System.out.println(treeLeetCodeProblems.isValidBST(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Input is :");
        System.out.println("Input is :   1  ");
        System.out.println("Input is :  /  \\");
        System.out.println("Input is : 2    3  ");
        System.out.println("Expected Output for max Path sum is 6");
        System.out.println(treeLeetCodeProblems.maxPathSum(root));

        root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println("Input is :");
        System.out.println("Input is :   -10  ");
        System.out.println("Input is :  /  \\");
        System.out.println("Input is : 9    20  ");
        System.out.println("Input is :      / \\  ");
        System.out.println("Input is :    15    7");
        System.out.println("Expected Output for max Path sum is 42");
        System.out.println(treeLeetCodeProblems.maxPathSum(root));

        root = new TreeNode(-2);
        root.left = new TreeNode(1);
        System.out.println("Input is :");
        System.out.println("Input is :   -2  ");
        System.out.println("Input is :  /  ");
        System.out.println("Input is : 1     ");
        System.out.println("Expected Output for max Path sum is 1");
        System.out.println(treeLeetCodeProblems.maxPathSum(root));

        root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(3);
        System.out.println("Input is :");
        System.out.println("Input is :    1  ");
        System.out.println("Input is :   / \\ ");
        System.out.println("Input is : -2   3  ");
        System.out.println("Expected Output for max Path sum is 4");
        System.out.println(treeLeetCodeProblems.maxPathSum(root));

        root = new TreeNode(-   1);
        root.left = new TreeNode(-2);
        root.left.left = new TreeNode(-6);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(-3);
        root.right.right = new TreeNode(-6);
        System.out.println("Input is :");
        System.out.println("Input is :     -1  ");
        System.out.println("Input is :    / \\ ");
        System.out.println("Input is :  -2   10  ");
        System.out.println("Input is :  /    / \\  ");
        System.out.println("Input is : -6   -3  -6");
        System.out.println("Expected Output for max Path sum is 4");
        System.out.println(treeLeetCodeProblems.maxPathSum(root));
    }


    /**
     * Lowest Common Ancestor would be the one node where the p and q belongs on different sides
     * (i.e. 1 on left and the other on right)
     *
     * We will have to traverse the tree looking for the branch where p and q would be present
     *
     * If we see root.val equal to p.val or q.val
     *   return the root.val as ancestor
     * If we see root.val in between p.val or q.val -> That means the q and p are not in different subtree
     *   return the root.val as ancestor
     * else based on if q and p are smaller than root
     *   call recursively with left subtree
     * else
     * call recursively with right subtree
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (q.val == root.val || p.val == root.val) {
            return root;
        }
        if ((p.val > root.val && q.val < root.val ) || (p.val < root.val && q.val > root.val)) {
            return root;
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return lowestCommonAncestor(root.left, p, q);
        }
    }

    /**
     * Right Size View is  - Last Elements of every level in BFS.
     *
     * Idea is to do BFS and keep adding the last element at every level in the result array
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> treeNodes = new LinkedList<>();
        if (root == null) {
            return result;
        }

        System.out.println("Pushing" + root.val);
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            int lengthOfCurrentLevel = treeNodes.size();
            TreeNode rightMostNode = null;

            for (int i = 0; i < lengthOfCurrentLevel; i++) {
                System.out.println("Popping" + treeNodes.peek().val);
                rightMostNode = treeNodes.poll();
                if (rightMostNode.left != null) {
                    System.out.println("Pushing" + rightMostNode.left.val);
                    treeNodes.add(rightMostNode.left);
                }
                if (rightMostNode.right != null) {
                    System.out.println("Pushing" + rightMostNode.right.val);
                    treeNodes.add(rightMostNode.right);
                }
            }
            if (rightMostNode != null) {
                result.add(rightMostNode.val);
            }
        }
        return result;
    }

    /**
     * Every value is subtree should belong to a range decided by ancestors
     *   If left
     *     it should be less than its root and left and right subtree should be valid
     *   If right
     *     it should be more than its root and left and right subtree should be valid
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, Long lowerBound, Long upperBound) {
        if (node == null) {
            return true;
        }

        boolean numInRange =  ((node.val > lowerBound) && (node.val < upperBound));
        boolean leftInRange = isValidBST(node.left, lowerBound, Long.valueOf(node.val));
        boolean rightInRange = isValidBST(node.right, Long.valueOf(node.val), upperBound);

        return numInRange && leftInRange && rightInRange;
    }


    /**
     * Go with Iterative In-order
     * When the kth element is popped from stack
     *   return that element's value
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> nodeStack = new Stack<>();
        int count = 0;
        TreeNode current = root;
        while (current != null || nodeStack.size() > 0) {
            while (current != null) {
                nodeStack.push(current);
                current = current.left;
            }
            current = nodeStack.pop();
            count++;
            if (count == k) {
                return current.val;
            }
            current = current.right;
        }
        return -1;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[0]);
        int indexInInorder = getIndex(inorder, preorder[0]);
        treeNode.left = buildTree(splitArray(preorder, 1, indexInInorder),
                                  splitArray(inorder, 0, indexInInorder - 1));
        treeNode.right = buildTree(splitArray(preorder, indexInInorder + 1, preorder.length - 1),
                                  splitArray(inorder, indexInInorder + 1, inorder.length - 1));
        return treeNode;
    }

    private int getIndex(int[] arr, int itemToFind) {
        for (int i = 0; i < itemToFind; i++) {
            if (arr[i] == itemToFind) {
                return i;
            }
        }
        return -1;
    }

    private int[] splitArray(int[] array, int start, int end) {
        int[] resultArray = new int[end - start];
        for (int i = 0; i < end - start; i++) {
            resultArray[i] = array[start + i];
        }
        return resultArray;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int height = 0;

        while (!queue.isEmpty()) {
            List<Integer> rowList = new ArrayList<>();
            int nodeSize = queue.size();

            while (nodeSize > 0) {
                TreeNode node = queue.peek();
                queue.remove();
                rowList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                nodeSize--;
            }
            list.add(rowList);
        }
        return list;
    }


    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (isSameTree(root, subRoot)) {
            return true;
        }

        return isSameTree(root.left, subRoot.left) || isSameTree(root.right, subRoot.right);
    }


    /**
     * Tree is same if
     *   value is same
     *   and
     *   left and right subtree is same.
     *
     * return false first
     * if one is null and other is not null
     *
     * if both is null
     * return true
     *
     * if both not null .. compare value and recursively call function for left and right subtree with and condition
     * 
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * The diameter of a tree T is the largest of the following quantities:
     *  the diameter of T’s left subtree.
     *  the diameter of T’s right subtree.
     *  the longest path between leaves that goes through the root of T (this can be computed from the heights of the
     *  subtrees of T)
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int ldiameter = diameterOfBinaryTree(root.left);
            int rdiameter = diameterOfBinaryTree(root.right);

            return Math.max(Math.max(ldiameter, rdiameter), maxDepth(root.left) + maxDepth(root.right));
        }
    }


    /**
     *
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return getHeightIfBalanced(root) != -1;
    }

    public int getHeightIfBalanced(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int lHeight = getHeightIfBalanced(node.left);
        if (lHeight == -1) {
            return -1;
        }
        int rHeight = getHeightIfBalanced(node.right);
        if (rHeight == -1) {
            return -1;
        }
        if (lHeight - rHeight > 1 || rHeight - lHeight > 1) {
            return -1;
        } else {
            return Math.max(lHeight, rHeight) + 1;
        }
    }

    /**
     * Recursively do a Depth-first search.
     * If the tree is empty then return 0
     * Otherwise, do the following
     *  Get the max depth of the left subtree recursively  i.e. call maxDepth( tree->left-subtree)
     *  Get the max depth of the right subtree recursively  i.e. call maxDepth( tree->right-subtree)
     *  Get the max of max depths of left and right subtrees and add 1 to it for the current node.
     *  max_depth = max(max dept of left subtree,  max depth of right subtree) + 1
     * return max_depth.
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int lDepth = maxDepth(root.left);
            int rDepth = maxDepth(root.right);

            if (lDepth > rDepth) {
                return (lDepth + 1);
            } else {
                return (rDepth + 1);
            }
        }
    }


    private Integer max;

    /**
     * We'll have to keep a Global Variable for Max
     *
     * Idea is to have global max and every tree would return its top value without split Max.Of( root+ left or root
     * + right or root.val)
     *  but we will have to replace the max if the value without split is more than max
     *   i.e. if Max.Of( root+ left+right or root+ left or root + right or root.val) is greated than max
     *
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        max = root.val;
        maxPathSumForNode(root);
        return max;
    }

    private int maxPathSumForNode(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            if (node.val  > max) {
                System.out.println(String.format(" Replacing new max - %d with old max - %d",
                                                 (node.val ), max));
                max = node.val;
            }
            return node.val;
        }
        int maxLeft = maxPathSumForNode(node.left);
        int maxRight = maxPathSumForNode(node.right);
        if (Math.max(Math.max(Math.max(node.val + maxLeft, node.val + maxRight), node.val + maxLeft + maxRight),
                     node.val) > max) {
            max = Math.max(Math.max(Math.max(node.val + maxLeft, node.val + maxRight), node.val + maxLeft + maxRight)
                    , node.val);
        }
        return Math.max(Math.max(node.val + maxLeft, node.val + maxRight), 0);
    }

}
