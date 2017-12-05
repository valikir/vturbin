

public class Time implements Runnable {
    public long start;
    public Thread thread;

    public Time(long start, Thread thread) {
        this.start = start;
        this.thread = thread;
    }

    @Override
    public void run() {
        long elapsedTimeMillis = System.currentTimeMillis() - start;
        while (elapsedTimeMillis < 1000 && thread.isAlive()) {
            elapsedTimeMillis = System.currentTimeMillis() - start;
        }
        if (elapsedTimeMillis >= 1000 && thread.isAlive()) {
            thread.interrupt();
        }
         //   System.out.println(elapsedTimeMillis);
    }

    public static class CountChar implements Runnable {
        String text;

        public CountChar(String text) {
            this.text = text;
        }

        @Override
        public void run() {
            int length = text.length();
            if (Thread.currentThread().isInterrupted()){
                System.out.println("Quit program");
                Runtime.getRuntime().exit(0);
            }
            System.out.println("Text has " + length + " symbols");
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
        Thread t1 = new Thread(new Time(start, t2));
        t1.start();
        t2.start();
    }
}
