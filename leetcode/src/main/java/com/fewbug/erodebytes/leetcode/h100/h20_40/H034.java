package com.fewbug.erodebytes.leetcode.h100.h20_40;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/14 16:02
 **/
public class H034 {

    int[][] directions = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    /**
     * 提示：
     * <p>
     * m == board.length
     * n = board[i].length
     * 1 <= m, n <= 6
     * 1 <= word.length <= 15
     * board 和 word 仅由大小写英文字母组成
     * <p>
     * <p>
     * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int length = word.length();
        if (m * n < length) {
            return false;
        }

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            set.add(word.charAt(i));
        }
        // pruning
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (set.contains(board[i][j])) {
                    set.remove(board[i][j]);
                }
            }
        }
        if (!set.isEmpty()) {
            return false;
        }

        boolean[][] used = new boolean[m][n];
        char firstChar = word.charAt(0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != firstChar) {
                    continue;
                }
                used[i][j] = true;
                if (dfs(board, word, used, m, n, i, j, 1)) {
                    return true;
                }
                used[i][j] = false;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] used, int m, int n, int row, int col, int index) {
        if (index == word.length()) {
            return true;
        }
        for (int i = 0; i < directions.length; i++) {
            int newX = row + directions[i][0];
            int newY = col + directions[i][1];
            if (newX < 0 || newX >= m || newY < 0 || newY >= n) {
                continue;
            }
            if (used[newX][newY]) {
                continue;
            }
            if (board[newX][newY] != word.charAt(index)) {
                continue;
            }
            used[newX][newY] = true;
            if (dfs(board, word, used, m, n, newX, newY, index + 1)) {
                return true;
            }
            used[newX][newY] = false;
        }

        return false;
    }
}
