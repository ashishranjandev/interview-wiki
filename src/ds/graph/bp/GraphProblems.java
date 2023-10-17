package ds.graph.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class GraphProblems {

    public static class ListNode {
        private String currValue;

        private ListNode nextNode;

        private ListNode lastNode;

        private List<ListNode> parentNodes;


        public ListNode(String currNodeValue) {
            this.currValue = currNodeValue;
            this.nextNode = null;
            this.lastNode = this;
            parentNodes = new ArrayList<>();
        }

        public void setParentNode(ListNode parentNode) {
            parentNodes.add(parentNode);
        }


        public void setNextNode(ListNode nextNode) {
            this.nextNode = nextNode;
        }


        public void setLastNode(ListNode lastNode) {
            this.lastNode = lastNode;
        }


        public String getCurrValue() {
            return this.currValue;
        }


        public ListNode getNextNode() {
            return this.nextNode;
        }


        public ListNode getLastNode() {
            return this.lastNode;
        }
        public List<ListNode> getParentNodes() {
            return this.parentNodes;
        }
    }


    private static ListNode getListNodeFromMap(Map<String, ListNode> mapValueToNode, String nodeValue) {
        if (mapValueToNode.containsKey(nodeValue)) {
            return mapValueToNode.get(nodeValue);
        }
        ListNode tempNode = new ListNode(nodeValue);
        mapValueToNode.put(nodeValue, tempNode);
        return tempNode;


    }


    private static void detectCycle(ListNode startNode, ListNode destinationNode) {
        ListNode nextNode = destinationNode;
        while (nextNode!= null) {
            if (nextNode.equals(startNode)) {
                throw new RuntimeException("Cycle detected in the graph starting at node " + startNode.getCurrValue());
            }
            nextNode = nextNode.getNextNode();
        }
    }


    private static void updateEdge(ListNode startNode, ListNode destinationNode) {
        if (startNode.getNextNode() != null) {
            throw new RuntimeException("The outdegree of node " + startNode.getCurrValue() + " is greater than 1!!");
        }


        startNode.setNextNode(destinationNode);
        destinationNode.setParentNode(startNode);
        updateLastNodeInParents(destinationNode.getLastNode(), startNode);
    }


    private static void updateLastNodeInParents(ListNode lastNode, ListNode startNode) {
        startNode.setLastNode(lastNode);
        Queue<ListNode> updateLastNodeQueue = new LinkedList<>(startNode.getParentNodes());


        while (!updateLastNodeQueue.isEmpty()) {
            ListNode currParent = updateLastNodeQueue.poll();
            currParent.setLastNode(lastNode);
            updateLastNodeQueue.addAll(currParent.getParentNodes());
        }
    }


    private static boolean detectIntersection(Collection<ListNode> listNodesToCheck) {
        Set<ListNode> lastNodeSet = new HashSet<>();
        for (ListNode listNode:listNodesToCheck) {
            if (lastNodeSet.contains(listNode.getLastNode())) {
                return true;
            }
            lastNodeSet.add(listNode.getLastNode());
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, ListNode> mapValueToNode = new HashMap<>();


        String inputVal = scan.nextLine();
        while (!inputVal.equals("")) {


            if (inputVal.contains("->")) {
                String[] nodeInputVals = inputVal.split("->");


                ListNode startNodeVal, destinationNodeVal;
                startNodeVal = getListNodeFromMap(mapValueToNode, nodeInputVals[0]);
                destinationNodeVal = getListNodeFromMap(mapValueToNode, nodeInputVals[1]);
                detectCycle(startNodeVal, destinationNodeVal);
                updateEdge(startNodeVal, destinationNodeVal);
            } else if (inputVal.contains(",")) {
                Collection<ListNode> listNodesToCheck = Arrays.stream(inputVal.split(","))
                        .map(mapValueToNode::get)
                        .collect(Collectors.toList());
                System.out.println(detectIntersection(listNodesToCheck));
            }
            inputVal = scan.nextLine();
        }
    }
}
