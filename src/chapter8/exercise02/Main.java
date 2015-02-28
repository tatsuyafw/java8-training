package chapter8.exercise02;

public class Main {
    public static void main(String[] args) {
        System.out.println( Math.negateExact(Integer.MAX_VALUE) );
        System.out.println( Math.negateExact(-0) );
        System.out.println( Math.negateExact(Integer.MIN_VALUE) ) ; // オーバーフロー
    }

}
