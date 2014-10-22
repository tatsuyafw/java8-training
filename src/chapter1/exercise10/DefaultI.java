package chapter1.exercise10;

public interface DefaultI {
    default void f() {
        System.out.println("DefaultI");
    }
}
