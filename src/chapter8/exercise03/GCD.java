package chapter8.exercise03;

/*
 * Integer.MIN_VALUE は unsupported とする (long へのキャストが必要なため)
 */
public class GCD {
    /*
     * Memo: 「明らかにgcd、は負になるべきでありません。」とあるが
     * そうなると、a が負である場合は, gcd(a, 0) = a は満たされない気がする...
     */
    public static void main(String[] args) {
        int a = 24;
        int b = 16;

        System.out.println("gcdWithPercentSymbol: " + gcdWithPercentSymbol(a, b));
        System.out.println("gcdWithPercentSymbol: " + gcdWithPercentSymbol(-a, b));
        System.out.println("gcdWithPercentSymbol: " + gcdWithPercentSymbol(a, -b));
        System.out.println();

        System.out.println("gcdWithFloorMod: " + gcdWithFloorMod(a, b));
        System.out.println("gcdWithFloorMod: " + gcdWithFloorMod(-a, b));
        System.out.println("gcdWithFloorMod: " + gcdWithFloorMod(a, -b));
        System.out.println();

        System.out.println("gcdWithRem: " + gcdWithRem(a, b));
        System.out.println("gcdWithRem: " + gcdWithRem(-a, b));
        System.out.println("gcdWithRem: " + gcdWithRem(a, -b));
        System.out.println();
    }

    public static int gcdWithPercentSymbol(int a, int b) {
        checkUnsupportedValue(a, b);

        if (b == 0) return Math.abs(a);

        return gcdWithPercentSymbol(b, (a % b));
    }

    public static int gcdWithFloorMod(int a, int b) {
        checkUnsupportedValue(a, b);

        if (b == 0) return Math.abs(a);

        return gcdWithFloorMod(b, Math.floorMod(a, b));
    }

    public static int gcdWithRem(int a, int b) {
        checkUnsupportedValue(a, b);
        if (b == 0) return a;
        return gcdWithRem(b, rem(a, b));
    }

    private static int rem(int dividend, int divisor){
        checkUnsupportedValue(dividend, divisor);

        return Integer.remainderUnsigned(Math.abs(dividend), Math.abs(divisor));
    }

    private static void checkUnsupportedValue(int a, int b) {
        if (a == Integer.MIN_VALUE || b == Integer.MIN_VALUE)
            throw new IllegalArgumentException("Integer.MIN_VALUE is an unsupported value.");
    }
}
