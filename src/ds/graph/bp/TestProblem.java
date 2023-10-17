package ds.graph.bp;

import java.util.*;

public class TestProblem {

    static class Node {
        String value;

        Node next;

        Node last;

        List<Node> parents;

        Node(String value) {
            this.value = value;
            this.next = null;
            this.last = this;
            this.parents = new ArrayList<>();
        }

        String getValue() {
            return this.value;
        }

        Node getNext() {
            return this.next;
        }

        Node getLast() {
            return this.last;
        }

        List<Node> getParents() {
            return this.parents;
        }

        void setValue(String value) {
            this.value = value;
        }

        void setNext(Node next) {
            this.next = next;
        }

        void setLast(Node last) {
            this.last = last;
        }

        void setParents(Node parent) {
            this.parents.add(parent);
        }
    }

    static Node getNodeFromMap(Map<String, Node> nodeMap, String key) {
        if (!nodeMap.containsKey(key)) {
            Node tempNode = new Node(key);
            nodeMap.put(key, tempNode);
        }
        return nodeMap.get(key);
    }

    static void isCyclePresent(Node startNode, Node destNode) {
        Node tempNode = destNode;
        while (tempNode != null) {
            if (tempNode == startNode) {
                throw new RuntimeException("cycle detected");
            }
            tempNode = tempNode.next;
        }
    }

    static void createEdge(Node startNode, Node destNode) {
        if (startNode.next != null) {
            throw new RuntimeException("2 out edges");
        }
        startNode.setNext(destNode);
        destNode.setParents(startNode);

        startNode.last = destNode.getLast();
        Queue<Node> queue = new LinkedList<>(startNode.getParents());

        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            tempNode.setLast(destNode.getLast());
            queue.addAll(tempNode.getParents());
        }
    }

    static boolean isIntesectionPresent(List<Node> nodes) {
        Set<Node> lastNodes = new HashSet<>();
        for (Node node : nodes) {
            if (lastNodes.contains(node)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Node> nodeMap = new HashMap<>();

        String input = scan.nextLine();

        while (!"".equals(input)) {
            if (input.contains("->")) {
                String[] inputNodes = input.split("->");

                Node startNode = getNodeFromMap(nodeMap, inputNodes[0]);
                Node destNode = getNodeFromMap(nodeMap, inputNodes[1]);
                isCyclePresent(startNode, destNode);
                createEdge(startNode, destNode);

            } else if (",".equals(input)) {
                String[] nodeKeys = input.split(",");
                List<Node> nodes = new ArrayList<>();
                for (String nodeKey : nodeKeys) {
                    nodes.add(nodeMap.get(nodeKey));
                }
            }
            input = scan.nextLine();
        }
    }
}
