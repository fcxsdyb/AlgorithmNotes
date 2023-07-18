package SwordAtOffer.BitOperation;

/**
 * 剑指Offer
 * JZ64 求1+2+3+...+n
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 * 0 <= n <= 200
 * 空间复杂度O(1)，时间复杂度O(n)
 */

public class JZ64 {

    /**
     * Method: Bits Operation.
     */
    public int Sum_Solution(int n) {
        //通过与运算判断n是否为正数，以结束递归
        boolean flag = (n > 1) && ((n += Sum_Solution(n - 1)) > 0);
        return n;
    }

}
