package LaiOffer.Class10_BitOperation;

/**
 * Bit Operation Basic Question 1: Given a number x, how to set x's kth bit to 1?
 */
public class BitOperation_SetKthTo1 {

    public static void main(String[] args) {
        int x = 7;
        x = setKto1(x, 5);
        System.out.println(x);
    }

    private static int setKto1(int x, int k) {
        int bit_setter = 1;
        bit_setter = bit_setter << k;
        return x | bit_setter;
    }

}
