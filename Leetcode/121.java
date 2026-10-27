package Leetcode;

class Solution {
    public int maxProfit(int[] prices) {
        // 7, 1, 5, 3, 6, 4
        // buy i{th} day -> sell j{th} day,
        // where prices[j] = max(prices[i+1], ..., prices[n])
        // i --> [i + 1, i + 2, i + 3, ..., n-1]

        int[] maxSellPrice = new int[prices.length];
        maxSellPrice[prices.length - 1] = prices[prices.length - 1];
        for (int sellDay = prices.length - 2; sellDay >= 0; sellDay--) {
            maxSellPrice[sellDay] = Math.max(prices[sellDay], maxSellPrice[sellDay + 1]);
        }

        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int buyTodayProfit = maxSellPrice[i] - prices[i];
            maxProfit = Math.max(maxProfit, buyTodayProfit);
        }

        return maxProfit;
    }
}