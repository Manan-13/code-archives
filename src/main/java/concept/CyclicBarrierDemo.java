package concept;

import java.util.concurrent.*;

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        int threadCount = 3;

        CyclicBarrier barrier = new CyclicBarrier(threadCount, () -> {
            System.out.println("All threads reached the barrier, moving to next phase.");
        });

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " reached barrier");
                barrier.await(); // Wait here until all threads reach
                System.out.println(Thread.currentThread().getName() + " passed the barrier");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < threadCount; i++) {
            new Thread(task).start();
        }
    }
}
