

public class Time implements Runnable {
    public long start;
    Thread t2;

    public Time(long start, Thread t2) {
        this.start = start;
        this.t2 = t2;
    }

    @Override
    public void run() {
        long elapsedTimeMillis = System.currentTimeMillis() - start;
        if (elapsedTimeMillis > 1000) {
            t2.interrupt();
        }
        elapsedTimeMillis = System.currentTimeMillis() - start;
        System.out.println(elapsedTimeMillis);
    }

    public static class CountChar implements Runnable {
        String text;

        public CountChar(String text) {
            this.text = text;
        }

        @Override
        public void run() {
            int length = text.length();
            System.out.println("Text has " + length + " symbols");
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Time exceeds 1 second");
            }

        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int replicate = 0;
        String text = "Создать программу,"
                + " которая будет считать количество слов и пробелов в тексте."
                + " Здесь не надо использовать регулярные выражения."
                + " Просто в цикле перебрать символы.";
        while (replicate < 20) {
            text = text + text;
            replicate++;
        }
        Thread t2 = new Thread(new CountChar(text));
        t2.start();
        Thread t1 = new Thread(new Time(start, t2));
        t1.start();
    }
}
