package com.LC.project.ordinaryarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/7/28
 */
public class P56 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> mergedIntervals = new ArrayList<>();
        for (int[] interval : intervals) {
            // 如果列表为空，或者当前区间的开始时间大于列表中最后一个区间的结束，
            // 则直接将当前区间加入到合并后的区间列表中
            if (mergedIntervals.isEmpty() || mergedIntervals.get(mergedIntervals.size() - 1)[1] < interval[0]) {
                mergedIntervals.add(interval);
            } else {
                // 否则，有重叠部分，需要合并区间
                int lastEntry = mergedIntervals.size() - 1;
                int[] lastInterval = mergedIntervals.get(lastEntry);
                lastInterval[1] = Math.max(lastInterval[1], interval[1]); // 更新结束时间
            }
        }

        // 将List转换为数组返回
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);

    }
}
