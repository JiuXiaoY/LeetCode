package com.LC.project.hash;

import java.util.*;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/7/27
 */
public class GroupingOfAllogramWords {
    public static void main(String[] args) {
        String[] list = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(list));
    }

    // 排序之后一定是一样的
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = res.getOrDefault(key, new ArrayList<>());
            list.add(str);
            res.put(key, list);
        }
        return new ArrayList<>(res.values());
    }

}
