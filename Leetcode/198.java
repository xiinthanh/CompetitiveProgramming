package Leetcode;

class Solution {
    public int rob(int[] nums) {
        int[][] maxMoney = new int[nums.length][2];
        maxMoney[0][0] = 0;
        maxMoney[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxMoney[i][0] = Math.max(maxMoney[i - 1][1], maxMoney[i - 1][0]);
            maxMoney[i][1] = maxMoney[i - 1][0] + nums[i];
        }

        return Math.max(maxMoney[nums.length - 1][0], maxMoney[nums.length - 1][1]);
    }
}