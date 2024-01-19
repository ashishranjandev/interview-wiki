package algo.dp.leetcode;

import java.util.HashMap;
import java.util.Map;

public class DP_2DProblems {

    public static void main(String[] args) {
        DP_2DProblems dp2DProblems = new DP_2DProblems();
        System.out.println();
        System.out.println("Unique Paths");
        System.out.println("Input is m  = 3 and n = 7");
        System.out.println("Expected output is 28");
        System.out.println(dp2DProblems.uniquePaths(3, 7));

        System.out.println();
        System.out.println("Unique Paths");
        System.out.println("Input is m  = 3 and n = 2");
        System.out.println("Expected output is 3");
        System.out.println(dp2DProblems.uniquePaths(3, 2));

        int[] balloons = new int[] {3, 1, 5, 8};
        System.out.println();
        System.out.println("Burst Balloons");
        System.out.println("Input is [3, 1, 5, 8]");
        System.out.println("Expected output is 3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167");
        System.out.println(dp2DProblems.maxCoins(balloons));

        balloons = new int[] {1, 5};
        System.out.println();
        System.out.println("Burst Balloons");
        System.out.println("Input is [1, 5]");
        System.out.println("Expected output is 10");
        System.out.println(dp2DProblems.maxCoins(balloons));

        int[] coins = new int[] {1, 2, 5};
        System.out.println();
        System.out.println("Coin change 2");
        System.out.println("Input is amount = 5, coins = [1,2,5]");
        System.out.println("5=5");
        System.out.println("5=2+2+1");
        System.out.println("5=2+1+1+1");
        System.out.println("5=1+1+1+1+1");
        System.out.println("Expected output is 4");
        System.out.println(dp2DProblems.change(5, coins));

        coins = new int[] {2};
        System.out.println();
        System.out.println("Coin change 2");
        System.out.println("amount = 3, coins = [2]");
        System.out.println("Expected output is 0");
        System.out.println(dp2DProblems.change(3, coins));

        coins = new int[] {10};
        System.out.println();
        System.out.println("Coin change 2");
        System.out.println("amount = 10, coins = [10]");
        System.out.println("Expected output is 1");
        System.out.println(dp2DProblems.change(10, coins));

        int[] prices = new int[] {1,2,3,0,2};
        System.out.println();
        System.out.println("Best time to buy and sell with cooldown");
        System.out.println("Input is prices = [1,2,3,0,2]");
        System.out.println(" Output would be buy, sell, cooldown, buy, sell");
        System.out.println("Expected output is 3");
        System.out.println(dp2DProblems.maxProfit(prices));

        prices = new int[] {1};
        System.out.println();
        System.out.println("Best time to buy and sell with cooldown");
        System.out.println("Input is prices = [1]");
        System.out.println("Expected output is 0");
        System.out.println(dp2DProblems.maxProfit(prices));

        prices = new int[] {1, 2, 4};
        System.out.println();
        System.out.println("Best time to buy and sell with cooldown");
        System.out.println("Input is prices = [1, 2, 4]");
        System.out.println("Expected output is 3");
        System.out.println(dp2DProblems.maxProfit(prices));

        prices = new int[] {6,1,3,2,4,7};
        System.out.println();
        System.out.println("Best time to buy and sell with cooldown");
        System.out.println("Input is prices = [6,1,3,2,4,7]");
        System.out.println("Expected output is 6");
        System.out.println(dp2DProblems.maxProfit(prices));
    }

    public int uniquePaths(int m, int n) {
        // Grid to get all possible paths from every point
        int[][] grid = new int[m][n];
        grid[m - 1][n - 1] = 1;

        //Fill the last column with 1
        for (int row = 0; row < m; row++) {
            grid[row][n - 1] = 1;
        }
        //Fill the last row with 1
        for (int col = 0; col < n; col++) {
            grid[m - 1][col] = 1;
        }

        // Iterate over the grid from right to left and bottom to top
        // and update the cells with value from right and bottom paths
        for (int row = m - 2; row >= 0; row--) {
            for (int col = n - 2; col >= 0; col--) {
                grid[row][col] = grid[row + 1][col] + grid[row][col + 1];
            }
        }
        return grid[0][0];
    }

    public int maxCoins(int[] nums) {
        Map<String, Integer> cache = new HashMap<>();
        int[] newNums = new int[nums.length + 2];
        newNums[0] = 1;
        newNums[newNums.length - 1] = 1;
        for (int index = 1; index < newNums.length - 1; index++) {
            newNums[index] = nums[index - 1];
        }
        return dfsForMaxCoinsForSubArray(newNums, 1, newNums.length - 2, cache);
    }

    public int dfsForMaxCoinsForSubArray(int[] nums, int left, int right, Map<String, Integer> cache) {
        if (left > right) {
            return 0;
        }
        if(cache.containsKey(left + "," + right)) {
            return cache.get(left + "," + right);
        }
        for (int index = left; index <= right + 1; index++) {
            int coinsIfThisIndexIsPoppedLast = nums[left - 1] * nums[index] * nums[right + 1];
            coinsIfThisIndexIsPoppedLast +=
                    dfsForMaxCoinsForSubArray(nums, left, index - 1, cache)
                            + dfsForMaxCoinsForSubArray(nums, index + 1, right, cache);
            cache.put(left + "," + right, Math.max(cache.getOrDefault(left + "," + right, 0), coinsIfThisIndexIsPoppedLast));
        }
        return cache.get(left + "," + right);
    }

    //TODO: Solve this as unbounded knapsack
    public int change(int amount, int[] coins) {
        Map<String, Integer> cache = new HashMap<>();
        return dfsForCoinChange(0, coins, 0, amount, cache);
    }

    private int dfsForCoinChange(int index, int[] coins, int sum, int amount, Map<String, Integer> cache) {
        if (sum == amount) {
            return 1;
        }
        if (sum > amount) {
            return 0;
        }
        if (index == coins.length) {
            return 0;
        }
        String key = index + "," + sum;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        cache.put(key, dfsForCoinChange(index, coins, sum + coins[index], amount, cache)
                + dfsForCoinChange(index + 1, coins, sum, amount, cache));

        return cache.get(key);
    }

    public int maxProfit(int[] prices) {
        // Buying Condition - can have 2 branches - buy or cooldown
        // Not Buying Condition - can have 2 branches - sell or cooldown
        // Buy -> i + 1
        // Sell -> i + 2

        Map<String, Integer> cache = new HashMap<>();
        return dfsForMaxProfit(0, true, prices, cache);
    }

    private int dfsForMaxProfit(int index, boolean isBuying, int[] prices, Map<String, Integer> cache) {
        if (index >= prices.length) {
            return 0;
        }
        String keyForCache = index + "," + isBuying;
        if (cache.containsKey(keyForCache)) {
            return cache.get(keyForCache);
        }

        int profitForCooldown = dfsForMaxProfit(index + 1, true, prices, cache);
        if (isBuying) {
            int profitForBuy = dfsForMaxProfit(index + 1, false, prices, cache) - prices[index];
            cache.put(keyForCache, Math.max(profitForBuy, profitForCooldown));
        } else {
            int profitForSell = dfsForMaxProfit(index + 2, true, prices, cache) + prices[index];
            cache.put(keyForCache, Math.max(profitForSell, profitForCooldown));
        }

        return cache.get(keyForCache);
    }

}
