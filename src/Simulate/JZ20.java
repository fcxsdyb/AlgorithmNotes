package Simulate;

import java.util.*;
import java.lang.*;
import java.util.regex.Pattern;

/**
 * 剑指Offer
 * JZ20 表示数值的字符串
 * 请实现一个函数用来判断字符串str是否表示数值（包括科学计数法的数字，小数和整数）。
 * <p>
 * 科学计数法的数字(按顺序）可以分成以下几个部分:
 * 1.若干空格
 * 2.一个整数或者小数
 * 3.（可选）一个 'e' 或 'E' ，后面跟着一个整数(可正可负)
 * 4.若干空格
 * <p>
 * 小数（按顺序）可以分成以下几个部分：
 * 1.若干空格
 * 2.（可选）一个符号字符（'+' 或 '-'）
 * 3. 可能是以下描述格式之一:
 * 3.1 至少一位数字，后面跟着一个点 '.'
 * 3.2 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 3.3 一个点 '.' ，后面跟着至少一位数字
 * 4.若干空格
 * <p>
 * 整数（按顺序）可以分成以下几个部分：
 * 1.若干空格
 * 2.（可选）一个符号字符（'+' 或 '-')
 * 3. 至少一位数字
 * 4.若干空格
 * <p>
 * <p>
 * 例如，字符串["+100","5e2","-123","3.1416","-1E-16"]都表示数值。
 * 但是["12e","1a3.14","1.2.3","+-5","12e+4.3"]都不是数值。
 * <p>
 * 提示:
 * 1.1 <= str.length <= 25
 * 2.str 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。
 * 3.如果怀疑用例是不是能表示为数值的，可以使用python的print(float(str))去查看
 * 进阶: 空间复杂度O(n), 时间复杂度O(n)
 */

public class JZ20 {

    /**
     * Method 1: Divide all the possible situations to the simple operation.
     */
    //遍历字符串的下标
    private int index = 0;

    //有符号判断
    private boolean integer(String s) {
        if (index < s.length() && (s.charAt(index) == '-' || s.charAt(index) == '+'))
            index++;
        return unsigned_integer(s);
    }

    //无符号数判断
    private boolean unsigned_integer(String s) {
        int temp = index;
        while (index < s.length() && (s.charAt(index) >= '0' && s.charAt(index) <= '9'))
            index++;
        return index > temp;
    }

    public boolean isNumeric1(String str) {
        //先判断空串
        if (str == null || str.length() == 0)
            return false;
        //去除前面的空格
        while (index < str.length() && str.charAt(index) == ' ')
            index++;
        int n = str.length() - 1;
        //去除字符串后面的空格
        while (n >= 0 && str.charAt(n) == ' ')
            n--;
        //限制的长度比下标1
        n++;
        //全是空格情况
        if (n < index)
            return false;
        //判断前面的字符是否是有符号的整数
        boolean flag = integer(str);
        //如果有小数点
        if (index < n && str.charAt(index) == '.') {
            index++;
            //小数点前后有无数字可选
            flag = unsigned_integer(str) || flag;
        }
        //如果有e
        if (index < n && (str.charAt(index) == 'e' || str.charAt(index) == 'E')) {
            index++;
            //e后面必须全是整数
            flag = flag && integer(str);
        }
        //是否字符串遍历结束
        return flag && (index == n);
    }

    /**
     * Method 2: Regular Expression.
     */
    public boolean isNumeric (String str) {
        //正则表达式匹配
        String pattern = "(\\s)*[+-]?((\\d+(\\.(\\d+)?)?)|(\\.\\d+))([Ee][+-]?\\d+)?(\\s)*";
        //根据匹配值返回
        return Pattern.matches(pattern, str);
    }

}
