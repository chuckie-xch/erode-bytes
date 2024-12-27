package com.fewbug.erodebytes.leetcode.daily.year24.m12;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/12/9 09:12
 **/
public class Day09 {

    /**
     * 提示：
     *
     * coordinates.length == 2
     * 'a' <= coordinates[0] <= 'h'
     * '1' <= coordinates[1] <= '8'
     * @param coordinates
     * @return
     */
    public boolean squareIsWhite(String coordinates) {
        if (coordinates == null || coordinates.length() != 2) {
            throw new IllegalArgumentException("Invalid Input: coordinates must be a string of length 2");
        }
        char colChar = coordinates.charAt(0);
        char rowChar = coordinates.charAt(1);
        if (colChar < 'a' || colChar > 'h' || rowChar < '1' || rowChar > '8') {
            throw new IllegalArgumentException("Invalid input: coordinates must be within the range 'a1' to 'h8'");
        }
        int col = colChar - 'a';
        int row = rowChar - '1';
        return (row % 2 == 0 && col % 2 != 0) || (row % 2 != 0 && col % 2 == 0);
    }


    public boolean officialSolution(String coordinates) {
        return (coordinates.charAt(0) + coordinates.charAt(1)) % 2 == 1;
    }
}
