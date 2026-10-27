package Leetcode;

class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int[] prefMaxH = new int[n];
        int[] suffMaxH = new int[n];

        prefMaxH[0] = height[0];
        suffMaxH[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            prefMaxH[i] = Math.max(prefMaxH[i - 1], height[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            suffMaxH[i] = Math.max(suffMaxH[i + 1], height[i]);
        }

        int maxWater = 0;

        // Type 1: l r, where h[l] <= h[r]
        for (int l = 0; l < n; l++) {
            // Execute bin search to find last "r" satisfies
            // height[l] <= suffMaxH[r]
            int low = l, high = n - 1; // seach [low, high]
            while (low < high) {
                int mid = low + (high - low + 1) / 2;
                // System.out.printf("%d %d %d%n", low, mid, high);
                if (height[l] <= suffMaxH[mid]) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }
            int r = low;

            maxWater = Math.max(maxWater, (r - l) * height[l]);
        }

        // Type 2: l r, where h[l] >= h[r]
        for (int r = n - 1; r >= 0; r--) {
            // Execute bin search to find first "l" satisfies
            // prefMaxH[l] >= height[r]
            int low = 0, high = r; // search [low, high]
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (prefMaxH[mid] >= height[r]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            int l = high;

            maxWater = Math.max(maxWater, (r - l) * height[r]);
        }

        return maxWater;
    }
}
