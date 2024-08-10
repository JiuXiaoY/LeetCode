package com.LC.project.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/10
 */
public class P118 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(list);
        }
        return res;
    }
}
