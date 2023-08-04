package LeetCodeHot100;

/**
 * 461.汉明距离
 */

public class Q90 {

    public int hammingDistance(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            ret += s & 1;
            s >>= 1;
        }
        return ret;
    }

}
