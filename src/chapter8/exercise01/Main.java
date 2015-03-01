package chapter8.exercise01;

public class Main {
    /*
     * 意図があっているか、わからず...
     */
    public static void main(String[] args) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        // オーバーフロー
        System.out.println("# Overflow");
        System.out.println(Integer.MAX_VALUE + Integer.MAX_VALUE);
        System.out.println();

        // 加算
        System.out.println("# Addition");
        System.out.println(Integer.toUnsignedLong(min) + Integer.toUnsignedLong(max)); // 加算
        System.out.println();

        //  減算
        System.out.println("# Subtraction");
        System.out.println(Integer.toUnsignedLong(min) - Integer.toUnsignedLong(max)); // 減算
        System.out.println();

        // 除算
        System.out.println("# Division");
        System.out.println(min / max); // 単純に / を使うと、マイナスになる
        System.out.println(Integer.divideUnsigned(min, max)); // Integer.divideUnsigned を使う
        System.out.println(Integer.toUnsignedLong(min) / Integer.toUnsignedLong(max)); // 予め unsigned int にした場合
        System.out.println();

        // 比較
        System.out.println("# Comparison");
        System.out.println(Integer.compare(min, max));
        System.out.println(Integer.compareUnsigned(min, max));
    }
}
