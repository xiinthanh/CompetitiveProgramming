package Leetcode;

class Solution {
    static int[] dailyTemperatures(int[] temperatures) {
        /*
         * answer[i] = number of days have to wait
         * => answer[i] = j - i, where j is the minumum number s.t. i < j & temp[i] <
         * temp[j]
         * => we store nextWarm[i] = j, for each i
         * calculate by for i: n-1 -> 0
         * observation: if (temp[i] < temp[i + 1]) "=>" nextWarm[i] = i + 1 < nextWarm[i
         * + 1]
         * else if (temp[i] == temp[i + 1] "=>" nextWarm[i] = nextWarm[i + 1])
         * else if (temp[i] > temp[i + 1]) "=>" nextWarm[i] >= nextWarm[i + 1]
         * for i, j (i < j, temp[i + 1], ..., temp[j - 1] < temp[i]): if (temp[i] <
         * temp[j]) "=>" nextWarm[i] <= j < nextWarm[j]
         * else if (temp[i] == temp[j]) "=>" nextWarm[i] <= nextWarm[j]
         * else if (temp[i] > temp[j]) "=>" nextWarm[i] >= nextWarm[j]
         *
         * worst case: 50 1 2 3 4 5 6 7 8 9 10 11 12 13 14 => O(1e5 * 100)
         */

        int n = temperatures.length;
        if (n <= 0)
            return new int[] {};

        int[] answer = new int[n];
        int[] nextWarm = new int[n];

        nextWarm[n - 1] = n; // n indicate there is none (out of bound)
        answer[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int j = i + 1;
            nextWarm[i] = n; // default: none
            while (j < n) {
                if (temperatures[i] < temperatures[j]) {
                    nextWarm[i] = j;
                    break;
                } else if (temperatures[i] == temperatures[j]) {
                    nextWarm[i] = nextWarm[j];
                    break;
                } else {
                    j = nextWarm[j];
                }
            }
            // System.out.println(nextWarm[i]);
            answer[i] = ((nextWarm[i] == n) ? 0 : nextWarm[i] - i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] temperatures = new int[] { 30, 60, 90 };
        int[] answer = dailyTemperatures(temperatures);
        for (int i = 0; i < answer.length; i++) {
            System.out.printf("%d ", answer[i]);
        }
    }
}