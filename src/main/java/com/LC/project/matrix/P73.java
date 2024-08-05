package com.LC.project.matrix;

import java.util.Arrays;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/7/29
 */
public class P73 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes2(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    temp[i][j] = 1;
                } else temp[i][j] = -1;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0 && temp[i][j] == 1) {
                    for (int k = 0; k < m; k++) {
                        matrix[k][j] = 0;
                    }
                    for (int k = 0; k < n; k++) {
                        matrix[i][k] = 0;
                    }
                }
            }
        }
    }

    public static void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int firstRow = 0;
        int firstCol = 0;

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRow = 1;
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstCol = 1;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRow == 1) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if (firstCol == 1) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
