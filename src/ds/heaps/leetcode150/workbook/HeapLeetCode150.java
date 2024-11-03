package ds.heaps.leetcode150.workbook;

import java.util.*;

public class HeapLeetCode150 {

    public static void main(String[] args) {
        // Problem 1: Kth Largest
        KthLargest kthLargest = new KthLargest(3, new int[]{1, 2, 3, 3});
        System.out.println(kthLargest.add(3)); // return 3
        System.out.println(kthLargest.add(5)); // return 3
        System.out.println(kthLargest.add(6)); // return 3
        System.out.println(kthLargest.add(7)); // return 5
        System.out.println(kthLargest.add(8)); // return 6

        // Problem 2: Last Stone Weight
        System.out.println(lastStoneWeight(new int[]{2, 3, 6, 2, 4})); // Output: 1
        System.out.println(lastStoneWeight(new int[]{1, 2})); // Output: 1

        // Problem 3: K Closest Points
        int[][] points1 = {{0, 2}, {2, 2}};
        System.out.println(Arrays.deepToString(kClosest(points1, 1))); // Output: [[0, 2]]

        int[][] points2 = {{0, 2}, {2, 0}, {2, 2}};
        System.out.println(Arrays.deepToString(kClosest(points2, 2))); // Output: [[0, 2], [2, 0]]

        // Problem 4: Kth Largest Element
        System.out.println(findKthLargest(new int[]{2, 3, 1, 5, 4}, 2)); // Output: 4
        System.out.println(findKthLargest(new int[]{2, 3, 1, 1, 5, 5, 4}, 3)); // Output: 4

        // Problem 5: Task Scheduler
        System.out.println(leastInterval(new char[]{'X', 'X', 'Y', 'Y'}, 2)); // Output: 5
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'C'}, 3)); // Output: 9

        // Problem 6: Twitter
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 10); // User 1 posts a new tweet with id = 10.
        twitter.postTweet(2, 20); // User 2 posts a new tweet with id = 20.
        System.out.println(twitter.getNewsFeed(1));   // User 1's news feed should only contain their own tweets -> [10].
        System.out.println(twitter.getNewsFeed(2));   // User 2's news feed should only contain their own tweets -> [20].
        twitter.follow(1, 2);     // User 1 follows user 2.
        System.out.println(twitter.getNewsFeed(
                1));   // User 1's news feed should contain both tweets from user 1 and user 2 -> [20, 10].
        System.out.println(
                twitter.getNewsFeed(2));   // User 2's news feed should still only contain their own tweets -> [20].
        twitter.unfollow(1, 2);   // User 1 unfollows user 2.
        System.out.println(twitter.getNewsFeed(1));   // User 1's news feed should only contain their own tweets -> [10].
    }

    /**
     * Design a class to find the kth largest integer in a stream of values, including duplicates. E.g. the 2nd largest
     * from [1, 2, 3, 3] is 3. The stream is not necessarily sorted.
     *
     * Implement the following methods:
     *
     * constructor(int k, int[] nums) Initializes the object given an integer k and the stream of integers nums.
     * int add(int val) Adds the integer val to the stream and returns the kth largest integer in the stream.
     * Example 1:
     *
     * Input:
     * ["KthLargest", [3, [1, 2, 3, 3]], "add", [3], "add", [5], "add", [6], "add", [7], "add", [8]]
     *
     * Output:
     * [null, 3, 3, 3, 5, 6]
     *
     * Explanation:
     * KthLargest kthLargest = new KthLargest(3, [1, 2, 3, 3]);
     * kthLargest.add(3);   // return 3
     * kthLargest.add(5);   // return 3
     * kthLargest.add(6);   // return 3
     * kthLargest.add(7);   // return 5
     * kthLargest.add(8);   // return 6
     *
     */
    // Problem 1: Kth Largest
    static class KthLargest {
        private PriorityQueue<Integer> minHeap;
        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            minHeap = new PriorityQueue<>();
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            minHeap.offer(val);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
            return minHeap.peek();
        }
    }

    /**
     * You are given an array of integers stones where stones[i] represents the weight of the ith stone.
     *
     * We want to run a simulation on the stones as follows:
     *
     * At each step we choose the two heaviest stones, with weight x and y and smash them togethers
     * If x == y, both stones are destroyed
     * If x < y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
     * Continue the simulation until there is no more than one stone remaining.
     *
     * Return the weight of the last remaining stone or return 0 if none remain.
     *
     * Example 1:
     *
     * Input: stones = [2,3,6,2,4]
     *
     * Output: 1
     * Explanation:
     * We smash 6 and 4 and are left with a 2, so the array becomes [2,3,2,2].
     * We smash 3 and 2 and are left with a 1, so the array becomes [1,2,2].
     * We smash 2 and 2, so the array becomes [1].
     *
     * Example 2:
     *
     * Input: stones = [1,2]
     *
     * Output: 1
     *
     * @param stones
     * @return
     */
    // Problem 2: Last Stone Weight
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            if (stone1 != stone2) {
                maxHeap.offer(stone1 - stone2);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }

    /**
     * You are given an 2-D array points where points[i] = [xi, yi] represents the coordinates of a point on an X-Y axis
     * plane. You are also given an integer k.
     *
     * Return the k closest points to the origin (0, 0).
     *
     * The distance between two points is defined as the Euclidean distance (sqrt((x1 - x2)^2 + (y1 - y2)^2)).
     *
     * You may return the answer in any order.
     *
     * Input: points = [[0,2],[2,2]], k = 1
     *
     * Output: [[0,2]]
     * Explanation : The distance between (0, 2) and the origin (0, 0) is 2. The distance between (2, 2) and the origin is
     * sqrt(2^2 + 2^2) = 2.82842. So the closest point to the origin is (0, 2).
     *
     * Example 2:
     *
     * Input: points = [[0,2],[2,0],[2,2]], k = 2
     *
     * Output: [[0,2],[2,0]]
     *
     * @param points
     * @param k
     * @return
     */
    // Problem 3: K Closest Points
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }

    /**
     * Given an unsorted array of integers nums and an integer k, return the kth largest element in the array.
     *
     * By kth largest element, we mean the kth largest element in the sorted order, not the kth distinct element.
     *
     * Follow-up: Can you solve it without sorting?
     *
     * Example 1:
     *
     * Input: nums = [2,3,1,5,4], k = 2
     *
     * Output: 4
     * Example 2:
     *
     * Input: nums = [2,3,1,1,5,5,4], k = 3
     *
     * Output: 4
     *
     * @param nums
     * @param k
     * @return
     */
    // Problem 4: Kth Largest Element
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    /**
     * You are given an array of CPU tasks tasks, where tasks[i] is an uppercase english character from A to Z. You are
     * also given an integer n.
     *
     * Each CPU cycle allows the completion of a single task, and tasks may be completed in any order.
     *
     * The only constraint is that identical tasks must be separated by at least n CPU cycles, to cooldown the CPU.
     *
     * Return the minimum number of CPU cycles required to complete all tasks.
     *
     * Example 1:
     *
     * Input: tasks = ["X","X","Y","Y"], n = 2
     *
     * Output: 5
     * Explanation: A possible sequence is: X -> Y -> idle -> X -> Y.
     *
     * Example 2:
     *
     * Input: tasks = ["A","A","A","B","C"], n = 3
     *
     * Output: 9
     * Explanation: A possible sequence is: A -> B -> C -> Idle -> A -> Idle -> Idle -> Idle -> A.
     *
     * @param tasks
     * @param n
     * @return
     */
    // Problem 5: Task Scheduler
    public static int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char task : tasks) {
            counts[task - 'A']++;
        }
        Arrays.sort(counts);
        int maxVal = counts[25] - 1;
        int idleSlots = maxVal * n;
        for (int i = 24; i >= 0 && counts[i] > 0; i--) {
            idleSlots -= Math.min(counts[i], maxVal);
        }
        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }

    /**
     *
     Implement a simplified version of Twitter which allows users to post tweets, follow/unfollow each other, and view the 10 most recent tweets within their own news feed.

     Users and tweets are uniquely identified by their IDs (integers).

     Implement the following methods:

     Twitter() Initializes the twitter object.
     void postTweet(int userId, int tweetId) Publish a new tweet with ID tweetId by the user userId. You may assume that each tweetId is unique.
     List<Integer> getNewsFeed(int userId) Fetches at most the 10 most recent tweet IDs in the user's news feed. Each item must be posted by users who the user is following or by the user themself. Tweets IDs should be ordered from most recent to least recent.
     void follow(int followerId, int followeeId) The user with ID followerId follows the user with ID followeeId.
     void unfollow(int followerId, int followeeId) The user with ID followerId unfollows the user with ID followeeId.
     Example 1:

     Input:
     ["Twitter", "postTweet", [1, 10], "postTweet", [2, 20], "getNewsFeed", [1], "getNewsFeed", [2], "follow", [1, 2], "getNewsFeed", [1], "getNewsFeed", [2], "unfollow", [1, 2], "getNewsFeed", [1]]

     Output:
     [null, null, null, [10], [20], null, [20, 10], [20], null, [10]]

     Explanation:
     Twitter twitter = new Twitter();
     twitter.postTweet(1, 10); // User 1 posts a new tweet with id = 10.
     twitter.postTweet(2, 20); // User 2 posts a new tweet with id = 20.
     twitter.getNewsFeed(1);   // User 1's news feed should only contain their own tweets -> [10].
     twitter.getNewsFeed(2);   // User 2's news feed should only contain their own tweets -> [20].
     twitter.follow(1, 2);     // User 1 follows user 2.
     twitter.getNewsFeed(1);   // User 1's news feed should contain both tweets from user 1 and user 2 -> [20, 10].
     twitter.getNewsFeed(2);   // User 2's news feed should still only contain their own tweets -> [20].
     twitter.unfollow(1, 2);   // User 1 follows user 2.
     twitter.getNewsFeed(1);   // User 1's news feed should only contain their own tweets -> [10].
     *
     *
     */
    // Problem 6: Twitter
    static class Twitter {
        private static int timestamp = 0;
        private Map<Integer, Set<Integer>> followees;
        private Map<Integer, List<Tweet>> tweets;

        private static class Tweet {
            int id;
            int time;
            Tweet next;

            public Tweet(int id) {
                this.id = id;
                this.time = timestamp++;
                this.next = null;
            }
        }

        public Twitter() {
            followees = new HashMap<>();
            tweets = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            Tweet tweet = new Tweet(tweetId);
            if (!tweets.containsKey(userId)) {
                tweets.put(userId, new ArrayList<>());
            }
            tweets.get(userId).add(tweet);
        }

        public List<Integer> getNewsFeed(int userId) {
            PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);
            if (tweets.containsKey(userId)) {
                for (Tweet tweet : tweets.get(userId)) {
                    maxHeap.offer(tweet);
                }
            }
            if (followees.containsKey(userId)) {
                for (int followeeId : followees.get(userId)) {
                    if (tweets.containsKey(followeeId)) {
                        for (Tweet tweet : tweets.get(followeeId)) {
                            maxHeap.offer(tweet);
                        }
                    }
                }
            }
            List<Integer> result = new ArrayList<>();
            int count = 0;
            while (!maxHeap.isEmpty() && count < 10) {
                result.add(maxHeap.poll().id);
                count++;
            }
            return result;
        }

        public void follow(int followerId, int followeeId) {
            followees.putIfAbsent(followerId, new HashSet<>());
            followees.get(followerId).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (followees.containsKey(followerId)) {
                followees.get(followerId).remove(followeeId);
            }
        }
    }

}
