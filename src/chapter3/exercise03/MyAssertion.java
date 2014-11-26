package chapter3.exercise03;

import java.util.function.Supplier;

public class MyAssertion {
    enum Status { ENABLE, DISABLE }
    private static Status status = Status.DISABLE;

    public static void setStatus(Status newStatus) {
        status = newStatus;
    }

    public static void myAssert(Supplier<Boolean> assertion) {
        myAssert(assertion, () -> "");
    }

    public static void myAssert(Supplier<Boolean> assertion, Supplier<String> message) {
        if ( status == Status.ENABLE ) {
            if ( ! assertion.get() ) {
                throw new AssertionError(message.get());
            }
        }
    }

    public static void main(String[] args) {
        setStatus(Status.DISABLE);
        myAssert(() -> 1 == 0, () -> "1 == 0");

        setStatus(Status.ENABLE);
        myAssert(() -> 1 == 0, () -> "1 == 0");
    }

}
