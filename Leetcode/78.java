package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    /*
     * nums: unique elements (n <= 10)
     * -> return all possible subsets => 2^n (uniqueness) => backtracking
     * time complexity: O(2^n * n) (*n for storing the subset)
     * memory: O(2^n * n) (the size of the subsets array)
     */
    static List<List<Integer>> subsets(int[] nums) {
        List<Integer> ll = new LinkedList<>();
        List<List<Integer>> results = new ArrayList<>();

        subsetsBacktracking(nums, 0, ll, results);
        return results;
    }

    static void subsetsBacktracking(int[] nums, int pos, List<Integer> set, List<List<Integer>> subsets) {
        int n = nums.length;
        if (pos >= n) {
            // for (int i = 0; i < set.size(); i++) {
            // System.out.printf("%d ", set.get(i));
            // }
            // System.out.println("");
            subsets.add(new ArrayList<>(set));
            return;
        }

        // Take nums[pos]
        set.add(nums[pos]);
        subsetsBacktracking(nums, pos + 1, set, subsets);
        set.removeLast();

        // Don't take nums[pos]
        subsetsBacktracking(nums, pos + 1, set, subsets);
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3 };
        List<List<Integer>> ans = subsets(nums);
        // for (int i = 0; i < ans.size(); i++) {
        // for (int j = 0; j < ans.get(i).size(); j++) {
        // System.out.printf("%d ", ans.get(i).get(j));
        // }
        // System.out.println("");
        // }
        for (List<Integer> row : ans) {
            System.out.println(row);
        }
    }
}
