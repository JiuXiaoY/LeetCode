package com.LC.project.lookback;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/5
 */
public class P79 {

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(new P79().exist(board, "ABCCED")); // 输出 true
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n]; // 标记访问过的格子

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (word.length() == 1) {
                        return true;
                    }
                    if (dfs(board, word, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true; // 标记当前格子已访问
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int[] d : dir) {
            if (dfs(board, word, i + d[0], j + d[1], index + 1, visited)) {
                return true;
            }
        }

        visited[i][j] = false; // 回溯，取消标记
        return false;
    }
}
