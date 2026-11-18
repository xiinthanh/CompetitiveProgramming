package Leetcode;

import java.util.HashMap;
import java.util.Map;

class Solution {
    // subarray: [i, j] = sum(a[i], a[i+1], ..., a[j])
    // brute force: O(N * N): for i -> for j, sum[i, j] = prefix sum
    // considering: sliding window? prob no, cause a[i] can be negative.
    // considering: count[value] ? k is too big (1e7)
    // considering: hash map -> possible
    // find [l, r] s.t. sum(a[i], ..., a[j]) = k
    // -> for r (fix r) O(N):
    // count the number of l (l <= r) s.t. sum(a[l], ..., a[r]) = k (1)
    // for every r, we have a "map[value] = the number of l satisfy
    // sum(a[l], ..., a[r]) = value"
    // => (1) = map[k]
    // how to maintain map[value] in less than O(logN)?
    // use prefix sum:
    // sum(a[l], ..., a[r]) = prefsum[r] - prefsum[l - 1]
    // -> for r (fix r) O(N):
    // count the number of l (l <= r) s.t. prefsum[r] - prefsum[l - 1] = k (2)
    // => prefsum[r] - k = prefsum[l - 1]
    // for every r, we have a "mapCount[value] = the number of l satisfy
    // prefsum[l] = value"
    // => (2) = mapCount[prefsum[r] - k]
    // update mapCount in O(1) (expected)
    // => solve
    public int subarraySum(int[] nums, int k) {
        if (nums.length <= 0)
            return 0;

        Map<Integer, Integer> mapCount = new HashMap<>();
        int[] prefsum = new int[nums.length];

        prefsum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefsum[i] = prefsum[i - 1] + nums[i];
        }

        int nSubsequences = 0;
        mapCount.put(0, 1); // init l = 0
        for (int r = 0; r < nums.length; r++) {
            nSubsequences += mapCount.getOrDefault(prefsum[r] - k, 0);
            // update l = r + 1
            mapCount.put(prefsum[r], mapCount.getOrDefault(prefsum[r], 0) + 1);
        }

        return nSubsequences;
    }
}