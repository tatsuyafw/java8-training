package chapter8.exercise12;

public class MyMath {

    @TestCase(param=4, expected=24)
    @TestCase(param=0, expected=1)
    @TestCase(param=10, expected=10) // fail
    public static long factorial(int n) {
        if (n < 2) return 1;
        return n * factorial(n - 1);
    }
}
