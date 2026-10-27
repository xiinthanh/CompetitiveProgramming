package Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    private final int MAX_NUM = (int) 1e5;

    public List<List<Integer>> threeSum(int[] nums) {
        // [-1e5, 1e5] --> [0, 2e5]
        int[] appearTime = new int[MAX_NUM * 2 + 1];

        Set<List<Integer>> tripletSet = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            appearTime[ProjectValue(nums[i])] += 1;
        }
        for (int i = 0; i < nums.length; i++) {
            appearTime[ProjectValue(nums[i])] -= 1; // remove from pool

            for (int j = i + 1; j < nums.length; j++) {
                appearTime[ProjectValue(nums[j])] -= 1; // remove from pool

                int sum2 = nums[i] + nums[j];
                if (-MAX_NUM <= sum2 && sum2 <= MAX_NUM) {
                    int thirdValue = -sum2;
                    if (appearTime[ProjectValue(thirdValue)] > 0) {
                        tripletSet.add(Arrays.asList(nums[i], nums[j], thirdValue));
                    }
                }
            }

            // Reset appearTime
            for (int j = i + 1; j < nums.length; j++) {
                appearTime[ProjectValue(nums[j])] += 1;
            }
        }

        return List.copyOf(tripletSet);
    }

    private int ProjectValue(int value) {
        return value + MAX_NUM;
    }
}