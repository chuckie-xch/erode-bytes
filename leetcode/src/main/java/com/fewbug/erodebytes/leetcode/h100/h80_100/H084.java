package com.fewbug.erodebytes.leetcode.h100.h80_100;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/20 15:34
 **/
public class H084 {

    /**
     * 提示：
     * <p>
     * 1 <= s.length <= 30
     * s 由小写英文字母、数字和方括号 '[]' 组成
     * s 保证是一个 有效 的输入。
     * s 中所有整数的取值范围为 [1, 300]
     *
     * @param s
     * @return
     */
    public String decodeString(String s) {
        if (s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int numIndex = i;
                while (s.charAt(numIndex) >= '0' && s.charAt(numIndex) <= '9') {
                    numIndex++;
                }
                int index = numIndex + 1;
                int cnt = 1;
                while (index < s.length() && cnt != 0) {
                    if (s.charAt(index) == '[') {
                        cnt++;
                    } else if (s.charAt(index) == ']') {
                        cnt--;
                    }
                    index++;
                }
                String newStr = decodeString(s.substring(numIndex + 1, index - 1));
                int repeat = 0;
                int factor = 1;
                for (int j = numIndex - 1; j >= i; j--) {
                    repeat += (s.charAt(j) - '0') * factor;
                    factor = 10 * factor;
                }
                for (int j = 1; j <= repeat; j++) {
                    sb.append(newStr);
                }
                i = index;
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }

}
