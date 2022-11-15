package simple;

import java.util.Arrays;

public class ReverseBits {
    public static void main(String[] args) {
        reverseBits(-3);
    }
    public static int reverseBits(int n) {
        String s = Integer.toUnsignedString(n, 2);
        StringBuffer reverse = new StringBuffer(s).reverse();
        return Integer.parseUnsignedInt(reverse.toString(),10);
    }
}
