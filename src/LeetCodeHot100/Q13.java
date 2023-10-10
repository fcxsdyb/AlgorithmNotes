package LeetCodeHot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 22.括号生成
 */

public class Q13 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        dfs(new StringBuffer(), 0, 0, n, res);
        return res;
    }

    public void dfs(StringBuffer sb, int left, int right, int length, List<String>res) {
        if (left == length && right == length) {
            res.add(sb.toString());
            return;
        }

        if (left < right) return;

        if (left < length) {
            sb.append("(");
            dfs(sb, left + 1, right, length, res);
            sb.deleteCharAt(left + right);
        }
        if (right < length) {
            sb.append(")");
            dfs(sb, left, right + 1, length, res);
            sb.deleteCharAt(left + right);
        }
    }

}
