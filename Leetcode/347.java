package Leetcode;

import java.util.Arrays;

class Solution {
    final static int MAX_VALUE = (int) 1e4;

    public int[] topKFrequent(int[] nums, int k) {
        int[] freq = new int[MAX_VALUE * 2 + 1];

        for (int i = 0; i < nums.length; i++) {
            freq[TransformValue(nums[i])] += 1;
        }

        Integer[] freqPos = new Integer[MAX_VALUE * 2 + 1];
        for (int val = -MAX_VALUE; val <= MAX_VALUE; val++) {
            int shiftedValue = TransformValue(val);
            freqPos[shiftedValue] = shiftedValue;
        }
        Arrays.sort(freqPos, (x, y) -> Integer.compare(freq[y], freq[x]));

        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = DeformValue(freqPos[i]);
        }
        return topK;
    }

    private int TransformValue(int value) {
        return value + MAX_VALUE;
    }

    private int DeformValue(int value) {
        return value - MAX_VALUE;
    }
}