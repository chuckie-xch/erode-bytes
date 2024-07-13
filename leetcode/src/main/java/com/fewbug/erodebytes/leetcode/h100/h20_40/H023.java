package com.fewbug.erodebytes.leetcode.h100.h20_40;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/13 12:09
 **/
public class H023 {

    /**
     * 提示：
     * <p>
     * 1 <= strs.length <= 104
     * 0 <= strs[i].length <= 100
     * strs[i] 仅包含小写字母
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }
        List<List<String>> res = new ArrayList<>();

        int len = strs.length;
        boolean[] used = new boolean[len];

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            for (int j = i + 1; j < len; j++) {
                if (used[j]) {
                    continue;
                }
                if (isValid(strs[i], strs[j])) {
                    used[j] = true;
                    list.add(strs[j]);
                }

            }
            res.add(list);
        }

        return res;
    }

    private boolean isValid(String str, String str1) {
        if (str.length() != str1.length()) {
            return false;
        }
        char[] arr = str.toCharArray();
        char[] arr1 = str1.toCharArray();
        Arrays.sort(arr);
        Arrays.sort(arr1);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr1[i]) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> solution1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<>(map.values());
    }

    public List<List<String>> solution2(String[] strs) {
        Map<String, List<String>> map = Arrays.stream(strs).collect(Collectors.groupingBy(str -> {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }));
        return new ArrayList<>(map.values());
    }
}
