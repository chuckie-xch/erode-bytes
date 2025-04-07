package com.fewbug.erodebytes.leetcode.topic.enumerationskill;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chunhang.xch
 * @Description
 * @date 2025/3/25 10:24
 **/
public class Q02 {

    /**
     * 提示：
     *
     * 1 <= cards.length <= 105 <br>
     * 0 <= cards[i] <= 106
     * 
     * @param cards
     * @return
     */
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> position = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < cards.length; i++) {
            Integer lastIndex = position.get(cards[i]);
            if (lastIndex != null) {
                ans = Math.min(ans, i - lastIndex + 1);
            }
            position.put(cards[i], i);
        }
        return Integer.MAX_VALUE == ans ? -1 : ans;
    }
}
