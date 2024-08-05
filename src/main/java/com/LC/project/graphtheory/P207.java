package com.LC.project.graphtheory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/4
 */
public class P207 {
    public static void main(String[] args) {

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(graph, visited, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(List<List<Integer>> graph, int[] visited, int i) {
        if (visited[i] == 1) {
            return true;
        }
        if (visited[i] == 2) {
            return false;
        }
        visited[i] = 1;
        for (int j : graph.get(i)) {
            if (dfs(graph, visited, j)) {
                return true;
            }
        }
        visited[i] =2;
        return false;
    }

}
