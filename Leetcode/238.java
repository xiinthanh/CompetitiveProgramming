package Leetcode;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] prefProduct = new int[n];
        int[] suffProduct = new int[n];

        prefProduct[0] = nums[0];
        suffProduct[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            prefProduct[i] = prefProduct[i - 1] * nums[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            suffProduct[i] = suffProduct[i + 1] * nums[i];
        }

        int[] output = new int[n];
        output[0] = suffProduct[1];
        output[n - 1] = prefProduct[n - 2];

        for (int i = 1; i < n - 1; i++) {
            output[i] = prefProduct[i - 1] * suffProduct[i + 1];
        }
        return output;
    }
}
