package chapter1.exercise06;

public interface RunnableEx {
    public void run() throws Exception;
    
    public static Runnable uncheck(RunnableEx runner) {
        return new Runnable() {
            public void run() {
                try {
                    runner.run();
                } catch (Exception ex) {
                    // Nothing to do...
                }
            }
        };
    }
}
