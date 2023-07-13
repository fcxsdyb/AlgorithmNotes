package Other;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ5 替换空格
 * 请实现一个函数，将一个字符串s中的每个空格替换成“%20”
 * 0 <= s <= 1000
 * 保证字符串中的字符为大写英文字母、小写英文字母和空格中的一种
 */

public class JZ5 {

    /**
     * Method: StringBuilder.
     */
    public String replaceSpace1(String s) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                str.append("%20");
            else
                str.append(s.charAt(i));
        }
        return str.toString();
    }

}
