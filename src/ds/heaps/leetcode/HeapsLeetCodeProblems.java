package ds.heaps.leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapsLeetCodeProblems {

    PriorityQueue<Integer> integerPriorityQueue = null;

    Integer size = null;

    public static void main (String[] args) {
        HeapsLeetCodeProblems heapsLeetCodeProblems = new HeapsLeetCodeProblems();
        System.out.println();
        System.out.println("Design a class to find the kth largest element in a stream");
        System.out.println("Input is [[3, [4, 5, 8, 2]]");
        heapsLeetCodeProblems.KthLargest(3, new int[]{4, 5, 8, 2});

        System.out.println("Adding 3");
        System.out.println("Expected output is 4");
        System.out.println("Actual output is " + heapsLeetCodeProblems.add(3));

        System.out.println("Adding 5");
        System.out.println("Expected output is 5");
        System.out.println("Actual output is " + heapsLeetCodeProblems.add(5));

        System.out.println("Adding 10");
        System.out.println("Expected output is 5");
        System.out.println("Actual output is " + heapsLeetCodeProblems.add(10));

        System.out.println("Adding 9");
        System.out.println("Expected output is 8");
        System.out.println("Actual output is " + heapsLeetCodeProblems.add(9));

        System.out.println("Adding 4");
        System.out.println("Expected output is 8");
        System.out.println("Actual output is " + heapsLeetCodeProblems.add(4));

        System.out.println();
        System.out.println("Design a class to find the kth largest element in a stream");
        System.out.println("Input is [[1,[]]");
        heapsLeetCodeProblems.KthLargest(3, new int[]{});

        System.out.println("Adding -3");
        System.out.println("Expected output is 4");
        System.out.println("Actual output is " + heapsLeetCodeProblems.add(-3));

        System.out.println("Adding -2");
        System.out.println("Expected output is 5");
        System.out.println("Actual output is " + heapsLeetCodeProblems.add(-2));

        System.out.println("Adding -4");
        System.out.println("Expected output is 5");
        System.out.println("Actual output is " + heapsLeetCodeProblems.add(-4));

        System.out.println("Adding 0");
        System.out.println("Expected output is 8");
        System.out.println("Actual output is " + heapsLeetCodeProblems.add(0));

        System.out.println("Adding 4");
        System.out.println("Expected output is 8");
        System.out.println("Actual output is " + heapsLeetCodeProblems.add(4));

        System.out.println();
        System.out.println("Design a class to return weight of the last remaining stone");
        System.out.println("Input is [2, 7, 4, 1, 8, 1]");
        System.out.println("Expected output is 1");
        System.out.println("Actual output is " + heapsLeetCodeProblems.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));

        System.out.println();
        System.out.println("Given an integer array nums and an integer k, return the kth largest element in the array.");
        System.out.println("Input is [3,2,1,5,6,4] and  k is 2");
        System.out.println("Expected output is 5");
        System.out.println("Actual Output is " + heapsLeetCodeProblems.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }

    public int lastStoneWeight(int[] stones) {
        Integer weightOfLastStone = stones[0];
        integerPriorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            integerPriorityQueue.add(stones[i]);
        }
        while (!integerPriorityQueue.isEmpty()) {
            int weightOfLargestStone = integerPriorityQueue.poll();
            if (integerPriorityQueue.isEmpty()) {
                return weightOfLargestStone;
            } else {
                int weightOfSecondLargestStone = integerPriorityQueue.poll();
                int weightOfFinalStone = (weightOfLargestStone == weightOfSecondLargestStone) ? 0 :
                        weightOfLargestStone - weightOfSecondLargestStone;
                if (weightOfFinalStone != 0) {
                    integerPriorityQueue.add(weightOfFinalStone);
                }
            }
        }
        return 0;
    }

    public void KthLargest(int k, int[] nums) {
        integerPriorityQueue = new PriorityQueue<>();
        size = k;
        for (int num :  nums) {
            integerPriorityQueue.add(num);
        }
        while (integerPriorityQueue.size() > size) {
            integerPriorityQueue.poll();
        }
    }

    public int add(int val) {
        integerPriorityQueue.add(val);
        while (integerPriorityQueue.size() > size) {
            integerPriorityQueue.poll();
        }
        return (!integerPriorityQueue.isEmpty()) ? integerPriorityQueue.peek() : -1;
    }

    public int findKthLargest(int[] nums, int k) {
        int answer = nums[0];
        integerPriorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            integerPriorityQueue.add(nums[i]);
        }
        System.out.println("Heap is " + integerPriorityQueue);
        for (int i = 0; i < k; i++) {
            answer = integerPriorityQueue.poll();
        }
        return answer;
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Coordinate> coordinatesQueue =
                new PriorityQueue<>(Comparator.comparing(Coordinate::getDistanceFromOrigin).reversed());
        for (int i = 0; i < points.length; i++) {
            coordinatesQueue.add(new Coordinate(points[i][0], points[i][1]));
        }

        while (coordinatesQueue.size() > k) {
            coordinatesQueue.poll();
        }

        int[][] answer = new int[k][2];
        for (int i = 0; i < k; i++) {
            Coordinate coordinate = coordinatesQueue.poll();
            answer[i][0] = coordinate.x;
            answer[i][1] = coordinate.y;
        }
        return answer;
    }

    class Coordinate {
        int x;
        int y;
        int distanceFromOrigin;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
            this.distanceFromOrigin = (x * x) + (y * y);
        }

        public int getDistanceFromOrigin() {
            return distanceFromOrigin;
        }
    }

}
