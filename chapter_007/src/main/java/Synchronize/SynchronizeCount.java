package Synchronize;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

public class SynchronizeCount {

    @ThreadSafe
    public static class Count implements Runnable {
        @GuardedBy("this")
        int count = 0;

        public synchronized void increment(){
            for (int i = 0; i < 100000; i++) {
                count++;
            }
        }


        @Override
        public void run() {
            increment();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Count c = new Count();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("value is: " + c.count);
    }
}
