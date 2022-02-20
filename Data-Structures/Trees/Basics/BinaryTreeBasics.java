import java.util.Stack;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class BinaryTreeBasics {
    Node root;
    Stack<Node> stack = new Stack<Node>();

    BinaryTreeBasics() {
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

    public static void main(String[] args) {
        BinaryTreeBasics tree = new BinaryTreeBasics();
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

        //TODO Iterative Post Order

        
    }

}
