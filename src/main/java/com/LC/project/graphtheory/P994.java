package com.LC.project.graphtheory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/4
 */
public class P994 {
    public static void main(String[] args) {

    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int fresh = 0, time = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) fresh++;
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty() && fresh > 0) {
            time++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0], y = cur[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        fresh--;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
        return fresh == 0 ? time : -1;
    }

}
