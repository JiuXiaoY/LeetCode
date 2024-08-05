package com.LC.project.graphtheory;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/4
 */
public class P200 {
    public static void main(String[] args) {

    }

    public int numIslands(char[][] grid) {
        int islands = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    infect(grid, i, j);
                }
            }
        }
        return islands;
    }

    public void infect(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') {
            return;
        }

        if (grid[i][j] == '0' || grid[i][j] == '2') {
            return;
        }

        grid[i][j] = '2';
        infect(grid, i - 1, j);
        infect(grid, i + 1, j);
        infect(grid, i, j - 1);
        infect(grid, i, j + 1);
    }
}
