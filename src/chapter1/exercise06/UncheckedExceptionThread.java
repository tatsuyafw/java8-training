package chapter1.exercise06;

public class UncheckedExceptionThread {
    public static void main(String[] args) {
        new Thread(RunnableEx.uncheck(() -> {
            System.out.println("Zzz");
            Thread.sleep(1000);
            System.out.println("Zzz...");
        })).start();
    }
}
