package Leetcode;

class Solution {
    final static int MAX_AMOUNT = (int) 1e4;

    public int coinChange(int[] coins, int amount) {
        boolean[] makeable = new boolean[MAX_AMOUNT + 1];
        int[] fewestCoins = new int[MAX_AMOUNT + 1];
        makeable[0] = true;
        fewestCoins[0] = 0;

        for (int val = 0; val <= amount; val++) {
            for (int i = 0; i < coins.length; i++) {
                if (coins[i] > val)
                    continue;
                if (makeable[val - coins[i]]) {
                    if (!makeable[val]) {
                        fewestCoins[val] = fewestCoins[val - coins[i]] + 1;
                        makeable[val] = true;
                    } else {
                        fewestCoins[val] = Math.min(fewestCoins[val], fewestCoins[val - coins[i]] + 1);
                    }
                }
            }
        }

        if (makeable[amount])
            return fewestCoins[amount];
        return -1;
    }
}
