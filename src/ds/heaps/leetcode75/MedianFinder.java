package ds.heaps.leetcode75;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    public static void main(String...args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println("Median is " + medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println("Median is " + medianFinder.findMedian());
    }

    PriorityQueue<Integer> smallNumberHeap = null;

    PriorityQueue<Integer> largeNumberHeap = null;

    public MedianFinder() {
        smallNumberHeap = new PriorityQueue<>(Collections.reverseOrder());
        largeNumberHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (smallNumberHeap.isEmpty() || num < smallNumberHeap.peek()) {
            smallNumberHeap.add(num);
        } else {
            largeNumberHeap.add(num);
        }

        if (smallNumberHeap.size() - largeNumberHeap.size() > 1) {
            largeNumberHeap.add(smallNumberHeap.poll());
        }
        if (largeNumberHeap.size() - smallNumberHeap.size() > 1) {
            smallNumberHeap.add(largeNumberHeap.poll());
        }
    }

    public double findMedian() {
        return (smallNumberHeap.size() == largeNumberHeap.size()) ?
                (Double.valueOf(smallNumberHeap.peek()) + Double.valueOf(largeNumberHeap.peek())) / 2.0 :
                (smallNumberHeap.size() > largeNumberHeap.size()) ? Double.valueOf(smallNumberHeap.peek()) :
                        Double.valueOf(largeNumberHeap.peek());
    }
}
