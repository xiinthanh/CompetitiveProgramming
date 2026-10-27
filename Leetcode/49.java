package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        String[] sortedStrs = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            sortedStrs[i] = sortString(strs[i]);
        }

        Integer[] strPositions = new Integer[strs.length];
        for (int i = 0; i < strs.length; i++) {
            strPositions[i] = i;
        }

        Arrays.sort(strPositions,
                (x, y) -> sortedStrs[x].compareTo(sortedStrs[y]));

        List<List<String>> anagramGroups = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            List<String> group = new ArrayList<>();
            group.add(strs[strPositions[i]]);
            while (i + 1 < strs.length
                    && sortedStrs[strPositions[i]].equals(sortedStrs[strPositions[i + 1]])) {
                i++;
                group.add(strs[strPositions[i]]);
            }
            anagramGroups.add(group);
        }
        return anagramGroups;
    }

    private String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
