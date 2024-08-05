package com.LC.project.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/7/29
 */
public class P54 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int Max = 9999;
        List<Integer> res = new ArrayList<>();
        int posX = 0, posY = 0;

        // 初始方向为向右
        int[][] directions = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
        int dirIndex = 0; // 当前方向索引

        res.add(matrix[0][0]);
        matrix[0][0] = Max;

        while (res.size() < m * n) {
            int nextX = posX + directions[dirIndex][0];
            int nextY = posY + directions[dirIndex][1];

            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && matrix[nextY][nextX] != Max) {
                // 如果下一个位置合法且未访问过，则移动到下一个位置
                res.add(matrix[nextY][nextX]);
                matrix[nextY][nextX] = Max;
                posX = nextX;
                posY = nextY;
            } else {
                // 否则，切换到下一个方向
                dirIndex = (dirIndex + 1) % 4;
            }
        }

        return res;
    }
}
