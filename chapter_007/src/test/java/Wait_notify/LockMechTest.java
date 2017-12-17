package Wait_notify;

import org.junit.Test;

public class LockMechTest {

    LockMech lock = new LockMech();
    private int count;

    @Test
    public int inc() throws InterruptedException {
        lock.lock();
        int newCount = ++count;
        lock.unlock();
        return newCount;
    }

    public static void main(String[] args) throws InterruptedException {
        LockMechTest lockMech = new LockMechTest();
        new Thread(() -> {
            int i= 0;
            try {
                while (i < 100000) {
                    lockMech.inc();
                    System.out.println(lockMech.count + " Thread 1");
                    i++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            int i = 0;
            try {
                 while (i < 100000) {
                    lockMech.inc();
                    System.out.println(lockMech.count + " Thread 2");
                    i++;

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}

