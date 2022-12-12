package ds.trees.basics;
import java.util.Stack;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class BinaryTree {
    Node root;
    Stack<Node> stack = new Stack<Node>();

    BinaryTree() {
        root = null;
    }

    void printPostorder(Node node) {
        if (node == null)
            return;
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.key + " ");
    }

    void printInorder(Node node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.key + " ");
        printInorder(node.right);
    }

    void printPreorder(Node node) {
        if (node == null)
            return;
        System.out.print(node.key + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    void printIterativePreOrder(Node node) {
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(node);
        while (!nodeStack.isEmpty()) {
            Node poppedNode = nodeStack.pop();
            System.out.print(poppedNode.key + " ");
            if (poppedNode.right != null) {
                nodeStack.push(poppedNode.right);
            }
            if (poppedNode.left != null) {
                nodeStack.push(poppedNode.left);
            }
        }

    }

    void printIterativeInOrder(Node node) {
        Stack<Node> nodeStack = new Stack<>();
        Node current = node;
        while (current != null || nodeStack.size() > 0) {
            while (current != null) {
                nodeStack.push(current);
                current = current.left;
            }
            current = nodeStack.pop();
            System.out.print(current.key + " ");
            current = current.right;
        }

    }
    
    void printIterativePostOrderUsingTwoStacks(Node node) {
        if (node != null) {
            Stack<Node> nodeStack1 = new Stack<>();
            Stack<Integer> nodeStack2 = new Stack<>();
            Node current;
            nodeStack1.push(node);
            while (nodeStack1.size() > 0) {
                current = nodeStack1.pop();
                nodeStack2.push(current.key);
                if (current != null) {
                    if (current.left != null) {
                        nodeStack1.push(current.left);
                    }
                    if (current.right != null) {
                        nodeStack1.push(current.right);
                    }
                }
            }
            while(!nodeStack2.isEmpty()) {
                System.out.print(nodeStack2.pop() + " ");
            }
        }
    }
    
    /**
     * 1. Put the root in the stack
     * 2. Run the loop till stack is not empty and current is not null
     * 2.1 While current left exists
     *        keep pushing them in stack
     * 2.2 We have reached here .. means current is null i.e. no left subtree to traverse
     *        If Stack is not empty ->
     *          If stack's top has right child
     *              Make that as current
     *          else
     *              Pop the top of Stack -> Print it
     *              while the popped element is the right of element on top of stack
     *                  Keep popping from the stack and keep Printing them
     *                  (as there is nothing left to traverse for those nodes)
     *
     * @param node
     */
    void printIterativePostOrderUsingOneStack(Node node) {
        Stack<Node> nodeStack = new Stack<>();
        Node curr = node;

        // Loop will run till current becomes null and stack becomes empty
        while (curr != null || !nodeStack.isEmpty()) {
            // Till left is not null -> Keep pushing them to the stack
            while (curr != null) {
                nodeStack.push(curr);
                curr = curr.left;
            }

            if (!nodeStack.isEmpty()) {
                //check if stack top has right child - Don't pop it from stack - make current as right
                if (nodeStack.peek().right != null) {
                    curr = nodeStack.peek().right;
                } else {
                    // if top does not have a right child - pop it from stack
                    Node temp = nodeStack.pop();
                    System.out.print(temp.key + " ");
                    // We check if the popped item was right child of the previous item in stack.
                    // If yes -> We need to visit it
                    while (nodeStack.size() > 0 && nodeStack.peek().right == temp) {
                        temp = nodeStack.pop();
                        System.out.print(temp.key + " ");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);


        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder(tree.root);

        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder(tree.root);

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostorder(tree.root);

        System.out.println("\nIterative DFS Pre order traversal of binary tree is ");
        tree.printIterativePreOrder(tree.root);

        System.out.println("\nIterative DFS In order traversal of binary tree is ");
        tree.printIterativeInOrder(tree.root);

        System.out.println("\nIterative DFS Post order traversal of binary tree 2 stack is ");
        tree.printIterativePostOrderUsingTwoStacks(tree.root);
        
        System.out.println("\nIterative DFS Post order traversal of binary tree using 1 stack is ");
        tree.printIterativePostOrderUsingOneStack(tree.root);
    }

}
