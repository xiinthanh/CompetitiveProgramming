package Leetcode;

class Solution {
    public int sortPermutation(int[] nums) {
        int k = 0;
        boolean isSwapNeeded = false;
        for (int i = 0; i < nums.length; i++) {
            // nums[i] should be i, if not, then nums[i] must be swapped
            // thus, nums[i] & k == k
            // So does every other nums[i1], nums[i2], ...
            // => nums[i1] & nums[i2] & ... = k
            if (nums[i] != i) {
                if (!isSwapNeeded) {
                    isSwapNeeded = true;
                    k = nums[i];
                } else {
                    k &= nums[i];
                }
            }
        }

        return k;
    }
}