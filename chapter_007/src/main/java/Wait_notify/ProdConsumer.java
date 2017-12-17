package Wait_notify;

import java.util.LinkedList;

public class ProdConsumer {
    private LinkedList<Integer> list = new LinkedList<>();
    int value;

    private final int LIMIT = 100;
    private final Object lock = new Object();

    public void produce() throws InterruptedException {
            synchronized (lock) {
                while (list.size() == LIMIT) {
                    System.out.println("Queue is full");
                    lock.wait();
                }
                list.push(value++);
                System.out.println("value is: " + value);
                lock.notify();
            }
    }

    public void consume() throws InterruptedException {
            synchronized (lock) {
                while (list.size() == 0) {
                    System.out.println("Queue is empty");
                    lock.wait();
                }
                list.poll();
                value--;
                lock.notifyAll();
            }
    }

    public static void main(String[] args) {
        ProdConsumer prodConsumer = new ProdConsumer();

    new Thread(() -> {
        int i=0;
        try {
            while (i < 1000000) {
                prodConsumer.produce();
                i++;
            }
            } catch(InterruptedException e){
                e.printStackTrace();
            }
    }).start();

        new Thread(() -> {
            int i=0;
            try {
                while (i <1000000) {
                    prodConsumer.consume();
                    i++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
