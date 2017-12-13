package Wait_notify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool implements Runnable {
    private int currWork;

    private ThreadPool(int currWork) {
        this.currWork = currWork;
    }

    private void add(Work work) {
        System.out.println("Current work: " + work.count);
    }

    @Override
    public void run() {
        System.out.println("Starting work:" +currWork);
        add(new Work(currWork));
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ended work:" +currWork);
    }

    public class Work {
        int count;

        public Work(int count) {
            this.count = count;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(8);

        for (int i = 0; i < 20; i++) {
          //  executor.submit(new ThreadPool(i));
              Runnable runnable = new ThreadPool(i);
             executor.execute(runnable);
        }

        executor.shutdown();

        executor.awaitTermination(1, TimeUnit.DAYS);
            System.out.println("Work is completed");
    }
}
