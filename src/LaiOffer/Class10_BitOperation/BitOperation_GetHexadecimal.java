package LaiOffer.Class10_BitOperation;

/**
 * Bit Operation Basic Question 7: Given a number x, how to get the hexadecimal representation of the number in string?
 */
public class BitOperation_GetHexadecimal {

    public static void main(String[] args) {
        int number = 14;
        System.out.println(toHex(number));
    }

    public static String toHex(int num) {
        if (num == 0) {
            return "0x0";
        }

        StringBuilder sb = new StringBuilder();
        char[] hexDigits = "0123456789ABCDEF".toCharArray();

        while (num != 0) {
            int remainder = num & 0xF;  // equivalent to num % 16
            sb.append(hexDigits[remainder]);
            num >>>= 4;  // equivalent to num /= 16 for unsigned right shift
        }

        return "0x" + sb.reverse().toString();
    }

}
