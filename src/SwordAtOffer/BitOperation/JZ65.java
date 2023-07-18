package SwordAtOffer.BitOperation;

/**
 * 剑指Offer
 * JZ65 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号
 * -10 <= 两个数 <= 1000
 * 空间复杂度O(1)，时间复杂度O(1)
 */

public class JZ65 {

    /**
     * Method 1: Bits Operation.
     */
    public int Add1(int num1, int num2) {
        // add表示进位值
        int add = num2;
        // sum表示总和
        int sum = num1;
        // 当不再有进位的时候终止循环
        while (add != 0) {
            // 将每轮的无进位和与进位值做异或求和
            int temp = sum ^ add;
            // 进位值是用与运算产生的
            add = (sum & add) << 1;
            // 更新sum为新的和
            sum = temp;
        }
        return sum;
    }

    /**
     * Method 2: Bits Operation Recursion.
     */
    public int Add2(int num1, int num2) {
        // 递归地求和，也是判断是否有进位值，此时进位值用num2来表示，每轮的结果都存储在num1中
        return num2 != 0 ? Add2(num1 ^ num2, (num1 & num2) << 1) : num1;
    }

}
