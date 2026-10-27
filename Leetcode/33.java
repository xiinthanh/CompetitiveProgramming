package Leetcode;

class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[0] > nums[m]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        // [0, l), [l, n)
        int temp;
        if ((temp = binSearch(0, l, nums, target)) != -1) {
            return temp;
        }
        if ((temp = binSearch(l, nums.length, nums, target)) != -1) {
            return temp;
        }
        return -1;
    }

    // [l, r)
    private int binSearch(int l, int r, int[] nums, int target) {
        if (l >= r)
            return -1;

        int m = l + (r - l) / 2;
        if (nums[m] > target) {
            int temp = binSearch(l, m, nums, target);
            if (temp != -1)
                return temp;
        } else if (nums[m] < target) {
            int temp = binSearch(m + 1, r, nums, target);
            if (temp != -1)
                return temp;
        } else
            return m;
        return -1;
    }
}
