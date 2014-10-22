package chapter1.exercise10;

public class MyClass implements AbstractI, AbstractJ { // OK
//public class MyClass implements AbstractI, DefaultJ { // Default method f inherited from DefaultF conflicts.
//public class MyClass implements AbstractI, StaticJ { // OK
//public class MyClass implements DefaultI, AbstractJ { //  Default method f inherited from DefaultI conflicts.
//public class MyClass implements DefaultI, DefaultJ { // Duplicate default methods
//public class MyClass implements DefaultI, StaticJ { // OK
//public class MyClass implements StaticI, AbstractJ { // OK
//public class MyClass implements StaticI, DefaultJ { // OK
//public class MyClass implements StaticI, StaticJ { // OK

    public void f() {
    }

    public static void main(String[] args) {
        new MyClass().f();
    }
}