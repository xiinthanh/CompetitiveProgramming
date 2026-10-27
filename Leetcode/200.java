package Leetcode;

class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        if (n <= 0)
            return 0;
        int m = grid[0].length;
        if (m <= 0)
            return 0;

        int numberOfIslands = 0;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || grid[i][j] == '0') {
                    continue;
                }
                Flooding(i, j, grid, visited);
                numberOfIslands += 1;
            }
        }
        return numberOfIslands;
    }

    static final int[] FLOOD_I = { -1, 0, 0, 1 };
    static final int[] FLOOD_J = { 0, -1, 1, 0 };

    public static void Flooding(int i, int j, char[][] grid, boolean[][] visited) {
        if (i < 0 || visited.length <= i
                || j < 0 || visited[0].length <= j)
            return;
        if (visited[i][j] || grid[i][j] == '0')
            return;

        visited[i][j] = true;
        for (int floatDirection = 0; floatDirection < FLOOD_I.length; floatDirection++) {
            int newI = i + FLOOD_I[floatDirection];
            int newJ = j + FLOOD_J[floatDirection];
            Flooding(newI, newJ, grid, visited);
        }
    }
}