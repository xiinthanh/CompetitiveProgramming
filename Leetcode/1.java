package Leetcode;

import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Integer[] numPositions = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numPositions[i] = i;
        }

        Arrays.sort(numPositions, (x, y) -> Integer.compare(nums[x], nums[y]));
        // [left, ..., right]
        // 2 elements nums[i], nums[j] so that nums[i] + nums[j] == target
        // [1, 3, 5, 7, 8], target = 7
        // | |

        int left = 0, right = nums.length - 1;
        while (left < right) {
            // consider using nums[left] to create target, meaning we have to adjust
            // nums[right]
            while (left < right
                    && nums[numPositions[left]] + nums[numPositions[right]] > target) {
                --right;
            }
            if (left >= right)
                break;

            if (nums[numPositions[left]] + nums[numPositions[right]] == target) {
                int[] solution = { numPositions[left], numPositions[right] };
                return solution;
            }

            left += 1;
        }

        int[] emptySolution = { 0, 0 };
        return emptySolution;
    }
}