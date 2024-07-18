package com.fewbug.erodebytes.leetcode.h100.h60_80;

import java.util.*;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/17 11:21
 **/
public class H061 {

    /**
     * 提示：
     * <p>
     * 1 <= numCourses <= 2000
     * 0 <= prerequisites.length <= 5000
     * prerequisites[i].length == 2
     * 0 <= ai, bi < numCourses
     * prerequisites[i] 中的所有课程对 互不相同
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        Map<Integer, Set<Integer>> depsMap = new HashMap<>();
        for (int[] arr : prerequisites) {
            Set<Integer> set = depsMap.getOrDefault(arr[0], new HashSet<>());
            set.add(arr[1]);
            depsMap.put(arr[0], set);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!depsMap.containsKey(i)) {
                continue;
            }
            Set<Integer> rootDeps = new HashSet<>();
            Set<Integer> used = new HashSet<>();
            findRootDeps(depsMap, rootDeps, used, i);
            if (rootDeps.contains(i)) {
                return false;
            }
        }

        return true;
    }

    private void findRootDeps(Map<Integer, Set<Integer>> depsMap, Set<Integer> rootDeps, Set<Integer> used, int num) {
        if (!depsMap.containsKey(num) || used.contains(num)) {
            rootDeps.add(num);
            return;
        }
        Set<Integer> parentDeps = depsMap.get(num);
        used.add(num);
        for (Integer parentDependency : parentDeps) {
            findRootDeps(depsMap, rootDeps, used, parentDependency);
        }
        used.remove(num);
    }


    public boolean solution(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        if (len == 0) {
            return true;
        }

        Set<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }

        int[] inDegree = new int[numCourses];
        for (int[] p : prerequisites) {
            inDegree[p[0]]++;
            adj[p[1]].add(p[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int cnt = 0;
        while (!queue.isEmpty()) {
            Integer top = queue.poll();
            cnt++;
            for (Integer successor : adj[top]) {
                inDegree[successor]--;
                if (inDegree[successor] == 0) {
                    queue.add(successor);
                }
            }
        }
        return cnt == numCourses;
    }

    public static void main(String[] args) {
        H061 demo = new H061();
        System.out.println(demo.canFinish(4, new int[][]{{0, 1}, {3, 1}, {1, 3}, {3, 2}}));
        ;
    }

}
