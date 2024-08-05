package com.LC.project.matrix;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/7/29
 */
public class P240 {
    public static void main(String[] args) {

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
                if (matrix[i][j] > target) {
                    break;
                }
            }
        }
        return false;
    }

    // 根据右上角元素判断，如果比 target 大，则该列都比他大，如果比他小则该行都比他小
    public static boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;
    }
}
