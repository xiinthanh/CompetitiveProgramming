package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> x[0] != y[0] ? Integer.compare(x[0], y[0])
                : Integer.compare(x[1], y[1]));

        // l1 r1 l2 r2, overlap only if l2 <= r1
        // l1 l2 r1 r2

        List<int[]> mergedIntervals = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];
            int j = i + 1;
            while (j < intervals.length && intervals[j][0] <= curEnd) {
                curEnd = Math.max(curEnd, intervals[j][1]);
                j++;
            }
            mergedIntervals.add(new int[] { curStart, curEnd });
            i = j - 1;
        }

        return mergedIntervals.toArray(new int[0][]);
    }
}