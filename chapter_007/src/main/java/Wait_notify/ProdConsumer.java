package Wait_notify;

import java.util.LinkedList;

public class ProdConsumer {
    private LinkedList<Integer> list = new LinkedList<>();
    int value;

    private final int LIMIT = 100;
    private Object lock = new Object();

    public void Produce() throws InterruptedException {
        while (true) {
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
    }

    public void Consume() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                list.poll();
                value--;
                lock.notify();
                while (list.size() == 0) {
                    System.out.println("Queue is empty");
                    lock.wait();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProdConsumer prodConsumer = new ProdConsumer();
    new Thread(() -> {
        try {
            prodConsumer.Produce();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }).start();

        new Thread(() -> {
            try {
                prodConsumer.Consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
