package chapter8.exercise14;

import java.util.Objects;

/*
 * 役立つエラーメッセージが不明...
 * ラムダ式でメソッド呼び出し時ではなく実行時に...
 */
public class Ex14 {
    private Object field;

    public Ex14(Object field) {
        this.field = Objects.requireNonNull(field, "field must not be null");
        System.out.println(this.field);
    }

    public static void main(String[] args) {
        new Ex14(null);
    }
}
