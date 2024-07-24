package com.fewbug.erodebytes.leetcode.h100.h80_100;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/20 17:18
 **/
public class H085 {

    public class UnionFind {
        int parent[];
        double weight[];

        public UnionFind(int n) {
            parent = new int[n];
            weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            weight[rootX] = value * weight[y] / weight[x];
        }

        public int find(int x) {
            if (parent[x] != x) {
                int origin = parent[x];
                parent[x] = find(origin);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return weight[x] / weight[y];
            } else {
                return -1d;
            }
        }
    }

    /**
     * 提示：
     *
     * <p>
     * 1 <= equations.length <= 20
     * equations[i].length == 2
     * 1 <= Ai.length, Bi.length <= 5
     * values.length == equations.length
     * 0.0 < values[i] <= 20.0
     * 1 <= queries.length <= 20
     * queries[i].length == 2
     * 1 <= Cj.length, Dj.length <= 5
     * Ai, Bi, Cj, Dj 由小写英文字母与数字组成
     *
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int size = equations.size() * 2;
        UnionFind unionFind = new UnionFind(size);
        Map<String, Integer> map = new HashMap<>();
        int id = 0;
        for (int i = 0; i < equations.size(); i++) {
            String x = equations.get(i).get(0);
            String y = equations.get(i).get(1);
            if (!map.containsKey(x)) {
                map.put(x, id);
                id++;
            }
            if (!map.containsKey(y)) {
                map.put(y, id);
                id++;
            }
            unionFind.union(map.get(x), map.get(y), values[i]);
        }

        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);
            Integer id1 = map.get(x);
            Integer id2 = map.get(y);
            if (id1 == null || id2 == null) {
                ans[i] = -1;
            } else {
                ans[i] = unionFind.isConnected(id1, id2);
            }
        }
        return ans;
    }
}
