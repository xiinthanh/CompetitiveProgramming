package Leetcode;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        // 1 2 3 a b c a d e f g b
        // 0 1 2) 3 4 5 2 a b d

        int result = 1, startingPos = 0;
        int[] lastOccur = new int[300];
        for (int i = 0; i < 300; i++) {
            lastOccur[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            int key = (int) s.charAt(i);
            if (lastOccur[key] != -1) {
                // end our previous substring
                result = Math.max(result, (i - 1) - startingPos + 1);
                startingPos = Math.max(startingPos, lastOccur[key] + 1);
            }
            lastOccur[key] = i;
        }

        result = Math.max(result, (s.length() - 1) - startingPos + 1);

        return result;
    }
}