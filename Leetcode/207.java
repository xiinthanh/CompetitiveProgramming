package Leetcode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Graph, each prerequisite creates an edge
        // If there is a cycle in the graph => cannot complete

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        boolean containCycle = false;
        boolean[] visited = new boolean[numCourses];
        boolean[] onCurrentPath = new boolean[numCourses];

        for (int u = 0; u < numCourses; u++) {
            if (!visited[u]) {
                containCycle |= hasCycle(u, visited, onCurrentPath, adj);
            }
        }

        return !containCycle;

    }

    private boolean hasCycle(int u, boolean[] visited, boolean[] onCurrentPath, List<List<Integer>> adj) {
        if (onCurrentPath[u])
            return true;
        if (visited[u])
            return false;

        visited[u] = true;
        onCurrentPath[u] = true;
        for (Integer v : adj.get(u)) {
            if (hasCycle(v, visited, onCurrentPath, adj)) {
                return true;
            }
        }
        onCurrentPath[u] = false;
        return false;
    }
}
