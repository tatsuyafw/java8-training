package chapter6.exercise02;

import static utils.BenchMark.benchmark;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int THREAD_NUM = 100;
    private static final int JOB_NUM = 10_000_000;

    /*
     * LongAdder と Atomic ロングの性能比較
     * IDを生成するだけのジョブを複数スレッドで実行した場合どちらが速いか
     * 結果:
     *   スレッドが多い(1000)と LongAdder のほうが速く、逆にスレッドが少ない(10)と AtomicLong のほうが早かった
     * 追記:
     *   練習3と同じようなことを気が付かずにやったしまった...
     */
    public static void main(String[] args) {
        ExecutorService executorForLongAdder = Executors.newFixedThreadPool(THREAD_NUM);
        IDCreator idCreatorWithLongAdder = new IDCreatorWithLongAdder();
        Duration timeElapsedWithLongAdder = benchmark(() -> {
            for (int i = 0; i < JOB_NUM; i++) {
                Job job = new Job(idCreatorWithLongAdder);
                executorForLongAdder.execute(job);
            }
            executorForLongAdder.shutdown();
        });
        System.out.println("Time elapsed with LongAdder: " + timeElapsedWithLongAdder.toMillis());

        ExecutorService executorForAtomicLong = Executors.newFixedThreadPool(THREAD_NUM);
        IDCreator idCreatorWithAtomicLong = new IDCreatorWithAtomicLong();
        Duration timeElapsedWithAtomicLong = benchmark(() -> {
            for (int i = 0; i < JOB_NUM; i++) {
                Job job = new Job(idCreatorWithAtomicLong);
                executorForAtomicLong.execute(job);
            }
            executorForAtomicLong.shutdown();
        });
        System.out.println("Time elapsed with AtomicLong: " + timeElapsedWithAtomicLong.toMillis());
    }

    /*
     * IDCreator から値を取得するだけのジョブ
     */
    static class Job implements Runnable {
        private IDCreator idCreator;

        Job(IDCreator idCreator) {
            this.idCreator = idCreator;
        }

        @Override
        public void run() {
            idCreator.getId();
        }
    }

}
