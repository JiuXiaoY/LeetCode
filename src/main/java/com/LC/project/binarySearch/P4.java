package com.LC.project.binarySearch;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/7
 */
public class P4 {
    public static void main(String[] args) {

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;

        if (total % 2 == 1) {
            // 如果总长度为奇数，返回第 (total / 2 + 1) 小的元素
            return findKth(nums1, nums2, total / 2 + 1);
        } else {
            // 如果总长度为偶数，返回第 (total / 2) 和 (total / 2 + 1) 小的元素的平均值
            return (findKth(nums1, nums2, total / 2) + findKth(nums1, nums2, total / 2 + 1)) / 2.0;
        }
    }

    private int findKth(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int index1 = 0, index2 = 0;

        while (true) {
            // 边界情况
            if (index1 == len1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == len2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, len1) - 1;
            int newIndex2 = Math.min(index2 + half, len2) - 1;
            int pivot1 = nums1[newIndex1];
            int pivot2 = nums2[newIndex2];

            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

}
