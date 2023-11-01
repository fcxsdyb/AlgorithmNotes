package LaiOffer.Class10_BitOperation;

/**
 * Bit Operation Basic Question 2: Given a number x, how to set x's kth bit to 0?
 */
public class BitOperation_SetKthTo0 {

    public static void main(String[] args) {
        int x = 7;
        x = setKto0(x, 2);
        System.out.println(x);
    }

    private static int setKto0(int x, int k) {
        int bit_setter = 1;
        bit_setter = bit_setter << k;
        bit_setter = ~bit_setter;
        return x & bit_setter;
    }

}