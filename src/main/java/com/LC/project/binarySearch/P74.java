package com.LC.project.binarySearch;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/6
 */
public class P74 {
    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = row * col - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = matrix[mid / col][mid % col];
            if (midVal == target) return true;
            else if (midVal > target) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
}
