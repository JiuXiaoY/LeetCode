package com.LC.project.lookback;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/6
 */
public class P51 {
    public static void main(String[] args) {

    }

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] c : board) {
            for (int j = 0; j < n; j++) {
                c[j] = '.';
            }
        }
        backTrack(board, 0);
        return res;
    }

    void backTrack(char[][] board, int row) {
        if (row == board.length) {
            res.add(Array2List(board));
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                backTrack(board, row + 1);
                board[row][col] = '.';
            }
        }
    }

    // 主要是检查当前位置的左边，左上角和右上角是否有皇后
    // 如果有则返回 false，因为当前位置的右边、下边、左下角和右下角都还没有处理，所以一定不存在皇后
    // 而且每一行只能放一个皇后
    boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    List<String> Array2List(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] c : board) {
            list.add(new String(c));
        }
        return list;
    }


}
