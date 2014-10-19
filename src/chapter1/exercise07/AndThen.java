package chapter1.exercise07;

public class AndThen {
    public static Runnable andThen(Runnable firstRunner, Runnable secondRunner)
            throws InterruptedException {
        Thread firstThread = new Thread(firstRunner);
        firstThread.start();
        firstThread.join();

        return new Runnable() {
            public void run() {
                secondRunner.run();
            }
        };
    }

    public static void main(String[] args) {
        try {
            Runnable secondRunner = andThen(() -> {
                System.out.println("First Runner");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.err.println(ex.getMessage());
                }
            }, () -> System.out.println("Second Runner"));
            new Thread(secondRunner).start();
        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
