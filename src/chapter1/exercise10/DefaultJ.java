package chapter1.exercise10;

public interface DefaultJ {
    default void f() {
        System.out.println("DefaultJ");
    }
}
